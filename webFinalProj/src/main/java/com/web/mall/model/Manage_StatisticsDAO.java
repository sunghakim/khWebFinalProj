package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_StatisticsDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_StatisticsMapper";

	public int selectTotalCount(int Type) {
		switch(Type) {
		case(1)://30일 안의 판매갯수순위 체크
			return this.session.selectOne(Mapper + ".selectTotalDailySoldCount");
		case(2)://12개월 안의 판매갯수순위 체크
			return this.session.selectOne(Mapper + ".selectTotalMonthlySoldCount");
		case(3)://30일 안의 매출순위 체크
			return this.session.selectOne(Mapper + ".selectTotalDailySalesCount");
		case(4)://12개월 안의 매출순위 체크
			return this.session.selectOne(Mapper + ".selectTotalMonthlySalesCount");
		}
		return 0;
	}
	
	public List<Manage_SoldHistoryDTO> getStatistics(int Type) {
		switch(Type) {
		case(1)://30일 안의 판매갯수순위 체크
			return this.session.selectList(Mapper + ".selectDailySoldCount");
		case(2)://12개월 안의 판매갯수순위 체크
			return this.session.selectList(Mapper + ".selectMonthlySoldCount");
		case(3)://30일 안의 매출순위 체크
			return this.session.selectList(Mapper + ".selectDailySales");
		case(4)://12개월 안의 매출순위 체크
			return this.session.selectList(Mapper + ".selectMonthlySales");
		}
		return null;
	}
}
