package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	private ItemService service;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	public String selectItem(Model model, int item_category_id) {
		List<ItemDTO> datas = service.getItem(item_category_id);
		model.addAttribute("datas", datas);
		return "user/shop/productList"; //servlet의 viewResolver가 가져감 ->"/WEB-INF/views/jinitest" + itemlist + .jsp
	}  
	
	
}
