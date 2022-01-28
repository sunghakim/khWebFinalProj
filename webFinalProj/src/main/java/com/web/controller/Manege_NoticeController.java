package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_NoticeDTO;
import com.web.model.Manage_NoticeService;

@Controller
public class Manege_NoticeController extends Manage_C_Module {
	
	@Autowired
	Manage_NoticeService Service;

	//페이지 링크
	private final String URL = "/Manager/Notice";
	
	//공지 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectNoticeList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			//Request에 Page파라미터로 숫자를 입력하면 요청후 해당 페이지로 이동함
			mv.addObject("TotalPageCount", Service.selectTotalPageCount());
			List<Manage_NoticeDTO> List = Service.selectList(setPage(mv, request));
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//공지 상세관리 페이지 접속
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectNoticeOne(HttpSession session, ModelAndView mv, int ID) {
		if (isManager(mv, session, URL + "Detail") == 0) {
			mv.addObject("Notice", Service.selectOne(ID));
		}
		return mv;
	}
	
	//공지 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertNotice(HttpSession session, ModelAndView mv) {
		isManager(mv, session, URL + "Insert");
		return mv;
	}
	
	//공지DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertNotice(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_NoticeDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.insert(DTO));
			selectNoticeList(session, mv, request);
		}
		return mv;
	}
	
	//공지 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateNotice(HttpSession session, ModelAndView mv, int ID) {
		if (isManager(mv, session, URL + "Insert") == 0) {
			mv.addObject("Notice", Service.selectOne(ID));
		}
		return mv;
	}
		
	//공지DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateNotice(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_NoticeDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(DTO));
			selectNoticeList(session, mv, request);
		}
		return mv;
	}

	//공지DB에 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteNotice(HttpSession session, ModelAndView mv, HttpServletRequest request, int ID) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.delete(ID));
			selectNoticeList(session, mv, request);
		}
		return mv;
	}
}