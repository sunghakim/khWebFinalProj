package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyinfoDAO {
	@Autowired
	private SqlSession sess;
	
	public List<ShoppingListVO> selectShoppingList(ShoppingListVO vo) {
		System.out.println(vo);
		return this.sess.selectList("MyinfoMapper.selectShoppingList", vo);
	}
	public ShoppingListVO selectShoppingListItem(ShoppingListVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectShoppingListItem", vo);
	}
	public ItemVO selectItem(ItemVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectItem", vo);
	}
	public ItemOptionVO selectItemOption(ItemOptionVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectItemOption", vo);
	}
	public int deleteShoppingList(ShoppingListVO vo) {
		return this.sess.delete("MyinfoMapper.deleteShoppingList", vo);
	}
	public int updateShoppingList(ShoppingListVO vo) {
		System.out.println(vo);
		return this.sess.update("MyinfoMapper.updateShoppingList", vo);
	}
	public List<ZzimListVO> selectZzimList(ZzimListVO vo) {
		return this.sess.selectList("MyinfoMapper.selectZzimList", vo);
	}
	public int deleteZzimItem(ZzimListVO vo) {
		return this.sess.delete("MyinfoMapper.deleteZzimItem", vo);
	}
	public List<GiveCouponVO> selectGivenCouponList(GiveCouponVO vo) {
		return this.sess.selectList("MyinfoMapper.selectGiveCouponList", vo);
	}
	public CouponVO selectCouponInfo(CouponVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectCouponInfo", vo);
	}
	public List<QuestionVO> selectQuestionList(QuestionVO vo) {
		return this.sess.selectList("MyinfoMapper.selectQuestions", vo);
	}
	public List<ReportVO> selectReportedUsers(ReportVO vo) {
		return this.sess.selectList("MyinfoMapper.selectReports", vo);
	}
	public List<ReportReasonVO> selectReportReason() {
		return this.sess.selectList("MyinfoMapper.selectReportReason");
	}
	public int insertQuestion(QuestionVO vo) {
		return this.sess.insert("MyinfoMapper.insertQuestion", vo);
	}
	public QuestionVO getOneQuestion(QuestionVO vo) {
		return this.sess.selectOne("MyinfoMapper.selectOneQuestion", vo);
	}
	public int updateQuestion(QuestionVO vo) {
		return this.sess.update("MyinfoMapper.updateQuestion", vo);
	}
	public int deleteQuestion(QuestionVO vo) {
		return this.sess.delete("MyinfoMapper.deleteQuestion", vo);
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
