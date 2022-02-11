package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mall.model.AccountVO;
import com.web.mall.model.ItemDTO;
import com.web.mall.model.ItemOptionDTO;
import com.web.mall.model.ItemService;
import com.web.mall.model.QuestionVO;
import com.web.mall.model.ReviewService;
import com.web.mall.model.ReviewVO;
import com.web.mall.model.ShoppingListVO;
import com.web.mall.model.SocialAccountVO;
import com.web.mall.model.SoldDetailVO;
import com.web.mall.model.SoldHistoryVO;

@Controller
@RequestMapping(value="/itemDetail")
public class ItemDetailController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private ReviewService reviewService;
	
	//구매하기 페이지
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String itemDetailMain(ItemDTO itemDto, ItemOptionDTO optionDto, Model model) {
		//item_id 받아와야함.
		//상품정보, 옵션, 상품사진 -> 사진데이터는 나중에 추가할 예정.
		itemDto = itemService.getItemDetail(itemDto);
		List<ItemOptionDTO> optionList = itemService.getItemOptions(optionDto);
		model.addAttribute("itemData", itemDto);
		model.addAttribute("optionList", optionList);
		
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
		if(itemService.addShoppingList(vo)) {
			model.addAttribute("result", "장바구니에 정상적으로 저장되었습니다.");
			
		}
		else {
			model.addAttribute("result", "장바구니에 저장을 실패했습니다.");
		}

		return "redirect:/itemDetail?item_id=" + vo.getItem_id();
	}
	
	//구매하기 버튼 누를 시 동작(구매페이지로 이동)
	
	
	//상세보기 페이지
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String itemDetailContent(ItemDTO itemDto, Model model) {
		//item_id 받아와야함.
		//상품정보, 상품사진 -> 사진데이터는 나중에 추가할 예정.
		itemDto = itemService.getItemDetail(itemDto);
		model.addAttribute("itemData", itemDto);
		
		return "user/shop/detail";
	}
	//후기 페이지
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public String itemReview(ReviewVO review, Model model) {
		//item_id 받아와야함.
		//리뷰리스트, 리뷰사진 -> 사진데이터는 나중에 추가할 예정.
		List<ReviewVO> reviewList = reviewService.getReviews(review);
		model.addAttribute("reviewList", reviewList);
		
		return "user/shop/review";
	}
	//후기 수정
	@RequestMapping(value="/reviewUpdate", method=RequestMethod.GET)
	public String itemReviewUpdateGET(ReviewVO vo, Model model) {
		//review_id 받아와야함
		ReviewVO review = reviewService.getReview(vo);
		model.addAttribute("review", review);
		
		return "user/shop/reviewWrite";
	}
	@RequestMapping(value="/reviewUpdate", method=RequestMethod.POST)
	public String itemReviewUpdatePOST(ReviewVO vo, Model model) {
		if(reviewService.updateReview(vo)) {
			return "redirect:/itemDetail/review";
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
	public String itemReviewWritePOST(ReviewVO vo, Model model, HttpSession session) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			vo.setWriter_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			vo.setWriter_id(nowAcc.getSocial_account_id());
		}
		if(reviewService.addReview(vo)) {
			return "redirect:/itemDetail/review";
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
	public String seeQuestionList(QuestionVO question, HttpSession session, Model model) {
		//item_id 받아와야함.
		List<QuestionVO> questionList = itemService.getQuestions(question);
		model.addAttribute("questionList", questionList);
		
		// -> 졸림..페이징처리는 나중에 구현
		
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
	public String addQuestion(QuestionVO questionVo, Model model, HttpSession session) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			questionVo.setWriter_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			questionVo.setWriter_id(nowAcc.getSocial_account_id());
		}
		model.addAttribute("questionVO", questionVo);
		if(itemService.addQuestion(questionVo)) {
			return "redirect:/itemDetail/checkQuestionList";
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
		QuestionVO question = itemService.getOneQuestion(vo);
		model.addAttribute("question", question);
		
		return "user/shop/questionPost"; //문의상세페이지
	}
}
