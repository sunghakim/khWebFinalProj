package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_QuestionDTO;
import com.web.model.Manage_QuestionService;
import com.web.model.View;

@Controller
public class Manage_QuestionController {
	
	@Autowired
	Manage_QuestionService Service;

	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Question";
	
	//문의 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectQuestionList(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getQuestionInfo(mv, Service, -1);
		}
		return mv;
	}
	
	//문의 관리 상세 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectQuestion(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getQuestionInfo(mv, Service, ID);
		}
		return mv;
	}
	
	//문의 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateQuestion(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL + "/Update") == 0) {
			view.getQuestionInfo(mv, Service, ID);
		}
		return mv;
	}
		
	//문의DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateQuestion(HttpSession session, ModelAndView mv, Manage_QuestionDTO DTO) {
		if (view.isManager(mv, session, URL) == 0) {
			boolean result = Service.update(DTO);
			view.setQuestionResult(mv, Service, result);
		}
		return mv;
	}
}
