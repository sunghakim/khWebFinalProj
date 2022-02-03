package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_RefundService;
import com.web.model.Manage_SoldHistoryDTO;

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
			//Request에 Page파라미터로 숫자를 입력하면 요청후 해당 페이지로 이동함
			mv.addObject("TotalPageCount", Service.selectTotalPageCount());
			List<Manage_SoldHistoryDTO> List = Service.selectList(setPage(mv, request));
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//환불 상세 조회
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectRefund(HttpSession session, ModelAndView mv, HttpServletRequest request, int ID) {
		if (isManager(mv, session, URL + "Detail") == 0) {
			mv.addObject("Item", Service.selectOne(ID));
		}
		return mv;
	}
		
	//환불DB에 환불승인/환불거절 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateRefund(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_SoldHistoryDTO dto) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(dto));
			selectRefundList(session, mv, request);
		}
		return mv;
	}
}
