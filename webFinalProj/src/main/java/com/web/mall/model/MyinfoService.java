package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyinfoService {
	@Autowired
	private MyinfoDAO dao;

	public List<GiveCouponVO> getGivenCoupons(GiveCouponVO vo) {
		return dao.selectGivenCouponList(vo);
	}
	public CouponVO getCouponInfo(CouponVO vo) {
		return dao.selectCouponInfo(vo);
	}
	public List<ReportVO> getReportedUsers(ReportVO vo) {
		return dao.selectReportedUsers(vo);
	}
	public List<ReportReasonVO> getReportReason() {
		return dao.selectReportReason();
	}
	public List<SoldHistoryVO> getPayedDays(SoldHistoryVO vo) {
		return dao.selectAllSoldHistory(vo);
	}
	public SoldHistoryVO getOnePayedDay(SoldHistoryVO vo) {
		return dao.selectOneSoldHistory(vo);
	}
	public List<SoldDetailVO> getOnePayedDetails(SoldDetailVO vo) {
		return dao.selectAllSoldDetail(vo);
	}
	public boolean doRefund(SoldDetailVO vo) {
		if(dao.updateRefund(vo) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public SoldDetailVO getOnePayedDetail(SoldDetailVO vo) {
		return dao.selectOneSoldDetail(vo);
	}
	
}
