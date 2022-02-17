package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_ItemCategoryDTO;
import com.web.mall.model.Manage_ItemCategoryService;
import com.web.mall.model.PurchaseService;
import com.web.mall.model.ShoppingListVO;

@Controller
public class PurchaseController extends Manage_C_Module {
	
	@Autowired
	PurchaseService Service;
	@Autowired
	Manage_ItemCategoryService categoryService;
	
	//페이지 링크
	private final String URL = "/user/mypage/payment";
	
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView Purchase(ModelAndView mv, HttpSession session, HttpServletRequest reqeust, List<ShoppingListVO> List) throws Exception {
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		mv.addObject("navList", category);
		
		if (isLogined(session)) {
			Service.purchase(List);
			//구매결과 페이지(혹은 홈페이지)로 이동
			mv.setViewName("/");
		}
		return mv;
	}
}