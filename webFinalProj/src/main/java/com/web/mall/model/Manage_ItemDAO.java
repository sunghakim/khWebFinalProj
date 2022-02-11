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
		return this.session.selectOne(Mapper + ".selectOne", DTO);
	}
	
	public List<Manage_ItemDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public Manage_ItemDTO searchItemID(Manage_ItemDTO DTO) {
		return this.session.selectOne(Mapper + ".searchItemID", DTO);
	}
	
	public int insertItem(Manage_ItemDTO DTO) {
		return this.session.delete(Mapper + ".insertItem", DTO);
	}
	
	public int insertItemOption(Manage_ItemDTO DTO) {
		return this.session.delete(Mapper + ".insertItemOption", DTO);
	}

	public int updateItem(Manage_ItemDTO DTO) {
		return this.session.update(Mapper + ".updateItem", DTO);
	}
	
	public int updateItemOption(Manage_ItemDTO DTO) {
		return this.session.delete(Mapper + ".updateItemOption", DTO);
	}
	
	public int delete(Manage_ItemDTO DTO) {
		return this.session.delete(Mapper + ".delete", DTO);
	}
}
