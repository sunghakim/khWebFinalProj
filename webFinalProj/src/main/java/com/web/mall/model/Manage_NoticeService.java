package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_NoticeService extends Manage_S_Module {
	
	@Autowired
	Manage_NoticeDAO dao;
	
	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}

	public Manage_NoticeDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	public List<Manage_NoticeDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insert(Manage_NoticeDTO DTO) throws Exception {
		if (dao.insert(DTO) == 1) {
			return true;
		} else {
			throw new Exception("공지사항 추가 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_NoticeDTO DTO) throws Exception {
		if (dao.update(DTO) == 1) {
			return true;
		} else {
			throw new Exception("공지사항 수정 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(int ID) throws Exception {
		if (dao.delete(ID) == 1) {
			return true;
		} else {
			throw new Exception("공지사항 삭제 처리중 문제발생");
		}
	}
}
