package com.web.mall.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_AccountDTO;
import com.web.mall.model.Manage_ImageDTO;
import com.web.mall.model.Manage_ImageService;

@Controller
public class HomeController extends Manage_C_Module {
	
	@Autowired
	Manage_ImageService ImageService;
	
	@Resource(name="uploadPath")
    String uploadPath;
	
	//메인페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Home(ModelAndView mv, HttpSession session) {
		Manage_AccountDTO dto = new Manage_AccountDTO();
		dto.setUserType(0);
		session.setAttribute("Account", dto);
		System.out.println("세션 발급 성공");
		mv.setViewName("Manager_test/Home");
		return mv;
	}
	
	//다중 파일 업로드 예시
	@RequestMapping(value = "/multiUpload.do", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ModelAndView multiUpload(ModelAndView mv, HttpServletRequest request, @RequestParam("uploadFiles") MultipartFile[] file) throws Exception {
		List<Manage_ImageDTO> List = BuildImageDTOList(request, file, uploadPath);
		ImageService.insertList(List);
		saveImages(List);
		
		//View 설정
		mv.addObject("List", List);
		mv.setViewName("Manager_test/Home");
		return mv;
	}
}
