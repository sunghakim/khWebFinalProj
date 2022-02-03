package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_NoticeDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_NoticeMapper";
	
	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}

	public Manage_NoticeDTO selectOne(int ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}
	
	public List<Manage_NoticeDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public int insert(Manage_NoticeDTO DTO) {
		return this.session.delete(Mapper + ".insert", DTO);
	}

	public int update(Manage_NoticeDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
	
	public int delete(int ID) {
		return this.session.delete(Mapper + ".delete", ID);
	}
}
