package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_QuestionService extends Manage_S_Module {
	
	@Autowired
	Manage_QuestionDAO dao;

	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}
	
	public Manage_QuestionDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	public List<Manage_QuestionDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_QuestionDTO DTO) throws Exception{
		if (dao.update(DTO) == 1) {
			return true;
		} else {
			throw new Exception("문의답변 추가 처리중 문제발생");
		}
	}
}
