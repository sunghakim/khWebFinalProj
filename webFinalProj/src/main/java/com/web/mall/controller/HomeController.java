package com.web.mall.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.mall.model.Manage_ImageDTO;

@Controller
public class HomeController extends Manage_C_Module {
	
	@Resource(name="uploadPath")
	String uploadPath;

	//메인페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home() {
		return "Home";
	}
	
	//파일 업로드
	@RequestMapping(value = "/Upload.do", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ModelAndView upload(ModelAndView mv, HttpServletRequest request, @RequestParam("uploadFile")MultipartFile file) throws Exception {
		//dto 구성(해당 이미지파일의 모든 정보 구성)
		Manage_ImageDTO dto = BuildImageDTO(request, file, uploadPath);
		
		//DB에 이미지 파일 정보 저장 후 ImageID(pk)정보를 가져옴
		//ImageDTO res = ImageService.insert(dto);
		
		//파일저장, 디렉토리가 없으면 생성
		saveImage(dto);
		
		//[심각한 문제]파일이 여러개일 경우는 어떻게 해야하나? (Ajax사용)
		//[해결완료]DB에 업로드후 해당 ID키를 발급받아서 이미지DB에 넣어야한다. (ImageDB에 insert후 해당 값을 가져온다)
		//[해결완료]이름이 겹칠경우 어떻게 해야하나? (ImageID를 파일이름으로 저장한다.)
		
		//View 설정
		mv.addObject("dto", dto);
		mv.setViewName("Home");
		return mv;
	}
}
