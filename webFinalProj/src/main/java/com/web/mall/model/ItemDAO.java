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

}
