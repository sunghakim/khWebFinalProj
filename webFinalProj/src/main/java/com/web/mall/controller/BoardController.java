package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mall.model.*;


@Controller
@RequestMapping(value="/")
public class BoardController {

	@Autowired
	private BoardService BoardService;
	
	@Autowired 
	private BoardVO BoardVO;
	
	@Autowired
	private PostService PostService;
	
	//게시판 페이지 접근 요청시 처리
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String board(String BoardID, HttpServletRequest request) {
		
		BoardVO vo = BoardService.getBoard(BoardID);
		request.setAttribute("Board", vo);
		
		List<PostVO> PostList = PostService.selectPostList(BoardID);
		request.setAttribute("PostList", PostList);
		return "Board/Board";
	}
	
	
}
