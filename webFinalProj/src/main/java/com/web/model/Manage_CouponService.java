package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_CouponService {
	
	@Autowired
	Manage_CouponDAO dao;
	
	public List<Manage_CouponDTO> selectList() {
		return dao.selectList();
	}

	public Manage_CouponDTO selectOne(String ID) {
		return dao.selectOne(ID);
	}
	
	public boolean insert(Manage_CouponDTO DTO) {
		return dao.insert(DTO) == 1 ? true:false;
	}
	
	public boolean update(Manage_CouponDTO DTO) {
		return dao.update(DTO) == 1 ? true:false;
	}
	
	public boolean delete(String ID) {
		return dao.delete(ID) == 1 ? true:false;
	}
}
