package com.web.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_QuestionDTO;
import com.web.mall.model.Manage_QuestionService;

@Controller
public class Manage_QuestionController extends Manage_C_Module {
	
	@Autowired
	Manage_QuestionService Service;
	
	//페이지 링크
	private final String URL = "/Manager_test/Question";
	
	//문의 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectQuestionList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);

			int Page = setPage(mv, request);
			List<Manage_QuestionDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//문의 상세 페이지 접속
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectQuestion(HttpSession session, ModelAndView mv, int QuestionID) {
		if (isManager(mv, session, URL, "Detail") == 0) {
			mv.addObject("Question", Service.selectOne(QuestionID));
		}
		return mv;
	}
		
	//문의DB에 답변등록 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateQuestion(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_QuestionDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			DTO.setResult(1);
			setResult(mv, Service.update(DTO));
			selectQuestionList(session, mv, request);
		}
		return mv;
	}
}
