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
import com.web.mall.model.Manage_ItemDTO;
import com.web.mall.model.Manage_ItemService;

@Controller
public class Manage_ItemController extends Manage_C_Module {

	@Autowired
	Manage_ItemService Service;
	
	@Autowired
	Manage_ItemCategoryService ItemCategoryService;
	
	//페이지 링크
	private final String URL = "/Manager_test/Item";
	
	//상품 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectItemList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);
			
			int Page = setPage(mv, request);
			List<Manage_ItemDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//상품 상세 조회
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectItem(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ItemDTO DTO) {
		if (isManager(mv, session, URL + "Detail") == 0) {
			mv.addObject("Item", Service.selectOne(DTO));
		}
		return mv;
	}
	
	//상품 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertItem(HttpSession session, ModelAndView mv) {
		isManager(mv, session, URL + "Insert");
		
		List<Manage_ItemCategoryDTO> List = ItemCategoryService.selectAll();
		mv.addObject("ItemCategoryList", List);

		mv.addObject("status", "insert");
		return mv;
	}
	
	//상품DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertItem(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ItemDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.insert(DTO));
			selectItemList(session, mv, request);
		}
		return mv;
	}
	
	//상품 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, Manage_ItemDTO DTO) {
		if (isManager(mv, session, URL + "Insert") == 0) {
			mv.addObject("Item", Service.selectOne(DTO));
		}
		
		List<Manage_ItemCategoryDTO> List = ItemCategoryService.selectAll();
		mv.addObject("ItemCategoryList", List);

		mv.addObject("status", "update");
		return mv;
	}
	
	//상품DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ItemDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(DTO));
			selectItemList(session, mv, request);
		}
		return mv;
	}

	//상품DB에 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ItemDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.delete(DTO));
			selectItemList(session, mv, request);
		}
		return mv;
	}
}
