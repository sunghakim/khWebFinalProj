package com.web.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_CouponDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_CouponMapper";

	public List<Manage_CouponDTO> selectList() {
		return this.session.selectList(Mapper + ".selectList");
	}

	public Manage_CouponDTO selectOne(String ID) {
		return this.session.selectOne(Mapper + ".selectOne", ID);
	}
	
	public int insert(Manage_CouponDTO DTO) {
		return this.session.insert(Mapper + ".insert", DTO);
	}

	public int update(Manage_CouponDTO DTO) {
		return this.session.update(Mapper + ".update", DTO);
	}
	
	public int delete(String ID) {
		return this.session.delete(Mapper + ".delete", ID);
	}
}
