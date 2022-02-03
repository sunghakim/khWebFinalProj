package com.web.model;

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
	public boolean delete(String ID) throws Exception{
		if (dao.delete(ID) == 1) {
			return true;
		} else {
			throw new Exception("계정 탈퇴 처리중 문제발생");
		}
	}
}
