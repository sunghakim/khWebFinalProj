package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO {
	@Autowired
	SqlSession session;
	
	public PostVO selectPost(int PostID) {
		return this.session.selectOne("PostMapper.GetPost", PostID);
	}
	
	public void addPostView(int PostID) {
		this.session.update("PostMapper.AddPostView", PostID);
	}
	
	public List<PostVO> selectPostList(String boardID) {
		return this.session.selectList("PostMapper.GetPostList", boardID);
	}
	
	public PostVO insertPost(PostVO PostingVO) {
		//마이바티스를 통해 insert 요청후 입력한 id 값을 돌려받음
		//돌려받은 id값으로 실제 입력된 게시글 조회
		this.session.insert("PostMapper.Posting", PostingVO);
		return this.selectPost(PostingVO.getPost_id());
	}
	
	public int updatePost(PostVO PostingVO) {
		return this.session.update("PostMapper.updatePost", PostingVO);
	}
	
	public int deletePost(int PostID) {
		PostVO viewPostVO = new PostVO();
		viewPostVO.setPost_id(PostID);
		return this.session.delete("PostMapper.deletePost", PostID);
	}

	public int updatePostFavorite(int PostID) {
		return this.session.update("PostMapper.addPostFavorite", PostID);
	}

	public int updatePostDislike(int PostID) {
		return this.session.update("PostMapper.addPostDislike", PostID);
	}
	
	
}
