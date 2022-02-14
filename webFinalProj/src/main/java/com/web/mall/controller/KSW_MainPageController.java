package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_AccountDTO;
import com.web.mall.model.Manage_ItemDTO;
import com.web.mall.model.Manage_ItemService;

@Controller
public class KSW_MainPageController extends Manage_C_Module {
	
	@Autowired
	Manage_ItemService ItemService;
	
	//메인페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Home(ModelAndView mv, HttpSession session) {
		//최근 추가된 상품 정보 불러오기
		//각 dto 연동 필요
		List<Manage_ItemDTO> ItemList = ItemService.selectMainPageItemList();
		mv.addObject("ItemList", ItemList);
		mv.setViewName("index");
		return mv;
	}
	
	//관리자 메인페이지
	@RequestMapping(value = "/Manager_test", method = RequestMethod.GET)
	public ModelAndView ManagerHome(ModelAndView mv, HttpSession session) {
		//로그인 세션이 없을 경우 테스트용 관리자 세션 생성
		if (session.getAttribute("account") == null) {
			Manage_AccountDTO dto = new Manage_AccountDTO();
			dto.setAccountID("tester");
			dto.setUserType(0);
			session.setAttribute("account", dto);
			System.out.println("임시 관리자 세션 발급 성공");
		}
		mv.setViewName("Manager_test/Home");
		return mv;
	}
}
