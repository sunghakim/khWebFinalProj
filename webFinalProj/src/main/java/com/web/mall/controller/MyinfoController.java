package com.web.mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.mall.model.AccountVO;
import com.web.mall.model.CouponVO;
import com.web.mall.model.GiveCouponVO;
import com.web.mall.model.ItemDTO;
import com.web.mall.model.ItemOptionDTO;
import com.web.mall.model.ItemService;
import com.web.mall.model.Manage_ImageDTO;
import com.web.mall.model.Manage_ImageService;
import com.web.mall.model.Manage_S_Module;
import com.web.mall.model.MyinfoService;
import com.web.mall.model.QuestionService;
import com.web.mall.model.QuestionVO;
import com.web.mall.model.ReportReasonVO;
import com.web.mall.model.ReportVO;
import com.web.mall.model.ShoppingListService;
import com.web.mall.model.ShoppingListVO;
import com.web.mall.model.SocialAccountVO;
import com.web.mall.model.SoldDetailVO;
import com.web.mall.model.SoldHistoryVO;
import com.web.mall.model.ZzimListVO;
import com.web.mall.model.ZzimService;

@Controller
@RequestMapping(value="/mypage")
public class MyinfoController extends Manage_S_Module{
	@Autowired
	private Manage_ImageService imageService;
	@Autowired
	private ShoppingListService shoppingService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private MyinfoService service;
	@Autowired
	private ZzimService zzimService;
	
	@Resource(name="uploadPath")
    String uploadPath;
		
