package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_RefundDTO;
import com.web.model.Manage_RefundService;
import com.web.model.View;

@Controller
public class Manage_RefundController {
	
	@Autowired
	Manage_RefundService Service;

	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Refund";
	
	//환불 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectItem(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getRefundInfo(mv, Service, -1);
		}
		return mv;
	}
	
	//환불 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL + "/Update") == 0) {
			view.getRefundInfo(mv, Service, ID);
		}
		return mv;
	}
		
	//환불DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, Manage_RefundDTO DTO) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.update(DTO);
			view.setRefundResult(mv, Service, result);
		}
		return mv;
	}
}
