package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	@Autowired
	private ItemDAO ItemDAO;
	
	public List<ItemDTO> getItem(int item_category_id) {
		return ItemDAO.selectItem(item_category_id);
	}

}
