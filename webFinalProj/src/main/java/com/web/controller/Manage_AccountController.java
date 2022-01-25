package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_AccountDTO;
import com.web.model.Manage_AccountService;
import com.web.view.View;

@Controller
public class Manage_AccountController {
	
	@Autowired
	Manage_AccountService Service;
		
	//중복 로직 모듈화
	Module Module = new Module();
	
	//페이지 링크
	private final String URL = "/Manager/Account";
		
	//회원 관리 페이지 접근
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView getAccountList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		int Page;
		if (request.getParameter("Page") == null) {
			Page = 1;
		} else {
			String temp = request.getParameter("Page");
			Page = Integer.parseInt(temp);
		}
		if (Module.isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			List<Manage_AccountDTO> List = Service.selectList(Page);
			mv.addObject("TotalPageCount", TotalPageCount);
			mv.addObject("Page", Page);
			mv.addObject("List", List);
		}
		return mv;
	}

	//회원DB에 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteAccount(HttpSession session, ModelAndView mv, HttpServletRequest request, String ID) throws Exception {
		if (Module.isManager(mv, session, URL) == 0) {
			Module.setResult(mv, Service.delete(ID));
			getAccountList(session, mv, request);
		}
		return mv;
	}
}
