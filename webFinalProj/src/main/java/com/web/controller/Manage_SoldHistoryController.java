package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_SoldHistoryDTO;
import com.web.model.Manage_SoldHistoryService;


@Controller
public class Manage_SoldHistoryController extends Manage_C_Module {
	//유효성체크 미구현, AOP/인터셉터/필터 미반영
	
	@Autowired
	Manage_SoldHistoryService Service;
	
	//페이지 링크
	private final String URL = "/Manager/SoldHistory";
	
	//종류에 따른 통계 반환
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView getSoldHistoryList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);
			
			int Page = setPage(mv, request);
			List<Manage_SoldHistoryDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
		}
		return mv;
	}
}

