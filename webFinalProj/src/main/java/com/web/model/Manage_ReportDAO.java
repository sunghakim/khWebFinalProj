package com.web.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_ReportDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "ReportMapper";

	public List<Manage_ReportDTO> selectList() {
		return this.session.selectList(Mapper + ".selectList");
	}

	public Manage_ReportDTO selectOne(int ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}
	
	public int update(Manage_ReportDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
}
