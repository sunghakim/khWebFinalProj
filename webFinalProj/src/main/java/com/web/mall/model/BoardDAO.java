package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	public List<BoardDTO> selectBoard(int board_id){ // 최신순으로 선택한 게시판 조회 가져옴
		List<BoardDTO> datas = sqlSession.selectList("BoardMapper.selectBoardList", board_id);
		return datas;
	}
	
	public List<BoardDTO> selectGoodBoard(int board_id){ // 좋아요 높은 선택한 게시판 조회 가져옴
		List<BoardDTO> datas = sqlSession.selectList("BoardMapper.selectGoodBoardList");
		return datas;
	}

}
