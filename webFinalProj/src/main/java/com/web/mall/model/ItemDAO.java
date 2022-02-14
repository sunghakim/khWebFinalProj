package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {

	@Autowired
	SqlSession sqlSession;
	
	public List<ItemDTO> selectItem(int item_category_id) {
		List<ItemDTO> datas = sqlSession.selectList("ItemMapper.selectItemList", item_category_id);
		return datas;
	}
	
	
	//김성하 작업
	public ItemDTO selectItemDetail(ItemDTO dto) {
		return sqlSession.selectOne("ItemMapper.selectItemDetail", dto);
	}
	public List<ItemOptionDTO> selectItemOptions(ItemOptionDTO dto) {
		return sqlSession.selectList("ItemMapper.selectItemOptionList", dto);
	}
	public int insertShoppingList(ShoppingListVO vo) {
		return sqlSession.insert("ItemMapper.insertShoppingList", vo);
	}
	public List<QuestionVO> selectQuestionList(QuestionVO vo) {
		return sqlSession.selectList("ItemMapper.selectQuestionList", vo);
	}
	public QuestionVO selectQuestion(QuestionVO vo) {
		return sqlSession.selectOne("ItemMapper.selectQuestion", vo);
	}
	public int insertQuestion(QuestionVO vo) {
		return sqlSession.insert("ItemMapper.insertQuestion", vo);
	}



	
}
