package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_ReportService {
	
	@Autowired
	Manage_ReportDAO dao;
	
	public List<Manage_ReportDTO> selectList() {
		return dao.selectList();
	}

	public Manage_ReportDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}

	public boolean update(Manage_ReportDTO DTO) {
		return dao.update(DTO) == 1 ? true : false;
	}
}
