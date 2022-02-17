package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_RefundService;
import com.web.mall.model.Manage_SoldHistoryDTO;

@Controller
public class Manage_RefundController extends Manage_C_Module {
	
	@Autowired
	Manage_RefundService Service;
	
	//페이지 링크
	private final String URL = "/Manager/Refund";
	
	//환불 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectRefundList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);

			int Page = setPage(mv, request);
			List<Manage_SoldHistoryDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
		}
		return mv;
	}
		
	//환불DB에 환불승인/환불거절 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateRefund(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_SoldHistoryDTO dto) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(dto));
			selectRefundList(session, mv, request);
		}
		return mv;
	}
}