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
	private SqlSession sess;
	
	public List<ReviewVO> getReviewList(ReviewVO vo) {
		return this.sess.selectList("ReviewMapper.selectReviewList", vo);
	}
	public ReviewVO getReview(ReviewVO vo) {
		return this.sess.selectOne("ReviewMapper.selectReview", vo);
	}
	public int selectIsAlreadyBuyItem(SoldHistoryVO shistoryVo, SoldDetailVO sdetailVo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", shistoryVo.getAccount_id());
		map.put("item_id", sdetailVo.getItem_id()+"");
		return this.sess.selectOne("ReviewMapper.selectIsAlreadyBuy", map);
	}
	public int insertReview(ReviewVO vo) {
		return this.sess.insert("ReviewMapper.insertReview", vo);
	}
	public int updateReview(ReviewVO vo) {
		return this.sess.update("ReviewMapper.updateReview", vo);
	}
	public int deleteReview(ReviewVO vo) {
		return this.sess.delete("ReviewMapper.deleteReview", vo);
	}
	public List<ReviewVO> selectOneReviewGetId(ReviewVO vo) {
		return this.sess.selectList("ReviewMapper.selectOneReviewGetId", vo);
	}
}
