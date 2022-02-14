package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	@Autowired
	private QuestionDAO dao;
	@Autowired
	private Manage_ImageService imageService;
	
	public List<QuestionVO> getItemQuestions(QuestionVO vo) {
		return dao.selectItemQuestionList(vo);
	}
	public boolean addQuestion(QuestionVO vo) {
		if(dao.insertQuestion(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public List<QuestionVO> getWriterQuestions(QuestionVO vo) {
		return dao.selectWriterQuestionList(vo);
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
	public boolean deleteQuestion(QuestionVO vo, Manage_ImageDTO dto) throws Exception {
		if(imageService.deleteList(dto)) {
			if(dao.deleteQuestion(vo) == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
}
