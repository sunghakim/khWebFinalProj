package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	@Autowired
	private ReviewDAO dao;
	
	public List<ReviewVO> getReviews(ReviewVO vo) {
		return dao.getReviewList(vo);
	}
	public ReviewVO getReview(ReviewVO vo) {
		return dao.getReview(vo);
	}
	public boolean checkAlreadyBuy(SoldHistoryVO shistoryVo, SoldDetailVO sdetailVo) {
		if(dao.selectIsAlreadyBuyItem(shistoryVo, sdetailVo) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean addReview(ReviewVO vo) {
		if(dao.insertReview(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean updateReview(ReviewVO vo) {
		if(dao.updateReview(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean deleteReview(ReviewVO vo) {
		if(dao.deleteReview(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
