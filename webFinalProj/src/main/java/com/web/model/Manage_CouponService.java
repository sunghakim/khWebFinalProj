package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_CouponService extends Manage_S_Module {
	
	@Autowired
	Manage_CouponDAO dao;

	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}
	
	public Manage_CouponDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	public List<Manage_CouponDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insert(Manage_CouponDTO DTO) throws Exception{
		if (dao.insert(DTO) == 1) {
			return true;
		} else {
			throw new Exception("쿠폰 추가 처리중 문제발생");
		}
	}
}
