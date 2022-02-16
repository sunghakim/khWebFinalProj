package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	@Autowired
	private ItemDAO dao;
	
	public List<ItemDTO> getItem(int item_category_id, int page_num) {
		ItemDTO dto = new ItemDTO();
		dto.setItem_category_id(item_category_id);
		dto.setPage_num(page_num);
		return dao.selectItemList(dto);
	}
	
	
	//김성하 작업
	public ItemDTO getItemDetail(ItemDTO dto) {
		return dao.selectItemDetail(dto);
	}
	public List<ItemOptionDTO> getItemOptions(ItemOptionDTO dto) {
		return dao.selectItemOptions(dto);
	}
	public ItemDTO getItem(ItemDTO vo) {
		return dao.selectItem(vo);
	}
	public ItemOptionDTO getItemOption(ItemOptionDTO vo) {
		return dao.selectItemOption(vo);
	}
}
