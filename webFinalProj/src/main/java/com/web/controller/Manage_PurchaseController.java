package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_PurchaseDTO;
import com.web.model.Manage_PurchaseService;
import com.web.view.View;

@Controller
public class Manage_PurchaseController {
	
	@Autowired
	Manage_PurchaseService Service;
	
	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Purchase";
	
	//구매정보 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectPurchase(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getPurchaseInfo(mv, Service, -1);
		}
		return mv;
	}
	
	//구매정보 관리 페이지 접속
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectPurchase(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getPurchaseInfo(mv, Service, ID);
		}
		return mv;
	}
	
	//구매정보 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updatePurchase(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL + "/Update") == 0) {
			view.getPurchaseInfo(mv, Service, ID);
		}
		return mv;
	}
		
	//구매정보DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updatePurchase(HttpSession session, ModelAndView mv, Manage_PurchaseDTO DTO) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.update(DTO);
			view.setPurchaseResult(mv, Service, result);
		}
		return mv;
	}
}
