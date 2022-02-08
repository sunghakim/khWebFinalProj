package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_AccountDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_AccountMapper";
	
	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}
	
	public List<Manage_AccountDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public int delete(String accountID) {
		return this.session.delete(Mapper + ".delete", accountID);
	}
}
