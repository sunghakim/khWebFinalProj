package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_CouponDTO;
import com.web.mall.model.Manage_CouponService;

@Controller
public class Manage_CouponController extends Manage_C_Module {
	
	@Autowired
	Manage_CouponService Service;
	
	//페이지 링크
	private final String URL = "/Manager/Coupon";
	
	//쿠폰 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectCouponList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			//Request에 Page파라미터로 숫자를 입력하면 요청후 해당 페이지로 이동함
			mv.addObject("TotalPageCount", Service.selectTotalPageCount());
			List<Manage_CouponDTO> List = Service.selectList(setPage(mv, request));
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//쿠폰 상세관리 페이지 접속
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectCouponOne(HttpSession session, ModelAndView mv, int ID) {
		if (isManager(mv, session, URL + "Detail") == 0) {
			mv.addObject("Coupon", Service.selectOne(ID));
		}
		return mv;
	}
	
	//쿠폰 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertCoupon(HttpSession session, ModelAndView mv) {
		isManager(mv, session, URL + "Insert");
		return mv;
	}
	
	//쿠폰DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertCoupon(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_CouponDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.insert(DTO));
			selectCouponList(session, mv, request);
		}
		return mv;
	}
}