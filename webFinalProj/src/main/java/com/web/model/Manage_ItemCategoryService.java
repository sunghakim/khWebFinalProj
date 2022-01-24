package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_ItemCategoryService {
	
	@Autowired
	Manage_ItemCategoryDAO dao;
	
	public List<Manage_ItemCategoryDTO> selectList() {
		return dao.selectList();
	}

	public Manage_ItemCategoryDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	public boolean insert(Manage_ItemDTO DTO) {
		return dao.insert(DTO) == 1 ? true:false;
	}
	
	public boolean update(Manage_ItemDTO DTO) {
		return dao.update(DTO) == 1 ? true:false;
	}
	
	public boolean delete(int ID) {
		return dao.delete(ID) == 1 ? true:false;
	}
}
