package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_QuestionService {
	
	@Autowired
	Manage_QuestionDAO dao;
	
	public List<Manage_QuestionDTO> selectList() {
		return dao.selectList();
	}

	public Manage_QuestionDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	public boolean update(Manage_QuestionDTO DTO) {
		return dao.update(DTO) == 1 ? true:false;
	}
}
