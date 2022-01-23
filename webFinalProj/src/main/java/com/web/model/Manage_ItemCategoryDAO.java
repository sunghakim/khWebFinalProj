package com.web.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_ItemCategoryDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_ItemCategoryMapper";

	public List<Manage_ItemCategoryDTO> selectList() {
		return this.session.selectList(Mapper + ".selectList");
	}

	public Manage_ItemCategoryDTO selectOne(int ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}
	
	public int insert(Manage_ItemDTO DTO) {
		return this.session.insert(Mapper + ".insert", DTO);
	}

	public int update(Manage_ItemDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
	
	public int delete(int ID) {
		return this.session.delete(Mapper + ".delete", ID);
	}
}
