package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {

	@Autowired
	private BoardDAO BoardDAO;
	
	
	public List<BoardDTO> getBoard(int board_id, int page_num){
		BoardDTO dto = new BoardDTO();
		dto.setBoard_id(board_id);
		dto.setPage_num(page_num);
		return BoardDAO.selectBoard(dto);
	}
	
	public List<BoardDTO> getGoodBoard(int board_id, int page_num){
		BoardDTO dto = new BoardDTO();
		dto.setBoard_id(board_id);
		dto.setPage_num(page_num);
		return BoardDAO.selectGoodBoard(dto);
	}
	
}
