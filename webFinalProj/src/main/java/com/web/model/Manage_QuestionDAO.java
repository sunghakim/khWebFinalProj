package com.web.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_QuestionDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "QuestionMapper";

	public List<Manage_QuestionDTO> selectList() {
		return this.session.selectList(Mapper + ".selectList");
	}

	public Manage_QuestionDTO selectOne(int ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}
	
	public int insert(Manage_QuestionDTO DTO) {
		return this.session.delete(Mapper + ".insert", DTO);
	}

	public int update(Manage_QuestionDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
	
	public int delete(int ID) {
		return this.session.delete(Mapper + ".delete", ID);
	}
}
