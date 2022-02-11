package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mall.model.*;


@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService BoardService;
	
	//선택한 상세 게시판의 게시글 조회
	@RequestMapping(value = "/boardnew", method = RequestMethod.GET) 
	public String selectBoard(Model model, int board_id) {
		List<BoardDTO> datas = BoardService.getBoard(board_id);
		model.addAttribute("datas", datas);
		return "board"; //board.jsp에 매치
	} 
	
	//선택한 상세 게시판의 좋아요 많은 게시글 조회
	@RequestMapping(value = "/boardgood", method = RequestMethod.GET) 
	public String goodBoard(Model model, int board_id) {
		List<BoardDTO> datas = BoardService.getGoodBoard(board_id);
		model.addAttribute("datas", datas);
		return "board"; //board.jsp에 매치
	} 
	
	
}
