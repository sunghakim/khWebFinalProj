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
	
	//김성하 작업
	public ItemDTO getItemDetail(ItemDTO dto) {
		return ItemDAO.selectItemDetail(dto);
	}
	public List<ItemOptionDTO> getItemOptions(ItemOptionDTO dto) {
		return ItemDAO.selectItemOptions(dto);
	}
	public boolean addShoppingList(ShoppingListVO vo) {
		if(ItemDAO.insertShoppingList(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public List<QuestionVO> getQuestions(QuestionVO vo) {
		return ItemDAO.selectQuestionList(vo);
	}
	public QuestionVO getOneQuestion(QuestionVO vo) {
		return ItemDAO.selectQuestion(vo);
	}
	public boolean addQuestion(QuestionVO vo) {
		if(ItemDAO.insertQuestion(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
