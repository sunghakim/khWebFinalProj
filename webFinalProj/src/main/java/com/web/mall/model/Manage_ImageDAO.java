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
	
	public List<Manage_ImageDTO> selectList(Manage_ImageDTO dto) {
		return this.session.selectList(Mapper + ".selectList", dto);
	}

	public int insertList(List<Manage_ImageDTO> List) {
		System.out.println("Run ImageDAO");
		int count = 0;
		for (Manage_ImageDTO dto : List) {
			System.out.println("insertList: dto: " + dto.toString());
			this.session.insert(Mapper + ".insert", dto);//맵핑에러
			count++;
			System.out.println("insertList: " + count);
		}
		return count;
	}
	
	public int updateList(Manage_ImageDTO dto) {
		return this.session.update(Mapper + ".update", dto);
	}
	
	public int delete(Manage_ImageDTO dto) {
		return this.session.delete(Mapper + ".delete", dto);
	}
}
