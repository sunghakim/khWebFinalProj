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
	
	public List<Manage_ImageDTO> selectList(int ID) {
		return this.session.selectList(Mapper + ".selectList", ID);
	}

	public int insertList(List<Manage_ImageDTO> List) {
		System.out.println("Run ImageDAO");
		int count = 0;
		for (Manage_ImageDTO dto : List) {
			this.session.insert(Mapper + ".insert", dto);//에러
			count++;
			System.out.println("insertList: " + count);
			System.out.println("insertList: dto: " + dto.toString());
		}
		return count;
	}
	
	public int delete(Manage_ImageDTO DTO) {
		return this.session.delete(Mapper + ".delete", DTO);
	}
}
