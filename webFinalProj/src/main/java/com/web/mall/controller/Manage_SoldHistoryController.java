package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_SoldHistoryDTO;
import com.web.mall.model.Manage_SoldHistoryService;


@Controller
public class Manage_SoldHistoryController extends Manage_C_Module {
	
	@Autowired
	Manage_SoldHistoryService Service;
	
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

