package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_QuestionDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_QuestionMapper";

	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}

	public Manage_QuestionDTO selectOne(int ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}
	
	public List<Manage_QuestionDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}

	public int update(Manage_QuestionDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
}
