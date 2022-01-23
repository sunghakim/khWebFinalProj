package com.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_NoticeService {
	
	@Autowired
	Manage_NoticeDAO dao;
	
	public List<Manage_NoticeDTO> selectList() {
		return dao.selectList();
	}

	public Manage_NoticeDTO selectOne(int ID) {
		return dao.selectOne(ID);
	}
	
	public boolean insert(Manage_NoticeDTO DTO) {
		return dao.insert(DTO) == 1 ? true:false;
	}
	
	public boolean update(Manage_NoticeDTO DTO) {
		return dao.update(DTO) == 1 ? true:false;
	}
	
	public boolean delete(int ID) {
		return dao.delete(ID) == 1 ? true:false;
	}
}
