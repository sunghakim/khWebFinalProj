package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_AccountService extends Manage_S_Module {
	
	@Autowired
	Manage_AccountDAO dao;
	
	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}
	
	public List<Manage_AccountDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int updateBan(String reportedAccountID) throws Exception{
		return dao.updateBan(reportedAccountID);
	}

	public Manage_AccountDTO selectOne(String accountID) {
		return dao.selectOne(accountID);
	}
}
