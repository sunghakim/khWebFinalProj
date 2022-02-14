package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyinfoDAO {
	@Autowired
	private SqlSession sess;

	public List<GiveCouponVO> selectGivenCouponList(GiveCouponVO vo) {
		return this.sess.selectList("MyinfonMapper.selectGiveCouponList", vo);
	}
	public CouponVO selectCouponInfo(CouponVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectCouponInfo", vo);
	}
	public List<ReportVO> selectReportedUsers(ReportVO vo) {
		return this.sess.selectList("MyinfoMapper.selectReports", vo);
	}
	public List<ReportReasonVO> selectReportReason() {
		return this.sess.selectList("MyinfoMapper.selectReportReason");
	}
	
	public List<SoldHistoryVO> selectAllSoldHistory(SoldHistoryVO vo) {
		return this.sess.selectList("MyinfoMapper.selectAllSoldHistory", vo);
	}
	public SoldHistoryVO selectOneSoldHistory(SoldHistoryVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectOneSoldHistory", vo);
	}
	public List<SoldDetailVO> selectAllSoldDetail(SoldDetailVO vo) {
		return this.sess.selectList("MyinfoMapper.selectAllSoldDetail", vo);
	}
	public int updateRefund(SoldDetailVO vo) {
		return this.sess.update("MyinfoMapper.updateRefund", vo);
	}
	public SoldDetailVO selectOneSoldDetail(SoldDetailVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectOneSoldDetail", vo);
	}
}
