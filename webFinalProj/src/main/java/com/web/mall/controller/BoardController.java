package com.web.mall.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mall.model.*;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService BoardService;
	@Autowired
	Manage_ItemCategoryService categoryService;
	
	//메인페이지(인기글 2개, 공지 2개, 최신글 2개 씩 받아옴)
	@RequestMapping(value = "/board", method = RequestMethod.GET) 
	public String Home(Model model){
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		model.addAttribute("navList", category);
		
		int page_num = 1;
		
		// 카테고리 번호 진희가 추가함
		model.addAttribute("nav", "7");
		
		List<BoardDTO> good = BoardService.getMainGood(page_num);
		model.addAttribute("good", good);
		
		List<BoardDTO> notice = BoardService.getMain(0, page_num);
		model.addAttribute("notice", notice);
		
		List<BoardDTO> recent = BoardService.getMain(1, page_num);
		model.addAttribute("recent", recent);
		/* 콘솔로 테스트 값 출력해봄 왜 커밋 안됨?
		System.out.println(good);
		System.out.println(notice);
		System.out.println(recent);
		*/
		return "user/community/home"; //servlet의 viewResolver가 가져감 ->"/WEB-INF/views/jinitest" + board + .jsp
	} 
	
	
	//선택한 게시판(일반,공지)의 최신 게시글 조회
	@RequestMapping(value = "/board/list", method = RequestMethod.GET) 
	public String selectBoard(Model model, int board_id, int page_num) {
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		model.addAttribute("navList", category);
		model.addAttribute("list", "list");
		List<BoardDTO> datas = BoardService.getBoard(board_id, page_num);
		model.addAttribute("board_id", board_id);
		model.addAttribute("datas", datas);
		return "user/community/list";//servlet의 viewResolver가 가져감 ->"/WEB-INF/views/jinitest" + board + .jsp
		
	} 
	
	//일반 유저가 사용하는 게시판의 좋아요 많은 게시글 조회
	@RequestMapping(value = "/board/goodlist", method = RequestMethod.GET) 
	public String goodBoard(Model model, int page_num){
		List<Manage_ItemCategoryDTO> category = categoryService.selectNav();
		model.addAttribute("navList", category);
		model.addAttribute("board_id", 1);
		model.addAttribute("good", "good");
		List<BoardDTO> datas = BoardService.getGoodBoard(page_num);
		model.addAttribute("datas", datas);

		return "user/community/list"; //servlet의 viewResolver가 가져감 ->"/WEB-INF/views/jinitest" + board + .jsp
	} 
	
	
}
