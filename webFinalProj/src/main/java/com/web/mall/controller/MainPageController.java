package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_ItemCategoryDTO;
import com.web.mall.model.Manage_ItemCategoryService;
import com.web.mall.model.Manage_ItemDTO;
import com.web.mall.model.Manage_ItemService;

@Controller
public class MainPageController extends Manage_C_Module {
	@Autowired
	Manage_ItemService ItemService;
	@Autowired
	Manage_ItemCategoryService categoryService;
	
	//메인페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Home(ModelAndView mv, HttpSession session) {
		//최근 추가된 상품 정보 불러오기
		//각 dto 연동 필요
		List<Manage_ItemDTO> ItemList = ItemService.selectMainPageItemList();
		mv.addObject("ItemList", ItemList);
		
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		mv.addObject("navList", category);
		mv.setViewName("index");
		return mv;
	}
}