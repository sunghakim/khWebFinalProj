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
	
	public Manage_ReportDTO selectPunish(Manage_ReportDTO dto) {
		return this.session.selectOne(Mapper + ".selectPunish", dto);
	}

	public int selectAllPunish(Manage_ReportDTO dto) {
		return this.session.selectOne(Mapper + ".selectAllPunish", dto);
	}
	
	public int insertPunish(Manage_ReportDTO dto) {
		return this.session.insert(Mapper + ".insertPunish", dto);
	}
	
	public int updatePunish(Manage_ReportDTO dto) {
		return this.session.update(Mapper + ".updatePunish", dto);
	}
	
	public int updateReport(Manage_ReportDTO dto) {
		return this.session.update(Mapper + ".updateReport", dto);
	}
}
