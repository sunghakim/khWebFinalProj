package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {

	@Autowired
	private BoardDAO BoardDAO;
	
	public List<BoardDTO> getBoard(int board_id){
		return BoardDAO.selectBoard(board_id);
	}
	
	public List<BoardDTO> getGoodBoard(int board_id){
		return BoardDAO.selectGoodBoard(board_id);
	}
	
}
