package com.web.mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.mall.model.AccountVO;
import com.web.mall.model.ItemDTO;
import com.web.mall.model.ItemOptionDTO;
import com.web.mall.model.ItemService;
import com.web.mall.model.Manage_ImageDTO;
import com.web.mall.model.Manage_ImageService;
import com.web.mall.model.Manage_S_Module;
import com.web.mall.model.QuestionService;
import com.web.mall.model.QuestionVO;
import com.web.mall.model.ReviewService;
import com.web.mall.model.ReviewVO;
import com.web.mall.model.ShoppingListService;
import com.web.mall.model.ShoppingListVO;
import com.web.mall.model.SocialAccountVO;
import com.web.mall.model.SoldDetailVO;
import com.web.mall.model.SoldHistoryVO;
import com.web.mall.model.ZzimListVO;
import com.web.mall.model.ZzimService;

@Controller
@RequestMapping(value="/itemDetail")
public class ItemDetailController extends Manage_S_Module {
	@Autowired
	private ItemService itemService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private Manage_ImageService imageService;
	@Autowired
	private ShoppingListService shoppingService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ZzimService zzimService;
	
	@Resource(name="uploadPath")
    String uploadPath;
	
	//구매하기 페이지
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String itemDetailMain(ItemDTO itemDto, ItemOptionDTO optionDto, ZzimListVO zzimVo, Model model, HttpSession session) {
		//item_id 받아와야함.
		System.out.println(itemDto.getItem_id());
		itemDto = itemService.getItemDetail(itemDto);
		System.out.println(itemDto);
		List<ItemOptionDTO> optionList = itemService.getItemOptions(optionDto);
		System.out.println(optionList);
		if((Boolean)session.getAttribute("logined")) {
			if(session.getAttribute("usertype").equals("web")) {
				AccountVO nowAcc = (AccountVO)session.getAttribute("account");
				zzimVo.setAccount_id(nowAcc.getAccount_id());
			}
			else {
				SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
				zzimVo.setAccount_id(nowAcc.getSocial_account_id());
			}
			if(zzimService.getZzim(zzimVo) != null) {
				model.addAttribute("zzim", true);
			}
			else {
				model.addAttribute("zzim", false);
			}
		}
		else {}
		
		model.addAttribute("itemData", itemDto);
		model.addAttribute("optionList", optionList);
		List<Manage_ImageDTO> itemImageList = selectImageList(itemDto.getItem_id(), "ITEM");
		model.addAttribute("itemImageList", itemImageList);
		
		return "user/shop/view";
	}
	//장바구니에 담기 버튼 기능
	@RequestMapping(value="/putCart", method=RequestMethod.GET)
	public String itemPutCart(ShoppingListVO vo, Model model, HttpSession session) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			vo.setAccount_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			vo.setAccount_id(nowAcc.getSocial_account_id());
		}
		if(shoppingService.addShoppingList(vo)) {
			model.addAttribute("result", "장바구니에 정상적으로 저장되었습니다.");
			
		}
		else {
			model.addAttribute("result", "장바구니에 저장을 실패했습니다.");
		}

		return "redirect:/itemDetail?item_id=" + vo.getItem_id();
	}
	
	//구매하기 버튼 누를 시 동작(구매페이지로 이동)
	@RequestMapping(value="/buyItem", method=RequestMethod.GET)
	public String itemBuy(ShoppingListVO vo, Model model, HttpSession session) {
		//item_id, amount, item_option_id 데이터 들어와야함.
		if(session.getAttribute("logined") == null) {
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "로그인되어있지 않습니다. 로그인 해주세요.");
			return "user/shop/review"; //모달창은 어떻게 열어?
		}
		else {
			if(session.getAttribute("usertype").equals("web")) {
				AccountVO nowAcc = (AccountVO)session.getAttribute("account");
				vo.setAccount_id(nowAcc.getAccount_id());
			}
			else {
				SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
				vo.setAccount_id(nowAcc.getSocial_account_id());
			}
			if(shoppingService.addShoppingList(vo)) {
				List<ShoppingListVO> shop = shoppingService.getPaymentShoppingList(vo);
				model.addAttribute("shoppingList", shop);
			}
			else {
				model.addAttribute("isError", true);
				model.addAttribute("error_msg", "결재 창 진입 중 오류가 발생했습니다.");
			}
		}
		
		return "user/mypage/payment";
	}
	
	//상세보기 페이지
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String itemDetailContent(ItemDTO itemDto, Model model) {
		//item_id 받아와야함.
		itemDto = itemService.getItemDetail(itemDto);
		model.addAttribute("itemData", itemDto);
		List<Manage_ImageDTO> itemImageList = selectImageList(itemDto.getItem_id(), "ITEM");
		model.addAttribute("itemImageList", itemImageList);
		
		return "user/shop/detail";
	}
	//후기 페이지
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public String itemReview(ReviewVO review, Model model) {
		//item_id 받아와야함.
		List<ReviewVO> reviewList = reviewService.getReviews(review);
		model.addAttribute("reviewList", reviewList);
		List<Manage_ImageDTO> reviewImageList = selectImageList(review.getReview_id(), "REVIEW");
		model.addAttribute("reviewImageList", reviewImageList);
		
		return "user/shop/review";
	}
	//후기 수정
	@RequestMapping(value="/reviewUpdate", method=RequestMethod.GET)
	public String itemReviewUpdateGET(ReviewVO vo, Model model) {
		//review_id 받아와야함
		ReviewVO review = reviewService.getReview(vo);
		model.addAttribute("review", review);
		List<Manage_ImageDTO> reviewImageList = selectImageList(review.getReview_id(), "REVIEW");
		model.addAttribute("reviewImageList", reviewImageList);
		
		return "user/shop/reviewWrite";
	}
	@RequestMapping(value="/reviewUpdate", method=RequestMethod.POST)
	public String itemReviewUpdatePOST(ReviewVO vo, Model model, HttpServletRequest request, @RequestParam("uploadImages") MultipartFile[] file, String uploadPath) throws Exception {
		if(reviewService.updateReview(vo)) {
			if (file[0].getOriginalFilename() != "") { //파일 있음.
				int ReferencesID = vo.getReview_id();
				
				//전달받은 정보로 DB에 저장할 DTO목록 생성
				List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
				
				//DB에 이미지 정보 저장
				if (imageService.insertList(ImageList)) {
					
					//서버에 이미지 저장(이클립스 테스트환경이 아닌 실제 톰캣 경로에 저장된다.)
					saveImages(ImageList);
					return "redirect:/itemDetail/review";
				}
				else {
					System.out.println("이미지 등록 실패");
					model.addAttribute("error_msg", "이미지가 데이터베이스에 정상적으로 저장되지 않았습니다.");
					return "user/shop/review";
				}
			}
			else {
				return "redirect:/itemDetail/review";
			}
		}
		else {
			model.addAttribute("reviewVO", vo);
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "리뷰 저장 시 문제가 발생하였습니다.");
			return "user/shop/review";
		}
	}
	//후기 삭제
	@RequestMapping(value="/reviewDelete", method=RequestMethod.GET)
	public String itemReviewDelete(ReviewVO vo, Model model) {
		//review_id 받아와야함
		if(reviewService.deleteReview(vo)) {
			return "redirect:/itemDetail/review";
		}
		else {
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "리뷰 삭제 시 문제가 발생하였습니다.");
			return "user/shop/review";
		}
	}
	//후기작성버튼 누를 시 동작(후기작성페이지)
	@RequestMapping(value="/reviewWrite", method=RequestMethod.GET)
	public String itemReviewWriteGET(SoldHistoryVO shistoryVo, SoldDetailVO sdetailVo, Model model, HttpSession session) {
		//로그인여부 확인 -> 아니면 error 날리고 위치 이동(로그인페이지)
		//상품 구매한 사람인지 확인 -> 아니면 error 날리고 다시 리뷰페이지로 위치 이동
		//item_id 받아와야함.
		if(session.getAttribute("logined") == null) {
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "로그인되어있지 않습니다. 로그인 해주세요.");
			return "user/shop/review"; //모달창은 어떻게 열어?
		}
		else {
			if(session.getAttribute("usertype").equals("web")) {
				AccountVO nowAcc = (AccountVO)session.getAttribute("account");
				shistoryVo.setAccount_id(nowAcc.getAccount_id());
			}
			else {
				SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
				shistoryVo.setAccount_id(nowAcc.getSocial_account_id());
			}
			if(!reviewService.checkAlreadyBuy(shistoryVo, sdetailVo)) { // ----> 제대로 작동하는지 확인해봐야한다.
				model.addAttribute("isError", true);
				model.addAttribute("error_msg", "상품을 구매하지 않았습니다. 리뷰를 작성할 수 없습니다.");
				return "user/shop/review";
			}
			else {
				model.addAttribute("item_id", sdetailVo.getItem_id());
				return "user/shop/reviewWrite";
			}
		}
	}
	//후기작성완료 버튼 누를 시 동작
	@RequestMapping(value="/reviewWrite", method=RequestMethod.POST)
	public String itemReviewWritePOST(ReviewVO vo, Model model, HttpSession session, HttpServletRequest request, @RequestParam("uploadImages") MultipartFile[] file, String uploadPath) throws Exception {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			vo.setWriter_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			vo.setWriter_id(nowAcc.getSocial_account_id());
		}
		if(reviewService.addReview(vo)) {
			List<ReviewVO> sameItemandWriter = reviewService.getOneReviewGetId(vo);
			if (file[0].getOriginalFilename() != "") { //파일 있음.
				int ReferencesID = sameItemandWriter.get(0).getReview_id();
				
				//전달받은 정보로 DB에 저장할 DTO목록 생성
				List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
				
				//DB에 이미지 정보 저장
				if (imageService.insertList(ImageList)) {
					
					//서버에 이미지 저장(이클립스 테스트환경이 아닌 실제 톰캣 경로에 저장된다.)
					saveImages(ImageList);
					return "redirect:/itemDetail/review";
				}
				else {
					System.out.println("이미지 등록 실패");
					model.addAttribute("error_msg", "이미지가 데이터베이스에 정상적으로 저장되지 않았습니다.");
					return "user/shop/review";
				}
			}
			else {
				return "redirect:/itemDetail/review";
			}
		}
		else {
			model.addAttribute("reviewVO", vo);
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "리뷰 저장 시 문제가 발생하였습니다.");
			return "user/shop/review";
		}
	}
	
	//문의하기 페이지(8개?10개?보여주고 페이징처리)
	@RequestMapping(value="/checkQuestionList", method=RequestMethod.GET)
	public String seeQuestionList(int page, QuestionVO question, HttpSession session, Model model) {
		//item_id 받아와야함, page 번호 가져와야함.(기본은 1로 줄것)
		List<QuestionVO> questionList = questionService.getItemQuestions(question);
		List<QuestionVO> thisPageQuestions = new ArrayList<QuestionVO>();
		
		int index = 0;
		for(QuestionVO que: questionList) {
			index++;
			if(index < (page*10) && index >= (page*10)-10) {
				thisPageQuestions.add(que);
			}
			else {}
		}
		
		int maxPage = (questionList.size() / 10) + 1; //한페이지에 10개
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("questionList", thisPageQuestions);
		
		return "user/shop/question";
	}
	//문의하기 버튼 누를 시 동작(문의 작성 페이지)
	@RequestMapping(value="/addQuestion", method=RequestMethod.GET)
	public String addQuestionform(QuestionVO vo, Model model) {
		//item_id 가져옴
		model.addAttribute("item_id", vo.getItem_id());
		
		return "user/shop/questionWrite";
	}
	//작성완료 버튼 누를 시 동작
	@RequestMapping(value="/addQuestion", method=RequestMethod.POST)
	public String addQuestion(QuestionVO questionVo, Model model, HttpSession session, HttpServletRequest request, @RequestParam("uploadImages") MultipartFile[] file, String uploadPath) throws Exception {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			questionVo.setWriter_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			questionVo.setWriter_id(nowAcc.getSocial_account_id());
		}
		model.addAttribute("questionVO", questionVo);
		if(questionService.addQuestion(questionVo)) {
			List<QuestionVO> sameItemandWriter = questionService.getOneQuestionGetId(questionVo);
			if (file[0].getOriginalFilename() != "") { //파일 있음.
				int ReferencesID = sameItemandWriter.get(0).getQuestion_id();
				
				//전달받은 정보로 DB에 저장할 DTO목록 생성
				List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
				
				//DB에 이미지 정보 저장
				if (imageService.insertList(ImageList)) {
					
					//서버에 이미지 저장(이클립스 테스트환경이 아닌 실제 톰캣 경로에 저장된다.)
					saveImages(ImageList);
					return "redirect:/itemDetail/checkQuestionList";
				}
				else {
					System.out.println("이미지 등록 실패");
					model.addAttribute("error_msg", "이미지가 데이터베이스에 정상적으로 저장되지 않았습니다.");
					return "user/shop/questionWrite";
				}
			}
			else {
				return "redirect:/itemDetail/checkQuestionList";
			}
		}
		else {
			System.out.println("문의 등록 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
			return "user/shop/questionWrite";
		}
	}
	//문의하기 페이지에서 상세보기
	@RequestMapping(value="/checkQuestion", method=RequestMethod.GET)
	public String seeQuestion(QuestionVO vo, Model model) {
		//question_id 필요함.
		QuestionVO question = questionService.getOneQuestion(vo);
		model.addAttribute("question", question);
		List<Manage_ImageDTO> questionImageList = selectImageList(vo.getQuestion_id(), "QUESTION");
		model.addAttribute("questionImageList", questionImageList);
		
		return "user/shop/questionPost"; //문의상세페이지
	}
	public List<Manage_ImageDTO> selectImageList(int id, String type) {
		return imageService.selectList(id, type);
	}
	@RequestMapping(value="/changeZzim", method=RequestMethod.GET)
	public String changeZzim(ZzimListVO vo, Model model, HttpSession session) {
		//item_id 가져와야함
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			vo.setAccount_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			vo.setAccount_id(nowAcc.getSocial_account_id());
		}
		ZzimListVO zzim = zzimService.getZzim(vo);
		if(zzim != null) {
			zzimService.deleteZzimItem(vo);
		}
		else {
			zzimService.addZzim(vo);
		}
		
		return "redirect:/itemDetail/main?item_id=" + vo.getItem_id();
	}
}
