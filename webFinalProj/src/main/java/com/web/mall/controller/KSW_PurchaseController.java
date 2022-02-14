package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_AccountDTO;
import com.web.mall.model.Manage_ItemService;

@Controller
public class KSW_PurchaseController extends Manage_C_Module {
	
	@Autowired
	Manage_ItemService ItemService;
	
	@RequestMapping(value = "/user/mypage/payment", method = RequestMethod.GET)
	public ModelAndView Purchase(ModelAndView mv, HttpSession session, HttpServletRequest reqeust) {
		if (session.getAttribute("account") != null) {
			/* 1. 파라미터로 넘어온 구매 데이터를 가져오기
			 * 2. SHOPPING_LIST db에서 해당 데이터 삭제
			 * 3. SOLD_HISTORY db에 주문내역 추가
			 * 4. SOLD_DETAIL db에 결제내역 추가
			 * 5. 외부 결제 api 사용하는 방법 알아보기
			 */
			Manage_AccountDTO dto = new Manage_AccountDTO();
			dto.setAccountID("tester");
			dto.setUserType(0);
			session.setAttribute("account", dto);
			System.out.println("임시 관리자 세션 발급 성공");
		} else {
			//로그인 페이지로 연결
		}
		mv.setViewName("Manager_test/Home");
		return mv;
	}
}
