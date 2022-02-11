package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

	@Autowired
	PostDAO dao;

	//선택한 게시글 조회
	public PostDTO getPost(int post_id) {
		return dao.selectPost(post_id);
	}

	// 게시글 추가하기위해 값 넣기
	public boolean setPost(String title, String content ,String writer_id, int board_id) {
		PostDTO data = new PostDTO();
		data.setTitle(title);
		data.setContent(content);
		data.setWriter_id(writer_id);
		data.setBoard_id(board_id);
		int result = dao.insertPost(data);
		if(result == 1) {
			return true;
		}
		return false;
	}
	

	//게시글 수정하기위해 값 수정
	public boolean updatePost(String title, String content, int post_id) {
		PostDTO data = new PostDTO();
		data.setTitle(title);
		data.setContent(content);
		data.setPost_id(post_id);
		int result = dao.updatePost(data);
		if(result == 1) {
			return true;
		}
		return false;
		
	}
	
	
	//게시글 삭제하기
	public boolean deletePost(int post_id) {
		int result = dao.deletePost(post_id);
		if(result == 1) {
			return true;
		}
		return false;
	}

	//게시글 좋아요
	public boolean addGoodPost(int post_id) {
		int result = dao.updatePostGood(post_id);
		if(result == 1) {
			return true;
		}
		return false;
	}

	//게시글 안좋아요
	public boolean addDislikePost(int post_id) {
		int result = dao.updatePostDislike(post_id);
		if(result == 1) {
			return true;
		}
		return false;
	}

	
	//댓글 조회
	public List<CommentsDTO> getComments(int post_id) {
		return dao.selectComments(post_id);
	}

	//댓글 하나만 조회
	public CommentsDTO getCommentsDetail(int comment_id) {
		return dao.selectComments(comment_id);
	}
	
	//댓글 추가
	public boolean setComments(int comment_id, String content) {
		CommentsDTO data = new CommentsDTO();
		data.setContent(content);
		data.setComment_id(comment_id);
		int result = dao.insertComments(data);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	//댓글 수정
	public boolean updateComments(int comment_id, String content) {
		CommentsDTO data = new CommentsDTO();
		data.setComment_id(comment_id);
		data.setContent(content);
		int result = dao.updateComments(data);
		if(result == 1) {
			return true;
		}
		return false;
			
	}

	//댓글 삭제
	public boolean deleteComments(int comment_id) {
		int result = dao.deleteComments(comment_id);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	

}