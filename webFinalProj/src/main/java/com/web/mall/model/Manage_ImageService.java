package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_ImageService extends Manage_S_Module {
	
	@Autowired
	Manage_ImageDAO dao;
	
	public List<Manage_ImageDTO> selectList(int ID) {
		return dao.selectList(ID);
	}

	public void insertList(List<Manage_ImageDTO> List) throws Exception{
		System.out.println("Run ImageService");
		if (dao.insertList(List) != List.size()) {
			throw new Exception("이미지 추가 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(Manage_ImageDTO DTO) throws Exception{
		if (dao.delete(DTO) == 1) {
			return true;
		} else {
			throw new Exception("이미지 삭제 처리중 문제발생");
		}
	}
}
