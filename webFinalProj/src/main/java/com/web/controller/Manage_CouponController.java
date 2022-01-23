package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_CouponDTO;
import com.web.model.Manage_CouponService;
import com.web.model.View;

@Controller
public class Manage_CouponController {
	
	@Autowired
	Manage_CouponService Service;
	
	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Coupon";
	
	//쿠폰 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectCouponList(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getCouponInfo(mv, Service, -1);
		}
		return mv;
	}
	
	//쿠폰 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectCouponList(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getCouponInfo(mv, Service, ID);
		}
		return mv;
	}
	
	//쿠폰 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertCoupon(HttpSession session, ModelAndView mv) {
		view.isManager(mv, session, URL + "/Insert");
		return mv;
	}
	
	//쿠폰DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertCoupon(HttpSession session, ModelAndView mv, Manage_CouponDTO DTO) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.insert(DTO);
			view.setCouponResult(mv, Service, result);
		}
		return mv;
	}
	
	//쿠폰DB 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteCoupon(HttpSession session, ModelAndView mv, String ID) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.delete(ID);
			view.setCouponResult(mv, Service, result);
		}
		return mv;
	}
}