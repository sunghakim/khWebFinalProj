package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

	@Autowired
	PostDAO dao;
	
	public PostVO selectPost(int PostID) {
		PostVO viewPostVO = dao.selectPost(PostID);
		dao.addPostView(PostID);
		return viewPostVO;
	}
	
	public List<PostVO> selectPostList(String boardID) {
		List<PostVO> PostList = dao.selectPostList(boardID);
		return PostList;
	}
	
	public PostVO insertPost(PostVO postingVO) {
		PostVO viewPostVO = dao.insertPost(postingVO);
		return viewPostVO;
	}

	public int updatePost(PostVO PostingVO) {
		return dao.updatePost(PostingVO);
		
	}
	
	public boolean deletePost(int PostID) {
		int result = dao.deletePost(PostID);
		return result == 1 ? true : false;
	}

	public boolean addGoodPost(int PostID) {
		int result = dao.updatePostFavorite(PostID);
		return result == 1 ? true : false;
	}

}
