package com.web.mall.myinfo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.mall.account.model.AccountDAO;
import com.web.mall.account.model.AccountVO;

@Service
public class MyinfoService {
	@Autowired
	private MyinfoDAO dao;
	
	public List<ShoppingListVO> getCarts(ShoppingListVO vo) {
		System.out.println("장바구니 실행됨!");
		System.out.println(vo);
		
		return dao.selectShoppingList(vo);
	}
	public ItemVO getItem(ItemVO vo) {
		return dao.selectItem(vo);
	}
	
	public ItemOptionVO getItemOption(ItemOptionVO vo) {
		return dao.selectItemOption(vo);
	}
	public boolean deleteCartItem(ShoppingListVO vo) {
		if(dao.deleteShoppingList(vo) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean updateCartItem(ShoppingListVO vo) {
		if(dao.updateShoppingList(vo) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public List<ZzimListVO> getZzims(ZzimListVO vo) {
		return dao.selectZzimList(vo);
	}
	public boolean deleteZzimItem(ZzimListVO vo) {
		int res = dao.deleteZzimItem(vo);
		if(res == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public List<GiveCouponVO> getGivenCoupons(GiveCouponVO vo) {
		return dao.selectGivenCouponList(vo);
	}
	public CouponVO getCouponInfo(CouponVO vo) {
		return dao.selectCouponInfo(vo);
	}
	
	public List<QuestionVO> getQuestions(QuestionVO vo) {
		return dao.selectQuestionList(vo);
	}
	public List<ReportVO> getReportedUsers(ReportVO vo) {
		return dao.selectReportedUsers(vo);
	}
	public List<ReportReasonVO> getReportReason() {
		return dao.selectReportReason();
	}
	public boolean addQuestion(QuestionVO vo) {
		if(dao.insertQuestion(vo) == 0) {
			return false;
		}
		else {
			return true;
		}	
	}
	public QuestionVO getOneQuestion(QuestionVO vo) {
		return dao.getOneQuestion(vo);
	}
	public boolean updateQuestion(QuestionVO vo) {
		if(dao.updateQuestion(vo) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean deleteQuestion(QuestionVO vo) {
		if(dao.deleteQuestion(vo) == 0) {
			return false;
		}
		else {
			return true;
		}
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
