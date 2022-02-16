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

@Controller
public class Manage_ItemCategoryController extends Manage_C_Module {
	
	@Autowired
	Manage_ItemCategoryService Service;
	
	//관리페이지 링크
	private final String URL = "/Manager/ItemCategory";
	
	//상품 카테고리 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectItemCategoryList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);
			
			int Page = setPage(mv, request);
			List<Manage_ItemCategoryDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//상품 카테고리DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertItemCategory(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ItemCategoryDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			DTO.setNavShow('F');
			setResult(mv, Service.insert(DTO));
			selectItemCategoryList(session, mv, request);
		}
		return mv;
	}
		
	//상품 카테고리DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateItemCategory(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ItemCategoryDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(DTO));
			selectItemCategoryList(session, mv, request);
		}
		return mv;
	}

	//상품 카테고리DB 삭제
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteItemCategory(HttpSession session, ModelAndView mv, HttpServletRequest request, int ItemCategoryID) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.delete(ItemCategoryID));
			selectItemCategoryList(session, mv, request);
		}
		return mv;
	}
}
