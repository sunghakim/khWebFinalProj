package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_CouponDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_CouponMapper";
	
	public int selectTotalCount() {
		return this.session.selectOne(Mapper + ".selectTotalCount");
	}

	public Manage_CouponDTO selectOne(int ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}

	public List<Manage_CouponDTO> selectList(int Page) {
		return this.session.selectList(Mapper + ".selectList", Page);
	}
	
	public int insert(Manage_CouponDTO DTO) {
		return this.session.insert(Mapper + ".insert", DTO);
	}
	
	public int delete(String ID) {
		return this.session.delete(Mapper + ".delete", ID);
	}
}
