package com.web.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_AccountDTO;

public class Manage_C_Module {
	//컨트롤러에서 중복되는 로직을 모듈화한다.
	public int isManager(ModelAndView mv, HttpSession session, String URL) {
		return isManager(mv, session, URL, "");
	}
	
	//관리자인지, 로그인 했는지 확인, 접근할 페이지 대상 설정
	public int isManager(ModelAndView mv, HttpSession session, String URL, String optionURL) {
		Manage_AccountDTO AccountDTO;
		//중복되는 요청경로를 파라미터로 설정
		if (session.getAttribute("account") != null) {
			//로그인된 경우
			AccountDTO = (Manage_AccountDTO)session.getAttribute("account");
			if(AccountDTO.getUserType() == 0) {
				//로그인된 계정의 권한이 관리자인 경우
				mv.addObject("pageType", URL);
				mv.setViewName(URL + optionURL);//접근할 페이지 설정
				return 0;
			} else {
				//권한 부족, 접근 거부
				mv.addObject("res", "AccessDenied");
				mv.setViewName("redirect:/");
				return 1;
			}
		} else {
			//로그인 되지 않은 경우
			mv.setViewName("redirect:/Account/Login");
			return 2;
		}
	}
	
	//DB작업 결과에 따라 Parameter추가
	public void setResult(ModelAndView mv, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
	}
	
	//파라미터로 넘어온 페이지를 숫자로 변환 후 반환
	public int setPage(ModelAndView mv, HttpServletRequest request) {
		int Page;
		if (request.getParameter("Page") == null) {
			Page = 1;
		} else {
			String temp = request.getParameter("Page");
			Page = Integer.parseInt(temp);
		}
		mv.addObject("Page", Page);
		return Page;
	}
}
