package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_ItemService extends Manage_S_Module {
	
	@Autowired
	Manage_ItemDAO dao;

	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}

	public Manage_ItemDTO selectOne(Manage_ItemDTO DTO) {
		return dao.selectOne(DTO);
	}
	
	public List<Manage_ItemDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insert(Manage_ItemDTO DTO) throws Exception{
		if (dao.searchItemID(DTO) == null) {
			if (dao.insertItem(DTO) != 1) {
				throw new Exception("상품 추가 처리중 문제발생");
			}
		}
		if (dao.insertItemOption(DTO) == 1) {
			return true;
		} else {
			throw new Exception("상품옵션 추가 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_ItemDTO DTO) throws Exception{
		if (dao.updateItem(DTO) == 1) {
			if (dao.updateItemOption(DTO) == 1) {
				return true;
			} else {
				throw new Exception("상품옵션 수정 처리중 문제발생");
			}
		} else {
			throw new Exception("상품 수정 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(Manage_ItemDTO DTO) throws Exception{
		if (dao.delete(DTO) == 1) {
			return true;
		} else {
			throw new Exception("상품 삭제 처리중 문제발생");
		}
	}
}
