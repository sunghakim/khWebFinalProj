package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_AccountService {
	
	@Autowired
	Manage_AccountDAO dao;

	public List<Manage_AccountDTO> selectList() {
		return dao.selectList();
	}
	
	public Manage_AccountDTO selectOne(String ID) {
		return dao.selectOne(ID);
	}

	public boolean delete(String ID) {
		return dao.delete(ID) == 1 ? true:false;
	}
}
