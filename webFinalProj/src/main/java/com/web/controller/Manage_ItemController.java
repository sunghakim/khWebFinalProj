package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_ItemDTO;
import com.web.model.Manage_ItemService;
import com.web.view.View;

@Controller
public class Manage_ItemController {

	@Autowired
	Manage_ItemService Service;

	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Item";
	
	//상품 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectItem(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getItemInfo(mv, Service, -1);
		}
		return mv;
	}
	//상품 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertItem(HttpSession session, ModelAndView mv) {
		view.isManager(mv, session, URL + "/Insert");
		return mv;
	}
	
	//상품DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertItem(HttpSession session, ModelAndView mv, Manage_ItemDTO DTO) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.insert(DTO);
			view.setItemResult(mv, Service, result);
		}
		return mv;
	}
	
	//상품 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL + "/Update") == 0) {
			view.getItemInfo(mv, Service, ID);
		}
		return mv;
	}
		
	//상품DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, Manage_ItemDTO DTO) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.update(DTO);
			view.setItemResult(mv, Service, result);
		}
		return mv;
	}

	//상품DB에 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.delete(ID);
			view.setItemResult(mv, Service, result);
		}
		return mv;
	}
}
