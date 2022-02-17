package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manage_ImageDAO {
	
	@Autowired
	SqlSession session;
	private String Mapper = "Manage_ImageMapper";

	public int selectReferencesIDCount(Manage_ImageDTO dto) {
		return this.session.selectOne(Mapper + ".selectReferencesIDCount", dto);
	}
	
	public List<Manage_ImageDTO> selectList(Manage_ImageDTO dto) {
		return this.session.selectList(Mapper + ".selectList", dto);
	}

	public int insertList(List<Manage_ImageDTO> List) {
		
		//이미지 저장갯수(Count)를 반환
		int count = 0;
		for (Manage_ImageDTO dto : List) {
			this.session.insert(Mapper + ".insert", dto);
			count++;
		}
		return count;
	}
	
	public int deleteOne(int ImageID) {
		return this.session.delete(Mapper + ".deleteOne", ImageID);
	}
	
	public int deleteList(Manage_ImageDTO dto) {
		return this.session.delete(Mapper + ".deleteList", dto);
	}
}
