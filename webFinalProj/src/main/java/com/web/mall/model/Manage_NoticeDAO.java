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

	public Manage_NoticeDTO selectOne(int PostID) {
		return this.session.selectOne(Mapper + ".selectOne", PostID);
	}
	
	public List<Manage_NoticeDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public int insert(Manage_NoticeDTO DTO) {
		return this.session.delete(Mapper + ".insert", DTO);
	}

	public int update(Manage_NoticeDTO DTO) {
		int res = this.session.update(Mapper + ".update", DTO);
		return res;
	}
	
	public int delete(int PostID) {
		return this.session.delete(Mapper + ".delete", PostID);
	}
}
