package com.web.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_SoldHistoryDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_SoldHistoryMapper";

	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}
	
	public List<Manage_SoldHistoryDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
}
