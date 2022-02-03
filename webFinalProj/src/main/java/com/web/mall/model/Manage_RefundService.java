package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_RefundService extends Manage_S_Module {
	
	@Autowired
	Manage_RefundDAO dao;

	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}
	
	public List<Manage_SoldHistoryDTO> selectList(int Page) {
		return dao.selectList(Page);
	}

	public Manage_SoldHistoryDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_SoldHistoryDTO DTO) throws Exception {
		if (dao.update(DTO) == 2) {
			return true;
		} else {
			throw new Exception("환불 처리중 문제발생");
		}
	}
}
