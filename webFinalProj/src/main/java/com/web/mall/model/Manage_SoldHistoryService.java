package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_SoldHistoryService extends Manage_S_Module {
	
	@Autowired
	Manage_SoldHistoryDAO dao;
	
	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}
	
	public List<Manage_SoldHistoryDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void insertSoldHistory(Manage_SoldHistoryDTO soldHistoryDTO) throws Exception{
		if (dao.insertSolsdDetail(soldHistoryDTO) != 1) {
			throw new Exception("문의답변 추가 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void insertSoldDetail(Manage_SoldHistoryDTO soldHistoryDTO) throws Exception{
		if (dao.insertSolsdDetail(soldHistoryDTO) != 1) {
			throw new Exception("문의답변 추가 처리중 문제발생");
		}
	}
}
