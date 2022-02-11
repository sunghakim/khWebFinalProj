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
@RequestMapping(value="/")
public class PostController {

	@Autowired
	private PostService service;
	
	//root-context.xml에 등록한 값 주입
	@Resource(name="uploadPath")
	String uploadPath;
	
	//선택한 게시글 조회
	@RequestMapping(value="/post", method=RequestMethod.GET) 
	public String post(Model model, int post_id) {
		PostDTO datas = service.getPost(post_id);
		model.addAttribute("datas", datas);
		return "post";
	}
	
	//게시글 추가
	@RequestMapping(value="/post/add", method=RequestMethod.GET)
	public String postAdd(){
		return "postAdd";
	}
	
	//게시글 추가 매개변수 넣기
	@RequestMapping(value="/post/add", method=RequestMethod.POST)
	public String postAdd(String title, String content, MultipartFile fileUpload, HttpSession session) throws Exception{
		AccountVO nowAcc = (AccountVO)session.getAttribute("AccountVO"); //세션값 가져오기
		
		String path = session.getServletContext().getRealPath("/resources/images");
		System.out.println(path);
		
		File saveFile = new File(path, fileUpload.getOriginalFilename());
		
		while(saveFile.exists()) {
			UUIDGenerator uuid = new UUIDGenerator();
			UUID id = uuid.generateId(fileUpload.getOriginalFilename());
			saveFile = new File(path, id.toString() );
		}
		
		fileUpload.transferTo(saveFile);
		
		
		
		// boolean result = service.setPost(title, content, nowAcc.getAccount_id(), board_id);
		
		// if(result) {
		// 	return "redirect:/board";
		// }
		return "postAdd";
	}
	
	
	//게시글 수정전의 정보 불러오기
	@RequestMapping(value = "/post/update", method = RequestMethod.GET)
	public String updatePost(Model model, int post_id) {
		PostDTO datas = service.getPost(post_id);
		model.addAttribute("datas", datas);
		return "post/update";
	}
	
	//게시글 수정 요청
	@RequestMapping(value = "/post/update", method = RequestMethod.POST)
	public String updatePost(int post_id,String title, String content ) {
		boolean result = service.updatePost(title, content, post_id);
		if(result) {
			return "redirect:/post/post_id=" + post_id;
		}
		return "postUpdate";
	}
		
	//게시글 삭제 요청
	@RequestMapping(value = "/post/delete", method = RequestMethod.GET)
	public String deletePost(int post_id) {
		boolean result = service.deletePost(post_id);
		if(result) {
			return "redirect:/post/post_id=" + post_id;
		}
		return "postDelete";
	}
		
	//게시글 좋아요 요청
	@RequestMapping(value="/post/good", method = RequestMethod.GET)
	public String goodPost(int post_id) {
		boolean result = service.addGoodPost(post_id);
		if(result) {
			return "redirect:/post";
		}
		return "postGood";
	}
	//게시글 안좋아요 요청
	@RequestMapping(value="/post/dislike", method = RequestMethod.GET)
	public String dislikePost(int post_id) {
		boolean result = service.addDislikePost(post_id);
		if(result) {
			return "redirect:/post";
		}
		return "postDislike";
	}
	
	//선택한 게시글의 댓글 조회
	@RequestMapping(value="/comments", method=RequestMethod.GET) 
	public String comments(Model model, int post_id) {
			List<CommentsDTO> datas = service.getComments(post_id);
			model.addAttribute("datas", datas);
			return "comments";
	}
	
	//댓글 추가 요청
	@RequestMapping(value="/comments/add", method=RequestMethod.GET)
	public String commentsAdd(){
		return "commentsAdd";
	}
	
	//댓글 추가 매개변수 넣기
	@RequestMapping(value="/comments/add", method=RequestMethod.POST)
	public String commentsAdd(String content, int post_id, HttpSession session){
		AccountVO nowAcc = (AccountVO)session.getAttribute("AccountVO"); //세션값 가져오기
		
		// boolean result = service.setComments(content, nowAcc.getAccount_id(), post_id);
		// if(result) {
		// 	return "redirect:/comments";
		// }
		return "commentsAdd";
	}
	
	//여기서부터 아직 부족함
	//댓글 수정전의 정보 불러오기
	@RequestMapping(value = "/comments/update", method = RequestMethod.GET)
	public String updateComments(Model model, int comment_id) {
		CommentsDTO datas = service.getCommentsDetail(comment_id);
		model.addAttribute("datas", datas);
		return "redirect:/comments/comment_id="+comment_id;
	}
	
	//댓글 수정 요청
	@RequestMapping(value = "/comments/update", method = RequestMethod.POST)
	public String updateComments(int comment_id, String content) {
		boolean result = service.updateComments(comment_id,content) ;
		if(result) {
			return "redirect:/comments/comment_id=" + comment_id;
		}
		return "commentUpdate";
	}
			
	//댓글 삭제 요청
	@RequestMapping(value = "/comments/delete", method = RequestMethod.GET)
	public String deleteComments(int comment_id) {
		boolean result = service.deleteComments(comment_id);
		if(result) {
			return "redirect:/comments/comment_id=" + comment_id;
		}
		return "commentsDelete";
	}
	
}
