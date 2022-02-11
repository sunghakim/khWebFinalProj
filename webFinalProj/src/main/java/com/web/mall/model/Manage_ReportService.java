package com.web.mall.model;

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
	
	public List<Manage_ReportDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_ReportDTO DTO) throws Exception {
		switch(DTO.getResult()) {
		case(2)://활동제제
			Manage_ReportDTO temp = dao.selectPunish(DTO);
			
			if (temp == null) {
				if (dao.insertPunish(DTO) != 1) {
					throw new Exception("신고 내역 처리중 문제발생");
				}
			} else {
				System.out.println("temp: " + temp.toString());
				if (dao.updatePunish(temp) != 1) {
					throw new Exception("신고 내역 처리중 문제발생");
				}
			}
			if (dao.updateReport(DTO) != 1) {
				throw new Exception("신고 내역 처리중 문제발생");
			}
			break;
		case(3)://기각
			if (dao.updateReport(DTO) != 1) {
				throw new Exception("신고 내역 처리중 문제발생");
			}
		}
		return true;
	}
}
