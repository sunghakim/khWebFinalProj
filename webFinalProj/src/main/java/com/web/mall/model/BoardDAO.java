package com.web.mall.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sess;
	
	public BoardVO selectBoard(String ID) {
		BoardVO result = this.sess.selectOne("BoardMapper.FindName", ID);
		return result;
	}
}
