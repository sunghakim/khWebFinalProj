package com.web.mall.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_AccountDTO;
import com.web.mall.model.Manage_ImageDTO;

public class Manage_C_Module {
	//컨트롤러에서 중복되는 로직을 모듈화한다.
	
	//관리자인지, 로그인 했는지 확인, 접근할 페이지 대상 설정
	public int isManager(ModelAndView mv, HttpSession session, String Page) {
		Manage_AccountDTO AccountDTO;
		if (session.getAttribute("Account") != null) {
			//로그인된 경우
			AccountDTO = (Manage_AccountDTO)session.getAttribute("Account");
			if(AccountDTO.getUserType() == 0) {
				//로그인된 계정의 권한이 관리자인 경우
				mv.setViewName(Page);//접근할 페이지 설정
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
	
	//DB업로드용 이미지 정보(DTO)로 가공
	public Manage_ImageDTO BuildImageDTO(HttpServletRequest request, MultipartFile file) throws Exception {
		//DB저장용 정보 설정
		Manage_ImageDTO dto = new Manage_ImageDTO();
		dto.setReferencesID(Integer.parseInt(request.getParameter("ReferencesID")));
		dto.setIDType(request.getParameter("IDType"));
		dto.setFileName(file.getOriginalFilename());
		dto.setFileURL("/upload-img" + "/" + dto.getIDType());
		dto.setFile(file);
		return dto;
	}
	
	//이미지 저장
	public void saveImage(Manage_ImageDTO dto) throws Exception {
		//경로가 존재하지 않으면 생성
		if (!new File(dto.getFileURL()).exists()) {
            new File(dto.getFileURL()).mkdirs();
		}
		//파일저장
		File dest = new File(dto.getFullPath());//ImageID(PK)로 저장해야 충돌이 발생하지 않음, dto.getImageID()
		dto.getFile().transferTo(dest);
	}
}
