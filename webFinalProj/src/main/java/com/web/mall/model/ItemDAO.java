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
	public ItemDTO selectItem(ItemDTO vo) {
		return sqlSession.selectOne("ItemMapper.selectItem", vo);
	}
	public ItemOptionDTO selectItemOption(ItemOptionDTO vo) {
		return sqlSession.selectOne("ItemMapper.selectItemOption", vo);
	}



	
}
