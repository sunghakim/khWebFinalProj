package com.web.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_AccountDTO;

@Controller
public class Manage_HomeController extends Manage_C_Module {
	
	//메인페이지
	@RequestMapping(value = "/Manager_test", method = RequestMethod.GET)
	public ModelAndView Home(ModelAndView mv, HttpSession session) {
		Manage_AccountDTO dto = new Manage_AccountDTO();
		dto.setAccountID("tester");
		dto.setUserType(0);
		session.setAttribute("account", dto);
		System.out.println("임시 관리자 세션 발급 성공");
		mv.setViewName("Manager_test/Home");
		return mv;
	}
}
