package com.web.mall.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.web.mall.model.*;

@Controller
public class PostController {

	@Autowired
	private PostService service;
	
	
	//선택한 게시글 조회
	@RequestMapping(value="/post", method=RequestMethod.GET) 
	public String post(Model model, int post_id) {
		PostDTO datas = service.getPost(post_id);
		model.addAttribute("datas", datas);
		System.out.println(datas);
		//viewResolver가 가져감 ->/WEB-INF/views/ + post + .jsp
		return "user/community/detail";
	}
	
	//게시글 추가
	@RequestMapping(value="/post/add", method=RequestMethod.GET)
	public String postAdd(Model model){
		model.addAttribute("status", "add");
		return "user/community/write";// 진희님 경로 user/community/list
	}
	
	//게시글 추가 (제목, 내용, 이미지파일)
	@RequestMapping(value="/post/add", method=RequestMethod.POST)
	public String postAdd(String title, String content, MultipartFile fileUpload, HttpSession session) throws Exception{
		UUID id = UUID.randomUUID();
		
		AccountVO nowAcc = (AccountVO)session.getAttribute("AccountVO"); //account_id가져오기위해 세션값 가져옴 계정 로그인이 필요한 작업임
		
		
		
		String path = session.getServletContext().getRealPath("/resources/images"); //이미지 경로 지정 url
		
		File saveFile = new File(path, fileUpload.getOriginalFilename()); //파일 저장
		
		String ext = "." + fileUpload.getOriginalFilename().split("\\.")[1]; //확장자 
		
		
		while(saveFile.exists()) {	//파일 저장하는게 있으면 uuid로 저장.
			UUIDGenerator uuid = new UUIDGenerator();
			id = uuid.generateId(fileUpload.getOriginalFilename()); //파일 이름이고 확장자 전까지임. 
			saveFile = new File(path, id.toString() + ext );
		}
		
		fileUpload.transferTo(saveFile);
		
		boolean result = service.setPost(title, content, "ha1015", id.toString() + ext , "/resources/images"); //뒤에는 파일이름 파일url임
		

		if(result) {
		 	return "redirect:/board/list?board_id=1&page_num=1"; 
		 }
		return "user/community/write"; // 진희님 경로 user/community/list
	}
	
	//게시글 신고
	@RequestMapping(value="/post/report", method=RequestMethod.GET)
	public String reportPost(){
		return "user/community/detail";// 진희님 경로 
	}
		
	//게시글 신고 
	@RequestMapping(value="/post/report", method=RequestMethod.POST)
	public String reportPost(int post_id, int report_reason_id, HttpSession session){
		
		AccountVO nowAcc = (AccountVO)session.getAttribute("AccountVO"); //account_id가져오기위해 세션값 가져옴
	
		PostDTO datas = service.getPost(post_id);
		
		boolean result = service.setReport(report_reason_id, nowAcc.getAccount_id(),datas.getWriter_id(), post_id); 
		
		if(result) {
		 	return "redirect:/post?post_id=" + post_id;
		 }
		
		return "user/community/detail";
	}
	
	//게시글 수정전의 정보 불러오기
	@RequestMapping(value = "/post/update", method = RequestMethod.GET)
	public String updatePost(Model model, int post_id) {
		PostDTO datas = service.getPost(post_id);
		model.addAttribute("datas", datas);
		model.addAttribute("status", "update");
		return "user/community/write"; 
	}
	
