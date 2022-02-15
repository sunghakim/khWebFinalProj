package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDAO {
	@Autowired
	private SqlSession sess;
	
	public List<QuestionVO> selectItemQuestionList(QuestionVO vo) {
		return this.sess.selectList("QuestionMapper.selectItemQuestionList", vo);
	}
	public int insertQuestion(QuestionVO vo) {
		return this.sess.insert("QuestionMapper.insertQuestion", vo);
	}
	public List<QuestionVO> selectWriterQuestionListInMypage(QuestionVO vo) {
		return this.sess.selectList("QuestionMapper.selectWriterQuestionListInMypage", vo);
	}
	public List<QuestionVO> selectWriterQuestionListInItem(QuestionVO vo) {
		return this.sess.selectList("QuestionMapper.selectWriterQuestionListInItem", vo);
	}
	public QuestionVO getOneQuestion(QuestionVO vo) {
		return this.sess.selectOne("QuestionMapper.selectOneQuestion", vo);
	}
	public int updateQuestion(QuestionVO vo) {
		return this.sess.update("QuestionMapper.updateQuestion", vo);
	}
	public int deleteQuestion(QuestionVO vo) {
		return this.sess.delete("QuestionMapper.deleteQuestion", vo);
	}
	public List<QuestionVO> selectOneQuestionGetId(QuestionVO vo) {
		return this.sess.selectList("QuestionMapper.selectOneQuestionGetId", vo);
	}
}
