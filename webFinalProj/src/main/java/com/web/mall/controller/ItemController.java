package com.web.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mall.model.*;

@Controller
@RequestMapping(value="/item")
public class ItemController {

	
	@Autowired
	private ItemService ItemService;
	
	//선택한 상세 카테고리 상품들 조회
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String selectItem(Model model, int item_category_id) {
		List<ItemDTO> datas = ItemService.getItem(item_category_id);
		model.addAttribute("datas", datas);
		return "item"; //item.jsp에 매치
	}
	
	
}
