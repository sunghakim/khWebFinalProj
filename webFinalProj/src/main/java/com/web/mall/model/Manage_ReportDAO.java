package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_ReportDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_ReportMapper";

	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}
	
	public List<Manage_ReportDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public Manage_ReportDTO selectPunish(Manage_ReportDTO DTO) {
		return this.session.selectOne(Mapper + ".selectPunish", DTO);
	}
	
	public int insertPunish(Manage_ReportDTO DTO) {
		return this.session.insert(Mapper + ".insertPunish", DTO);
	}
	
	public int updatePunish(Manage_ReportDTO DTO) {
		return this.session.update(Mapper + ".updatePunish", DTO);
	}
	
	public int updateReport(Manage_ReportDTO DTO) {
		return this.session.update(Mapper + ".updateReport", DTO);
	}
}
