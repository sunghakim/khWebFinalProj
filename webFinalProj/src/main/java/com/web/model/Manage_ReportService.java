package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_ReportService extends Manage_S_Module {
	
	@Autowired
	Manage_ReportDAO dao;

	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}

	public Manage_ReportDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	public List<Manage_ReportDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_ReportDTO DTO) throws Exception {
		if (dao.update(DTO) == 2) {
			return true;
		} else {
			throw new Exception("신고 내역 처리중 문제발생");
		}
	}
}
