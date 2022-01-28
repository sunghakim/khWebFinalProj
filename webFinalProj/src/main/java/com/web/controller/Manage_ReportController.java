package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_ReportDTO;
import com.web.model.Manage_ReportService;

@Controller
public class Manage_ReportController extends Manage_C_Module{
	
	@Autowired
	Manage_ReportService Service;
	
	//페이지 링크
	private final String URL = "/Manager/Report";
	
	//신고 관리 페이지 접근	
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectReportList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			//Request에 Page파라미터로 숫자를 입력하면 요청후 해당 페이지로 이동함
			mv.addObject("TotalPageCount", Service.selectTotalPageCount());
			List<Manage_ReportDTO> List = Service.selectList(setPage(mv, request));
			mv.addObject("List", List);
		}
		return mv;
	}
	
	//신고 상세 조회 (◆이미지 가져와서 보여주는 방법 구현할것)
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectReport(HttpSession session, ModelAndView mv, HttpServletRequest request, int ID) {
		if (isManager(mv, session, URL + "Detail") == 0) {
			mv.addObject("Report", Service.selectOne(ID));
		}
		return mv;
	}
	
	//신고내역DB에 활동 제한/영구 탈퇴 처리/사유 불충분 처리
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateReport(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ReportDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(DTO));
			selectReportList(session, mv, request);
		}
		return mv;
	}
}
