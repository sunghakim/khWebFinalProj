package com.web.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_AccountDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_AccountMapper";
	
	
	public int selectTotalPageCount() {
		return this.session.selectOne(Mapper + ".selectTotalPageCount");
	}

	public Manage_AccountDTO selectOne(int accountID) {
		return this.session.selectOne(Mapper + ".selectOne", accountID);
	}
	
	public List<Manage_AccountDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public int delete(String accountID) {
		return this.session.delete(Mapper + ".delete", accountID);
	}
}
