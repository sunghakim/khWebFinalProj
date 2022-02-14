package com.web.mall.controller;

import java.util.List;


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
	
	//메인페이지(인기글 3개, 공지1개, 최신글 2개) 더보기 있음
	@RequestMapping(value = "/goodboard", method = RequestMethod.GET) 
	public String Home(Model model, int board_id){
		return "user/community/home"; //servlet의 viewResolver가 가져감 ->"/WEB-INF/views/jinitest" + board + .jsp
	} 
	
	
	//선택한 게시판(일반,공지)의 최신 게시글 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	public String selectBoard(Model model, int board_id, int page_num ) {
		
		if(board_id == 0) { //공지사항 게시판 가져오기
			List<BoardDTO> datas = BoardService.getBoard(board_id, page_num);
			model.addAttribute("datas", datas);
			return "user/community/list";
		}else { //일반 유저가 사용하는 게시판 가져오기
			List<BoardDTO> datas = BoardService.getBoard(board_id, page_num);
			model.addAttribute("datas", datas);
			return "user/community/list";//servlet의 viewResolver가 가져감 ->"/WEB-INF/views/jinitest" + board + .jsp
		}
	} 
	
	//일반 유저가 사용하는 게시판의 좋아요 많은 게시글 조회
	@RequestMapping(value = "/goodboard", method = RequestMethod.GET) 
	public String goodBoard(Model model, int board_id, int page_num){
		List<BoardDTO> datas = BoardService.getGoodBoard(board_id, page_num);
		model.addAttribute("datas", datas);
//		System.out.println(datas);
		return "user/community/list"; //servlet의 viewResolver가 가져감 ->"/WEB-INF/views/jinitest" + board + .jsp
	} 
	
	
}
