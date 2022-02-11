package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_RefundDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_RefundMapper";

	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}
	
	public List<Manage_SoldHistoryDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}

	public int update(Manage_SoldHistoryDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
}