	@RequestMapping(value="/checkCarts", method=RequestMethod.GET) //장바구니
	public String seeCarts(ShoppingListVO shop, ItemDTO item, ItemOptionDTO itemOp, HttpSession session, Model model) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			shop.setAccount_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			shop.setAccount_id(nowAcc.getSocial_account_id());
		}
		
		List<ShoppingListVO> shoppingList = shoppingService.getCarts(shop);
		model.addAttribute("shoppingList", shoppingList);
		
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();
		List<ItemOptionDTO> itemOptionList = new ArrayList<ItemOptionDTO>();
		for(ShoppingListVO shopping : shoppingList) {
			item.setItem_id(shopping.getItem_id());
			itemOp.setItem_option_id(shopping.getItem_option_id());
			
			ItemDTO getItem = itemService.getItem(item);
			ItemOptionDTO getItemOption = itemService.getItemOption(itemOp);
			itemList.add(getItem);
			itemOptionList.add(getItemOption);
		}
		model.addAttribute("itemList", itemList);
		model.addAttribute("itemOptionList", itemOptionList);
		
		return "user/mypage/basket";
	}
	@RequestMapping(value="/deleteCartItem", method=RequestMethod.GET) //장바구니 물건 삭제
	public String deleteCartItem(ShoppingListVO shop, Model model) {
		//id 받아와야함
		if(shoppingService.deleteCartItem(shop)) {
		}
		else {
			System.out.println("장바구니 삭제 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 삭제되지 않았습니다.");
		}
		return "redirect:/mypage/checkCarts";
	}
	@RequestMapping(value="/updateCartItem", method=RequestMethod.GET) //장바구니 물건 수량변경
	public String updateCartItem(ShoppingListVO shop, Model model) {
		//id 받아와야함
		if(shoppingService.updateCartItem(shop)) {
		}
		else {
			System.out.println("장바구니 수정 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/mypage/checkCarts";
	}
	//장바구니 구매버튼 누를 시 동작(구매페이지로 이동)
//	@RequestMapping(value="/BuyItem", method=RequestMethod.GET)
//	public String buyItem(List<Integer> shop, Model model, HttpSession session) {
//		//shopping_list_id 를 리스트로 받아와야함
//		List<ShoppingListVO> list = new ArrayList<ShoppingListVO>();
//		for(Integer index: shop) {
//			list.add(shoppingService.getCartItem(index));
//		}
//		
//		model.addAttribute("shoppingList", list);
//		return "user/mypage/payment";
//	}
	@RequestMapping(value="/BuyItem", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	   public String buyItem(Model model, HttpSession session, @RequestBody String shop) {
	      //shopping_list_id 를 리스트로 받아와야함
	      List<ShoppingListVO> list = new ArrayList<ShoppingListVO>();
	      System.out.println("controller");
	      System.out.println(shop);
	      try {       
	            JSONParser jsonParser = new JSONParser();
	            JSONArray jsonArray = (JSONArray)jsonParser.parse(shop);
	            for(int i=0; i<jsonArray.size(); i++){
	               String index = jsonArray.get(i).toString();
	               list.add(shoppingService.getCartItem(Integer.parseInt(index)));
	            }
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	      model.addAttribute("shoppingList", list);
	      return "user/mypage/payment";
	   }
	
	
	@RequestMapping(value="/checkZzim", method=RequestMethod.GET)
	public String seeZzimList(ZzimListVO zzim, ItemDTO item, HttpSession session, Model model) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			zzim.setAccount_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			zzim.setAccount_id(nowAcc.getSocial_account_id());
		}
		
		List<ZzimListVO> zzimList = zzimService.getZzims(zzim);
		model.addAttribute("zzimList", zzimList);
		
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();
		List<Manage_ImageDTO> imageList = new ArrayList<Manage_ImageDTO>();
		for(ZzimListVO zzim1 : zzimList) {
			item.setItem_id(zzim1.getItem_id());
			ItemDTO getItem = itemService.getItem(item);
			itemList.add(getItem);
			System.out.println(getItem);
			
			List<Manage_ImageDTO> images = imageService.selectList(zzim1.getItem_id(), "ITEM");
			imageList.add(images.get(0));
		}
		model.addAttribute("itemList", itemList);
		model.addAttribute("imageList", imageList);
		
		return "user/mypage/like";
	}
	@RequestMapping(value="/deleteZzimItem", method=RequestMethod.GET)
	public String deleteZzimItem(ZzimListVO zzim, Model model) {
		//zzim_id 받아와야함
		System.out.println("찜 삭제 시작");
		if(zzimService.deleteZzimItem(zzim)) {
			System.out.println("찜 아이템 삭제 성공");
		}
		else {
			System.out.println("찜 아이템 삭제 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 삭제되지 않았습니다.");
		}
		
		return "redirect:/mypage/checkZzim";
	}
	@RequestMapping(value="/checkCoupon", method=RequestMethod.GET)
	public String seeCouponList(GiveCouponVO givenCoupon, CouponVO coupon, HttpSession session, Model model) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			givenCoupon.setAccount_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			givenCoupon.setAccount_id(nowAcc.getSocial_account_id());
		}
		
		List<GiveCouponVO> couponList = service.getGivenCoupons(givenCoupon);
		model.addAttribute("couponList", couponList);
		
		List<CouponVO> couponInfo = new ArrayList<CouponVO>();
		for(GiveCouponVO given : couponList) {
			coupon.setCoupon_id(given.getCoupon_id());
			
			CouponVO getInfo = service.getCouponInfo(coupon);
			couponInfo.add(getInfo);
		}
		model.addAttribute("couponInfo", couponInfo);
		
		return "user/mypage/coupon";
	}
	@RequestMapping(value="/checkReport", method=RequestMethod.GET)
	public String seeReportedList(ReportVO report, HttpSession session, Model model) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			report.setReporter_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			report.setReporter_id(nowAcc.getSocial_account_id());
		}
		
		List<ReportVO> reportList = service.getReportedUsers(report);
		model.addAttribute("reportList", reportList);
		
		List<ReportReasonVO> reportReason = service.getReportReason();
		model.addAttribute("reportReason", reportReason);
		
		return "user/mypage/report";
	}
	@RequestMapping(value="/checkQuestionList", method=RequestMethod.GET)
	public String seeQuestionList(QuestionVO question, ItemDTO item, HttpSession session, Model model) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			question.setWriter_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			question.setWriter_id(nowAcc.getSocial_account_id());
		}
		
		List<QuestionVO> myQuestionList = questionService.getWriterQuestionsInMypage(question);
		model.addAttribute("myQuestionList", myQuestionList);
		
		List<QuestionVO> itemQuestionList = questionService.getWriterQuestionsInItem(question);
		model.addAttribute("itemQuestionList", itemQuestionList);
		
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();
		for(QuestionVO questions : itemQuestionList) {
			item.setItem_id(questions.getItem_id());
			
			ItemDTO getItem = itemService.getItem(item);
			itemList.add(getItem);
			System.out.println(getItem);
		}
		model.addAttribute("itemList", itemList);
		
		return "user/mypage/question";
	}
	@RequestMapping(value="/addQuestion", method=RequestMethod.GET)
	public String addQuestionform() {
		return "user/questionWrite";
	}
	/* 문의할 때 파일 업로드 하는 기능 추가됨
	 * @RequestMapping(value="/addQuestion", method=RequestMethod.POST)
	public String addQuestion(QuestionVO questionVo, Model model, HttpServletRequest request, @RequestParam("uploadImages") MultipartFile[] file, String uploadPath) throws Exception {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			questionVo.setWriter_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			questionVo.setWriter_id(nowAcc.getSocial_account_id());
		}
		questionVo.setItem_id(0);
		
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
					return "redirect:/mypage/checkQuestionList";
				}
				else {
					System.out.println("이미지 등록 실패");
					model.addAttribute("error_msg", "이미지가 데이터베이스에 정상적으로 저장되지 않았습니다.");
					return "user/questionWrite";
				}
			}
			else {
				return "redirect:/mypage/checkQuestionList";
			}
		}
		else {
			System.out.println("문의 등록 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
			return "user/questionWrite";
		}
	}*/
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
		questionVo.setItem_id(0);
		model.addAttribute("questionVO", questionVo);
		if(questionService.addQuestion(questionVo)) {
			List<QuestionVO> sameItemandWriter = questionService.getOneQuestionGetId(questionVo);
			model.addAttribute("questionVO", sameItemandWriter.get(0));
			return "redirect:/mypage/checkQuestion?question_id=" + sameItemandWriter.get(0).getQuestion_id();
		}
		else {
			System.out.println("문의 등록 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
			return "user/questionWrite";
		}
	}
	
	@RequestMapping(value="/checkQuestion", method=RequestMethod.GET)
	public String seeQuestion(QuestionVO questionVo, Model model) {
		//question_id
		QuestionVO question = questionService.getOneQuestion(questionVo);
		model.addAttribute("question", question);
		
		List<Manage_ImageDTO> questionImageList = selectImageList(questionVo.getQuestion_id(), "QUESTION");
		model.addAttribute("questionImageList", questionImageList);
		
		return "user/questionPost";
	}
	
	@RequestMapping(value="/updateQuestion", method=RequestMethod.GET)
	public String updateQuestionForm(QuestionVO questionVo, Model model) {
		//id 받아와야함
		QuestionVO question = questionService.getOneQuestion(questionVo);
		model.addAttribute("questionVo", question);
		
		List<Manage_ImageDTO> questionImageList = selectImageList(questionVo.getQuestion_id(), "QUESTION");
		model.addAttribute("questionImageList", questionImageList);
		
		return "user/questionWrite";
	}
	@RequestMapping(value="/updateQuestion", method=RequestMethod.POST)
	public String updateQuestion(QuestionVO questionVo, Model model, HttpServletRequest request, @RequestParam("uploadImages") MultipartFile[] file, String uploadPath) throws Exception {
		//id 받아와야함
		
		model.addAttribute("questionVO", questionVo);
		if(questionService.updateQuestion(questionVo)) {
			if (file[0].getOriginalFilename() != "") { //파일 있음.
				int ReferencesID = questionVo.getQuestion_id();
				
				//전달받은 정보로 DB에 저장할 DTO목록 생성
				List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
				
				//DB에 이미지 정보 저장
				if (imageService.insertList(ImageList)) {
					
					//서버에 이미지 저장(이클립스 테스트환경이 아닌 실제 톰캣 경로에 저장된다.)
					saveImages(ImageList);
					return "redirect:/mypage/checkQuestionList";
				}
				else {
					System.out.println("이미지 등록 실패");
					model.addAttribute("error_msg", "이미지가 데이터베이스에 정상적으로 저장되지 않았습니다.");
					return "user/questionWrite";
				}
			}
			else {
				return "redirect:/mypage/checkQuestionList";
			}
		}
		else {
			System.out.println("문의 수정 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
			return "user/questionWrite";
		}
	}
	@RequestMapping(value="/deleteQuestion", method=RequestMethod.GET)
	public String deleteQuestion(QuestionVO questionVo, Manage_ImageDTO dto, Model model) throws Exception {
		//id 받아와야함
		dto.setIDType("QUESTION");
		dto.setReferencesID(questionVo.getQuestion_id());
		
		if (imageService.deleteList(dto)) {
			if(questionService.deleteQuestion(questionVo, dto)) {
				return "redirect:/mypage/checkQuestionList"; 
			}
			else {
				System.out.println("문의 삭제 실패");
				model.addAttribute("error_msg", "데이터베이스에 정상적으로 삭제되지 않았습니다.");
				return "redirect:/mypage/checkQuestionList"; 
			}
		}
		else {
			System.out.println("이미지 삭제 실패");
			model.addAttribute("error_msg", "데이터베이스에 정상적으로 삭제되지 않았습니다.");
			return "redirect:/mypage/checkQuestionList"; 
		}
	}
	@RequestMapping(value="/checkPayedList", method=RequestMethod.GET)
	public String seePayedDayList(SoldHistoryVO soldHistoryVo, SoldDetailVO detailVo, ItemDTO dto, Model model, HttpSession session) {
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			soldHistoryVo.setAccount_id(nowAcc.getAccount_id());
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			soldHistoryVo.setAccount_id(nowAcc.getSocial_account_id());
		}
		
		List<SoldHistoryVO> soldList = service.getPayedDays(soldHistoryVo);
		model.addAttribute("soldList", soldList);
		
		if(soldList != null) {
			List<SoldDetailVO> soldDetail = new ArrayList<SoldDetailVO>();
			List<ItemDTO> itemList = new ArrayList<ItemDTO>();
			List<Integer> numberOfDetail = new ArrayList<Integer>();
			for(SoldHistoryVO list : soldList) {
				detailVo.setSold_history_id(list.getSold_history_id());
				List<SoldDetailVO> detailList = service.getOnePayedDetails(detailVo);
				dto.setItem_id(detailList.get(0).getItem_id());
				ItemDTO item = itemService.getItemDetail(dto);
				
				soldDetail.add(detailList.get(0));
				numberOfDetail.add(detailList.size() - 1);
				itemList.add(item);
			}
			model.addAttribute("detailOne", soldDetail); //같은날에 산것 중 최조 보여질 1개
			model.addAttribute("detailNumber", numberOfDetail); //외 ~개
			model.addAttribute("itemList", itemList);
		}
		
		return "user/mypage/history";
	}
	@RequestMapping(value="/checkPayed", method=RequestMethod.GET)
	public String seePayedDay(SoldDetailVO detailVo, ItemDTO itemDto, ItemOptionDTO optionDto, Model model) {
		//id 받아와야함(하루에 산 내용 상세보기_soldhistoryid)
		List<SoldDetailVO> detailList = service.getOnePayedDetails(detailVo);
		model.addAttribute("detailList", detailList);
		
		List<List<ItemOptionDTO>> itemOptionList = new ArrayList<List<ItemOptionDTO>>();
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();
		List<List<Manage_ImageDTO>> oneItemImageList = new ArrayList<List<Manage_ImageDTO>>();
		for(SoldDetailVO sold : detailList) {
			List<Manage_ImageDTO> images = imageService.selectList(sold.getItem_id(), "ITEM");
			oneItemImageList.add(images);
			
			itemDto.setItem_id(detailList.get(0).getItem_id());
			ItemDTO item = itemService.getItemDetail(itemDto);
			itemList.add(item);
			
			optionDto.setItem_id(sold.getItem_id());
			List<ItemOptionDTO> itemOptions = itemService.getItemOptions(optionDto);
			itemOptionList.add(itemOptions);
		}
		model.addAttribute("imageList", oneItemImageList);
		model.addAttribute("itemList", itemList);
		model.addAttribute("itemOptionList", itemOptionList);
		
		return "user/mypage/historyDetail"; //하루 구매목록보기페이지
	}
	@RequestMapping(value="/doRefund", method=RequestMethod.GET)
	public String doRefund(SoldDetailVO detailVo, Model model) {
		//id 받아와야함(아이템 1개에 대한 detail id)
		System.out.println(detailVo);
		SoldDetailVO detailInfo = service.getOnePayedDetail(detailVo);
		if(detailInfo.getRefund_status() == 3 || detailInfo.getRefund_status() == 4) {
			System.out.println("이미 환불 처리 완료된 사항으로 환불신청할 수 없습니다.");
			model.addAttribute("error_msg", "이미 환불 처리 완료된 사항으로 환불신청할 수 없습니다.");	
		}
		else {
			if(service.doRefund(detailInfo)) {
				System.out.println("환불요청 변경 됨");
			}
			else {
				model.addAttribute("error_msg", "데이터 베이스 저장 시 문제가 발생했습니다.");
				System.out.println("데이터 베이스 저장 시 문제가 발생했습니다.");
			}
		}
		return "redirect:/mypage/checkPayed?sold_history_id=" + detailInfo.getSold_history_id();
	}
	@RequestMapping(value="/whereItem", method=RequestMethod.GET)
	public String whereItem(SoldHistoryVO soldHistoryVo, Model model) {
		//id 받아와야함 sold_history_id
		SoldHistoryVO soldDay = service.getOnePayedDay(soldHistoryVo);
		System.out.println(soldDay);
		if(soldDay.getStatus() == 0) {
			model.addAttribute("result", " 배송 준비중입니다.");
			System.out.println("배송 준비중입니다.");
		}
		else if(soldDay.getStatus() == 2) {
			model.addAttribute("result", "배송 완료되었습니다.");
			System.out.println("배송 완료되었습니다.");
		}
		else{
			model.addAttribute("result", "배송 중입니다.");
			System.out.println("배송 중입니다.");
		}
		
		return "redirect:/mypage/checkPayed?sold_history_id=" + soldDay.getSold_history_id();
	}
	public List<Manage_ImageDTO> selectImageList(int id, String type) {
		return imageService.selectList(id, type);
	}
}