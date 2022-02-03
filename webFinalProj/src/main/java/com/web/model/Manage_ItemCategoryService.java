package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_ItemCategoryService extends Manage_S_Module {
	
	@Autowired
	Manage_ItemCategoryDAO dao;

	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}
	
	public List<Manage_ItemCategoryDTO> selectList(int Page) {
		return dao.selectList(Page);
	}

	public Manage_ItemCategoryDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insert(Manage_ItemCategoryDTO DTO) throws Exception{
		if (dao.insert(DTO) == 1) {
			return true;
		} else {
			throw new Exception("상품 카테고리 추가 처리중 문제발생");
		}
		
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_ItemCategoryDTO DTO) throws Exception{
		if (dao.update(DTO) == 1) {
			return true;
		} else {
			throw new Exception("상품 카테고리 수정 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(int ID) throws Exception{
		if (dao.delete(ID) == 1) {
			return true;
		} else {
			throw new Exception("상품 카테고리 삭제 처리중 문제발생");
		}
	}
}
