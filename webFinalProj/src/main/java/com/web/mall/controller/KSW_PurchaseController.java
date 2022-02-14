package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.KSW_PurchaseService;
import com.web.mall.model.ShoppingListVO;

@Controller
public class KSW_PurchaseController extends Manage_C_Module {
	
	@Autowired
	KSW_PurchaseService Service;
	
	@RequestMapping(value = "/user/mypage/payment", method = RequestMethod.GET)
	public ModelAndView Purchase(ModelAndView mv, HttpSession session, HttpServletRequest reqeust, List<ShoppingListVO> List) throws Exception {
		if (session.getAttribute("account") != null) {
			/* 1. input hidden 태그로 값 넘겨받기
			 * 2. 파라미터로 넘어온 구매 데이터를 가져오기
			 * 3. SOLD_HISTORY db에 주문내역 추가
			 * 4. SOLD_DETAIL db에 결제내역 추가
			 * 5. SHOPPING_LIST db에서 해당 데이터 삭제
			 * 6. 외부 결제 api 사용하는 방법 알아보기
			 */
			Service.purchase(List);
			
		} else {
			//로그인 페이지로 연결
		}
		//구매결과 페이지(혹은 홈페이지)로 이동
		//mv.setViewName("/");
		return mv;
	}
}