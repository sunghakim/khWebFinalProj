package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_QuestionDTO;
import com.web.model.Manage_QuestionService;

@Controller
public class Manage_QuestionController extends Manage_C_Module {
	//상품문의, 마이페이지 문의 처리(마이페이지 문의는 item_id가 null)
	
	@Autowired
	Manage_QuestionService Service;
	
	//페이지 링크
	private final String URL = "/Manager/Question";
	
	//문의 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectQuestionList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			//Request에 Page파라미터로 숫자를 입력하면 요청후 해당 페이지로 이동함
			mv.addObject("TotalPageCount", Service.selectTotalPageCount());
			List<Manage_QuestionDTO> List = Service.selectList(setPage(mv, request));
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//문의 상세 페이지 접속
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectQuestion(HttpSession session, ModelAndView mv, int ID) {
		if (isManager(mv, session, URL + "Detail") == 0) {
			mv.addObject("Question", Service.selectOne(ID));
		}
		return mv;
	}
		
	//문의DB에 답변등록 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateQuestion(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_QuestionDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(DTO));
			selectQuestionList(session, mv, request);
		}
		return mv;
	}
}
