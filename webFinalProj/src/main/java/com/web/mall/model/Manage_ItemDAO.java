package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_ItemDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_ItemMapper";
	
	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}

	public Manage_ItemDTO selectOne(Manage_ItemDTO DTO) {
		//ItemID, ItemOptionID 필요
		return this.session.selectOne(Mapper + ".selectOne", DTO);
	}
	
	public List<Manage_ItemDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public int insert(Manage_ItemDTO DTO) {
		return this.session.delete(Mapper + ".insert", DTO);
	}

	public int update(Manage_ItemDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
	
	public int delete(Manage_ItemDTO DTO) {
		return this.session.delete(Mapper + ".delete", DTO);
	}
}
