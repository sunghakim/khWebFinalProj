package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_AccountService;
import com.web.view.View;

@Controller
public class Manage_AccountController {
	//유효성체크 미구현, AOP/인터셉터/필터 미반영
	
	@Autowired
	Manage_AccountService Service;
		
	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Account";
		
	//회원 관리 페이지 접근
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView getAccountList(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getAccountInfo(mv, Service, -1);
		}
		return mv;
	}

	//회원DB에 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteAccount(HttpSession session, ModelAndView mv, String ID) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.delete(ID);
			view.setAccountResult(mv, Service, result);
		}
		return mv;
	}
}
