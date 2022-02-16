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
import com.web.mall.model.Manage_AccountService;

@Controller
public class Manage_AccountController extends Manage_C_Module {

	@Autowired
	Manage_AccountService Service;
	
	//페이지 링크
	private final String URL = "/Manager/Account";
		
	//회원 관리 페이지 접근
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectAccountList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);
			
			int Page = setPage(mv, request);
			List<Manage_AccountDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
		}
		return mv;
	}
}
