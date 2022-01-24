package com.web.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_ReportDTO;
import com.web.model.Manage_ReportService;
import com.web.view.View;

@Controller
public class Manage_ReportController {
	
	@Autowired
	Manage_ReportService Service;
	
	//뷰 구성 모듈(관리자 권한체크, DB조회 결과로 페이지 구성)
	View view = new View();
	
	//페이지 링크
	private final String URL = "/Manager/Report";
	
	//신고 관리 페이지 접근	
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectReport(HttpSession session, ModelAndView mv) {
		if (view.isManager(mv, session, URL) == 0) {
			view.getReportInfo(mv, Service, -1);
		}
		return mv;
	}
	
	//신고내역 상세 조회 (◆이미지 가져와서 보여주는 방법 구현할것)
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectReport(HttpSession session, ModelAndView mv, int ID) {
		if (view.isManager(mv, session, URL + "Detail") == 0) {
			view.getReportInfo(mv, Service, ID);
		}
		return mv;
	}
	
	//신고내역DB에 활동 제한/영구 탈퇴 처리/사유 불충분 처리
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateReport(HttpSession session, ModelAndView mv, Manage_ReportDTO DTO, int Action) {
		if (view.isManager(mv, session, URL) == 0) {
			if (Service.insert(DTO)) {}//PunishDB에 내용추가
			DTO.setResult(Action);
			DTO.setClosedDate(new Date());
			boolean result = Service.update(DTO);
			view.setReportResult(mv, Service, result);
		}
		return mv;
	}
	
	
}
