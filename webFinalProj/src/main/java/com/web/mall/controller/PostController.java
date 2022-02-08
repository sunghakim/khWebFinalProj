package com.web.mall.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.web.mall.model.*;

@Controller
@RequestMapping(value="/")
public class PostController {

	@Autowired
	private PostService PostService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "home";
	}
	
	//root-context.xml에 등록한 값 주입
	@Resource(name="UploadPath")
	String UploadPath;
	
	
	//게시글 페이지 접근 요청시 처리
	@RequestMapping(value = "/Post/viewPost", method = RequestMethod.GET)
	public ModelAndView viewPost(int PostID, ModelAndView mv) {
		PostVO PostVO = PostService.selectPost(PostID);
		mv.addObject("viewPostVO", PostVO);
		mv.setViewName("Post/viewPost");//jsp쪽에서 이미 PostID를 넘겨서 표현해주었기 때문에 mv로 또 파라미터를 넘길경우 에러 발생
		return mv;
	}
		
	//게시글 수정 페이지 접근 요청
	@RequestMapping(value = "/Post/updatePost", method = RequestMethod.GET)
	public ModelAndView updatePost(HttpSession session, int PostID, ModelAndView mv) {
		AccountVO AccountVO;
		PostVO PostVO = PostService.selectPost(PostID);
		if (session.getAttribute("AccountVO") != null) {
			AccountVO = (AccountVO)session.getAttribute("AccountVO");
			if (AccountVO.getAccount_id().equals(PostVO.getWriter_id())) {
				//작성자와 로그인계정일치
				mv.addObject("viewPostVO", PostVO);
				mv.addObject("status", "update");
				mv.setViewName("/Post/Posting");
			} else {
				//작성자와 로그인계정 불일치
				mv.addObject("viewPostVO", PostVO);
				mv.setViewName("redirect:/Post/viewPost" + "?PostID=" + PostID);
			}
		} else {
			//미로그인
			mv.addObject("NextPage", "/Posting");
			mv.setViewName("redirect:/Account/Login?NextURL=/Post/viewPost" + "?PostID=" + PostID);
		}
		return mv;
	}
		
	//게시글 수청 요청
	@RequestMapping(value = "/Post/updatePost", method = RequestMethod.POST)
	public String updatePost(HttpSession session, PostVO PostingVO, ModelAndView mv) {
		PostService.updatePost(PostingVO);
		return "redirect:/Post/viewPost" + "?PostID=" + PostingVO.getPost_id();
	}
		
	//게시글 삭제 요청
	@RequestMapping(value = "/Post/deletePost", method = RequestMethod.GET)
	public ModelAndView DeletePost(HttpSession session, int PostID, ModelAndView mv) {
		AccountVO AccountVO;
		PostVO viewPostVO = PostService.selectPost(PostID);
		if (session.getAttribute("AccountVO") != null) {
			AccountVO = (AccountVO)session.getAttribute("AccountVO");
			if (AccountVO.getAccount_id().equals(""+viewPostVO.getWriter_id())) {
				PostService.deletePost(PostID);
				mv.setViewName("redirect:/Board");
			} else {
				mv.addObject("viewPostVO", viewPostVO);
				mv.setViewName("redirect:/Post/viewPost" + "?PostID=" + PostID);
			}
		} else {
			mv.addObject("NextPage", "/viewPost");
			mv.setViewName("redirect:/Account/Login?NextURL=/Post/viewPost" + "?PostID=" + PostID);
		}
		return mv;
	}
		
	//게시글 좋아요 요청
	@RequestMapping(value="/Post/GoodPost", method = RequestMethod.GET)
	public ModelAndView Favorite(ModelAndView mv, int PostID) {
		if (PostService.addGoodPost(PostID)) {
			mv.setViewName("redirect:/Post/viewPost" + "?PostID=" + PostID);
		}
		return mv;
	}
	
}
