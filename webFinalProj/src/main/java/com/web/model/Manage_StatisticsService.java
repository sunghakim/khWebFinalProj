package com.web.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_StatisticsService extends Manage_S_Module {
	
	@Autowired
	Manage_StatisticsDAO dao;
	
	public List<Map<String, Integer>> getStatistics(int Type, Date Date) {
		return dao.getStatistics(Type, Date);
	}
}
