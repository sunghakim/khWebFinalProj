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
	public List<QuestionVO> selectWriterQuestionList(QuestionVO vo) {
		return this.sess.selectList("MyinfoMapper.selectWriterQuestionList", vo);
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
}
