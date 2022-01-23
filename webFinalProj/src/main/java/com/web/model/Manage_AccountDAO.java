package com.web.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_AccountDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "AccountMapper";

	public List<Manage_AccountDTO> selectList() {
		return this.session.selectList(Mapper + ".selectList");
	}

	public Manage_AccountDTO selectOne(String ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}
	public int delete(String ID) {
		return this.session.delete(Mapper + ".deleteAccount",ID);
	}
}