	//게시글 수정 요청
	@RequestMapping(value = "/post/update", method = RequestMethod.POST)
	public String updatePost(int post_id, String title, String content, MultipartFile fileUpload, HttpSession session) throws Exception{
		UUID id = UUID.randomUUID();
		String path = session.getServletContext().getRealPath("/resources/images"); //이미지 경로 지정 url
		File saveFile = new File(path, fileUpload.getOriginalFilename()); //파일 저장
		String ext = "." + fileUpload.getOriginalFilename().split("\\.")[1]; //확장자 
		PostDTO datas = service.getPost(post_id);
	
		
		//파일 저장하는게 있으면 uuid로 저장.
		if(saveFile.exists()) {
			saveFile = new File(path, datas.getFile_name()); //새로운 파일 객체에 저장 원래 있던 이름으로
			fileUpload.transferTo(saveFile); //파일 업로드
			boolean result = service.updatePost(post_id, title, content, datas.getFile_name() , "/resources/images"); //뒤에는 파일이름 파일url임 
			//파일 이름 원래있던걸로 service실행
			if(result) {
				return "redirect:/post?post_id=" + post_id;
			}
		}
		
		while(saveFile.exists()) {
			UUIDGenerator uuid = new UUIDGenerator();
			id = uuid.generateId(fileUpload.getOriginalFilename()); //파일 이름이고 확장자 전까지임. 
			saveFile = new File(path, id.toString() + ext ); //파일객체에 새이름 저장
			fileUpload.transferTo(saveFile); //파일 업로드
			boolean res = service.updatePost(post_id, title, content, id.toString() + ext , "/resources/images"); //뒤에는 파일이름 파일url임 
			if(res) {
				return "redirect:/post?post_id=" + post_id;
			}
		}
		
		
		
		/*
		 *  1. 데이터베이서에 저장된 글 조회
		 *  2. 조회된 내용 중에 저장된 파일 정보 있는지 확인
		 *      2-1. 저장된 파일 없는 경우
		 *               새로운 UUID 로 저장
		 *      2-2. 저장된 파일 있는 경우
		 *               기존 파일 명으로 덮어쓰기
		 */
		
		
		
		return "user/community/write";//진희님 경로 "user/community/write"
	}
		
	//게시글 삭제 요청
	@RequestMapping(value = "/post/delete", method = RequestMethod.GET)
	public String deletePost(int post_id) {
		boolean result = service.deletePost(post_id);
		if(result) {
			return "redirect:/post/post_id=" + post_id;
		}
		return "user/community/list";
	}
		
	//게시글 좋아요 요청
	@RequestMapping(value="/post/good", method = RequestMethod.GET)
	public String goodPost(int post_id) {
		boolean result = service.addGoodPost(post_id);
		if(result) {
			return "redirect:/post";
		}
		return "user/community/detail";
	}
	
	//게시글 좋아요 두번 요청(좋아요 다시 누를때)
	@RequestMapping(value="/post/dislike", method = RequestMethod.GET)
	public String dislikePost(int post_id) {
		boolean result = service.addDislikePost(post_id);
		if(result) {
			return "redirect:/post";
		}
		return "user/community/detail";
	}
	
	//선택한 게시글의 댓글 조회
	@RequestMapping(value="/post/comments", method=RequestMethod.GET) 
	public String comments(Model model, int post_id) {
			List<CommentsDTO> datas = service.getComments(post_id);
			model.addAttribute("datas", datas);
			return "user/community/comment";
	}
	
	//댓글 추가 요청
	@RequestMapping(value="/post/comments/add", method=RequestMethod.GET)
	public String commentsAdd(){
		return "user/community/comment";
	}
	
	//댓글 추가 매개변수 넣기
	@RequestMapping(value="/post/comments/add", method=RequestMethod.POST)
	public String commentsAdd(String content, int comment_id, HttpSession session){
		AccountVO nowAcc = (AccountVO)session.getAttribute("AccountVO"); //현재 로그인한 계정 세션 가져오기
		
		 boolean result = service.setComments(content, nowAcc.getAccount_id(), comment_id);
		 if(result) {
		 	return "redirect:/comments";
		 }
		return "user/community/comment";
	}
	
	//댓글 수정전의 정보 불러오기
	@RequestMapping(value = "/post/comments/update", method = RequestMethod.GET)
	public String updateComments(Model model, int comment_id) {
		CommentsDTO datas = service.getCommentsDetail(comment_id);
		model.addAttribute("datas", datas);
		
		return "user/community/comment";
	}
	
	//댓글 수정 요청
	@RequestMapping(value = "/post/comments/update", method = RequestMethod.POST)
	public String updateComments(int comment_id, String content) {
		boolean result = service.updateComments(comment_id,content) ;
		if(result) {
			return "redirect:/comments/comment_id=" + comment_id;
		}
		return "user/community/comment";
	}
			
	//댓글 삭제 요청
	@RequestMapping(value = "/post/comments/delete", method = RequestMethod.GET)
	public String deleteComments(int comment_id) {
		boolean result = service.deleteComments(comment_id);
		if(result) {
			return "redirect:/comments/comment_id=" + comment_id;
		}
		return "user/community/comment";
	}
	
}
