package com.web.mall.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	@Autowired
	private ItemDAO dao;
	
	//상품 리스트 가져오기
	public List<ItemDTO> getItem(int item_category_id, int page_num) {
		ItemDTO dto = new ItemDTO();
		dto.setItem_category_id(item_category_id);
		dto.setPage_num(page_num);
		return dao.selectItemList(dto);
	}
	
	//찜 높은순으로 데이터 3개 가져오기
	public List<ItemDTO> getZzimItem(int item_category_id) {
		ItemDTO dto = new ItemDTO();
		List<ItemDTO> data = dao.selectZzimHigh(); //찜 많은 아이템아이디순으로 가져오기
		List<ItemDTO> li = new ArrayList<ItemDTO>();
		
		li.add(data.get(0));
		li.add(data.get(1));
		li.add(data.get(2));
		
		List<ItemDTO> ld = new ArrayList<ItemDTO>();
		
		for(int i=0;i<li.size();i++) {
			ItemDTO ha = dao.selectItemDetail(li.get(i));
			ld.add(ha);
		}
		
		return ld;
	}
	//리뷰 높은순으로 데이터 3개 가져오기
	public List<ItemDTO> getReviewItem(int item_category_id) {
		ItemDTO dto = new ItemDTO();
		List<ItemDTO> data = dao.selectReviewHigh(); //찜 많은 아이템아이디순으로 가져오기
		List<ItemDTO> li = new ArrayList<ItemDTO>();
		
		li.add(data.get(0));
		li.add(data.get(1));
		li.add(data.get(2));
		
		
		List<ItemDTO> ld = new ArrayList<ItemDTO>();
		
		for(int i=0;i<li.size();i++) {
			ItemDTO ha = dao.selectItemDetail(li.get(i));
			ld.add(ha);
		}
		
		return ld;
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
