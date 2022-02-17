package com.web.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mall.model.*;

@Controller
public class ItemController {
	@Autowired
	private ItemService service;
	@Autowired
	Manage_ItemCategoryService categoryService;
	
	
	
	//선택한 상품 리스트 받아오기
	@RequestMapping(value = "/item/list", method = RequestMethod.GET) 
	public String selectItem(Model model, int item_category_id, int page_num) {
		System.out.println("1");
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		System.out.println("2");
		model.addAttribute("navList", category);
		System.out.println("3");
		System.out.println("상품카테고리: "+item_category_id);
		List<ItemDTO> datas = service.getItem(item_category_id, page_num);
		for(ItemDTO dto:datas) {
			System.out.println(dto.toString());
		}
		
		// 카테고리 번호
		System.out.println("4");
		model.addAttribute("nav", item_category_id);
		
		model.addAttribute("datas", datas);
		
		System.out.println("6");
		selectZzim(model, item_category_id);
		selectReview(model, item_category_id);
		return "/user/shop/productList"; 
	}  
	//선택한 카테고리의 찜수 높은거 3개 가져오기
	
	public String selectZzim(Model model, int item_category_id) {
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		model.addAttribute("navList", category);
		
		System.out.println("3");
		List<ItemDTO> datas = service.getZzimItem(item_category_id);
		// 카테고리 번호
		System.out.println("4");
		model.addAttribute("nav", item_category_id);
		System.out.println("5");
		model.addAttribute("zzim", datas);
		
		
		
		System.out.println("6");
		return "/user/shop/productList"; 
	}  
	
	//선택한 리뷰수 높은거 3개 가져오기

	public String selectReview(Model model, int item_category_id) {
		System.out.println("1");
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		System.out.println("2");
		model.addAttribute("navList", category);
		System.out.println("3");
		List<ItemDTO> datas = service.getReviewItem(item_category_id);
		// 카테고리 번호
		model.addAttribute("nav", item_category_id);
		System.out.println("5");
		model.addAttribute("review", datas);
		
		
		
		System.out.println("6");
		return "/user/shop/productList"; 
	}  
	
}
