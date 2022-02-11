package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_ItemCategoryDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_ItemCategoryMapper";

	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}
	
	public List<Manage_ItemCategoryDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public List<Manage_ItemCategoryDTO> selectAll() {
		return this.session.selectList("Manage_ItemCategoryMapper.selectAll");
	}
	
	public int insert(Manage_ItemCategoryDTO DTO) {
		return this.session.insert(Mapper + ".insert", DTO);
	}

	public int update(Manage_ItemCategoryDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
	
	public int delete(int ID) {
		return this.session.delete(Mapper + ".delete", ID);
	}
}
