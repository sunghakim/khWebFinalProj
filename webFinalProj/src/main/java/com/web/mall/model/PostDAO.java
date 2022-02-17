package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO {
	@Autowired
	SqlSession sqlSession;
	
	//선택한 게시글 가져오기
	public PostDTO selectPost(int post_id) {
		PostDTO datas = sqlSession.selectOne("PostMapper.selectPost", post_id);
		return datas;
	}
	
	//게시판의 게시글 추가하기
	public int insertPost(PostDTO data) {
		return sqlSession.insert("PostMapper.insertPost", data);
	}
	//게시글 이미지 추가하기
	public int insertImage(PostDTO data) {
		return sqlSession.insert("PostMapper.insertImage", data);
	}
	//게시글 수정하기
	public int updatePost(PostDTO data) {
		return sqlSession.update("PostMapper.updatePost", data);
	}
	//게시글 수정하기
	public int updateImage(PostDTO data) {
			return sqlSession.update("PostMapper.updateImage", data);
	}
	
	//게시글 삭제하기
	public int deletePost(int post_id) {
		return sqlSession.delete("PostMapper.deletePost", post_id);
	}

	//게시글 삭제하기
	public int deleteCommentsList(int post_id) {
		return sqlSession.delete("PostMapper.deleteCommentsList", post_id);
	}
	//게시글 삭제하기
	public int deleteGood(int post_id) {
		return sqlSession.delete("PostMapper.deleteGood", post_id);
	}
	//게시글 삭제하기
	public int deleteReport(int post_id) {
		return sqlSession.delete("PostMapper.deleteReport", post_id);
	}
	//게시글 삭제하기
	public int deleteImage(int post_id) {
		return sqlSession.delete("PostMapper.deleteImage", post_id);
	}
	
	//게시글 좋아요
	public int updatePostGood(int post_id) {
		return sqlSession.update("PostMapper.addPostGood", post_id);
	}

	//게시글 안좋아요
	public int updatePostDislike(int post_id) {
		return sqlSession.update("PostMapper.addPostDislike", post_id);
	}

	//댓글 조회
	public List<CommentsDTO> selectComments(int post_id) {
		List<CommentsDTO> datas = sqlSession.selectList("PostMapper.selectComments", post_id);
		return datas;
	}
	
	//댓글 하나만 수정전에 조회
	public CommentsDTO selectCommentsDetail(int comment_id) {
		CommentsDTO datas = sqlSession.selectOne("PostMapper.selectCommentsDetail", comment_id);
		return datas;
	}
	
	//댓글 추가하기
	public int insertComments(CommentsDTO data) {
		return sqlSession.insert("PostMapper.insertComments", data);
	}
	
	//댓글 수정하기
	public int updateComments(CommentsDTO data) {
		return sqlSession.update("PostMapper.updateComments", data);
	}

	//댓글 삭제하기
	public int deleteComments(int comment_id) {
		return sqlSession.update("PostMapper.deleteComments", comment_id);
	}

	//신고 하기
	public int insertReport(ReportVO data) {
		return sqlSession.insert("PostMapper.insertReport", data);
	}
	//추가할 게시글 post_id가져오기 
	public int selectPost_id(PostDTO data) {
		return sqlSession.selectOne("PostMapper.selectPost_id");
		
	}
}
