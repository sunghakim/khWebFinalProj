package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingListDAO {
	@Autowired
	private SqlSession sess;
	
	public int insertShoppingList(ShoppingListVO vo) {
		return this.sess.insert("ShoppingMapper.insertShoppingList", vo);
	}
	public List<ShoppingListVO> selectPaymentShoppingList(ShoppingListVO vo) {
		return this.sess.selectList("ShoppingMapper.selectOneShoppingList", vo);
	}
	public List<ShoppingListVO> selectShoppingLists(ShoppingListVO vo) {
		System.out.println(vo);
		return this.sess.selectList("ShoppingMapper.selectShoppingLists", vo);
	}
	public ShoppingListVO selectShoppingListItem(ShoppingListVO vo) {
		return this.sess.selectOne("ShoppingMapper.selectShoppingListItem", vo);
	}
	public ShoppingListVO selectShoppingListItem(int shoppingListId) {
		return this.sess.selectOne("ShoppingMapper.selectShoppingListItemById", shoppingListId);
	}
	public int deleteShoppingList(ShoppingListVO vo) {
		return this.sess.delete("ShoppingMapper.deleteShoppingList", vo);
	}
	public int updateShoppingList(ShoppingListVO vo) {
		System.out.println(vo);
		return this.sess.update("ShoppingMapper.updateShoppingList", vo);
	}
}
