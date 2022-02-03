package com.web.mall.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_StatisticsService;


@Controller
public class Manage_StatisticsController extends Manage_C_Module {
	//유효성체크 미구현, AOP/인터셉터/필터 미반영
	
	@Autowired
	Manage_StatisticsService Service;
	
	//페이지 링크
	private final String URL = "/Manager/Statistics";
	
	//종류에 따른 통계 반환
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView getStatisticsList(HttpSession session, ModelAndView mv, int Type) {
		if (isManager(mv, session, URL) == 0) {
			List<Map<String, Integer>> Statistics = Service.getStatistics(Type, new Date());
			mv.addObject("Statistics", Statistics);
		}
		return mv;
	}
}

