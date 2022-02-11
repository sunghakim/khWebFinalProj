package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_SoldHistoryDTO;
import com.web.mall.model.Manage_StatisticsService;


@Controller
public class Manage_StatisticsController extends Manage_C_Module {
	
	@Autowired
	Manage_StatisticsService Service;
	
	//페이지 링크
	private final String URL = "/Manager_test/Statistics";
	
	//종류에 따른 통계 반환
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView getStatisticsList(HttpSession session, ModelAndView mv) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			int TotalCount = Service.selectTotalCount(1);
			mv.addObject("TotalCount", TotalCount);
			
			List<Manage_SoldHistoryDTO> Statistics = Service.getStatistics(1);
			for (Manage_SoldHistoryDTO temp : Statistics) {
				System.out.println("통계: Name=" + temp.getName() + ", Amount=" + temp.getAmount());
			}
			mv.addObject("Statistics", Statistics);
		}
		return mv;
	}
}

