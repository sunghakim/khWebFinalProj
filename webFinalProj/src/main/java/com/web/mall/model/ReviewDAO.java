package com.web.mall.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO {
	@Autowired
	SqlSession session;
	
	public List<ReviewVO> getReviewList(ReviewVO vo) {
		return session.selectList("ReviewMapper.selectReviewList", vo);
	}
	public ReviewVO getReview(ReviewVO vo) {
		return session.selectOne("ReviewMapper.selectReview", vo);
	}
	public int selectIsAlreadyBuyItem(SoldHistoryVO shistoryVo, SoldDetailVO sdetailVo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", shistoryVo.getAccount_id());
		map.put("item_id", sdetailVo.getItem_id()+"");
		return session.selectOne("ReviewMapper.selectIsAlreadyBuy", map);
	}
	public int insertReview(ReviewVO vo) {
		return session.insert("ReviewMapper.insertReview", vo);
	}
	public int updateReview(ReviewVO vo) {
		return session.update("ReviewMapper.updateReview", vo);
	}
	public int deleteReview(ReviewVO vo) {
		return session.delete("ReviewMapper.deleteReview", vo);
	}
}
