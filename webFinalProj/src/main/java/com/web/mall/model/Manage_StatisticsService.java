package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_StatisticsService extends Manage_S_Module {
	
	@Autowired
	Manage_StatisticsDAO dao;
	
	public int selectTotalCount(int Type) {
		return dao.selectTotalCount(Type);
	}
	
	public List<Manage_SoldHistoryDTO> getStatistics(int Type) {
		return dao.getStatistics(Type);
	}
}
