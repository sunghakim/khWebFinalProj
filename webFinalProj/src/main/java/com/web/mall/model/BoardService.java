package com.web.mall.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public BoardVO getBoard(String ID) {
		BoardVO result = dao.selectBoard(ID);
		return result;
	}
	
}
