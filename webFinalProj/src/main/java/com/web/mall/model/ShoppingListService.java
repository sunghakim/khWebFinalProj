package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingListService {
	@Autowired
	private ShoppingListDAO dao;
	
	public boolean addShoppingList(ShoppingListVO vo) {
		if(dao.insertShoppingList(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public List<ShoppingListVO> getPaymentShoppingList(ShoppingListVO vo) {
		return dao.selectPaymentShoppingList(vo);
	}
	public List<ShoppingListVO> getCarts(ShoppingListVO vo) {
		System.out.println("장바구니 실행됨!");
		System.out.println(vo);
		
		return dao.selectShoppingLists(vo);
	}
	public ShoppingListVO getCartItem(int shoppingListId) {
		return dao.selectShoppingListItem(shoppingListId);
	}
	public boolean deleteCartItem(ShoppingListVO vo) {
		if(dao.deleteShoppingList(vo) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean updateCartItem(ShoppingListVO vo) {
		if(dao.updateShoppingList(vo) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//승원 작업
	@Transactional(rollbackFor=Exception.class)
	public boolean deleteOne(ShoppingListVO vo) throws Exception{
		if(dao.deleteOne(vo) == 0) {
			return false;
		}else {
			throw new Exception("문의답변 추가 처리중 문제발생");
		}
	}
}
