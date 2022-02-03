package com.web.mall.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_StatisticsDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_StatisticsMapper";

	public List<Map<String, Integer>> getStatistics(int Type, Date Date) {
		switch(Type) {
		case(1)://30일 안의 판매갯수순위 체크
			return this.session.selectList(Mapper + ".selectDailySoldCount", Date);
		case(2)://12개월 안의 판매갯수순위 체크
			return this.session.selectList(Mapper + ".selectMonthlySoldCount", Date);
		case(3)://30일 안의 매출순위 체크
			return this.session.selectList(Mapper + ".selectDailySales", Date);
		case(4)://12개월 안의 매출순위 체크
			return this.session.selectList(Mapper + ".selectMonthlySales", Date);
		}
		return null;
	}
}
