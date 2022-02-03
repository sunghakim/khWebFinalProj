package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
