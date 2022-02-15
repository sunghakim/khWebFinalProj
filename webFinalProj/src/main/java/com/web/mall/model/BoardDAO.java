package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;
	public List<BoardDTO> selectMain(BoardDTO dto){ // 최신순으로 선택한 게시판 조회 가져옴
		List<BoardDTO> datas = sqlSession.selectList("BoardMapper.selectMainList", dto);
		return datas;
	}
	
	public List<BoardDTO> selectMainGood(BoardDTO dto){ // 좋아요 높은 선택한 게시판 조회 가져옴
		List<BoardDTO> datas = sqlSession.selectList("BoardMapper.selectMainGoodList", dto);
		return datas;
	}
	
	public List<BoardDTO> selectBoard(BoardDTO dto){ // 최신순으로 선택한 게시판 조회 가져옴
		List<BoardDTO> datas = sqlSession.selectList("BoardMapper.selectBoardList", dto);
		return datas;
	}
	
	public List<BoardDTO> selectGoodBoard(BoardDTO dto){ // 좋아요 높은 선택한 게시판 조회 가져옴
		List<BoardDTO> datas = sqlSession.selectList("BoardMapper.selectGoodBoardList", dto);
		return datas;
	}

}
