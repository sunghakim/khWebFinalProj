package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_PurchaseService;
import com.web.view.View;

@Controller
public class Manage_StatisticsController {
	//유효성체크 미구현, AOP/인터셉터/필터 미반영
	
	@Autowired
	Manage_PurchaseService Service;
		
	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Statistics";
		
	//통계 페이지 접근
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView getStatisticsList(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getStatistics(mv, Service, -1);
		}
		return mv;
	}
}
