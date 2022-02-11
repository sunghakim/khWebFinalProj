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
import com.web.mall.model.Manage_NoticeDTO;
import com.web.mall.model.Manage_NoticeService;

@Controller
public class Manege_NoticeController extends Manage_C_Module {
	
	@Autowired
	Manage_NoticeService Service;
	
	@Resource(name="uploadPath")
    String uploadPath;

	//페이지 링크
	private final String URL = "/Manager_test/Notice";
	
	//공지 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectNoticeList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);
			
			int Page = setPage(mv, request);
			List<Manage_NoticeDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
			
			mv.addObject("Page", Page);
			mv.addObject("pageType", URL);
		}
		return mv;
	}
	
	//공지 상세 페이지 접속
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectNoticeOne(HttpSession session, ModelAndView mv, int PostID) {
		if (isManager(mv, session, URL + "Detail") == 0) {
			mv.addObject("Notice", Service.selectOne(PostID));
		}
		mv.addObject("status", "insert");
		mv.addObject("pageType", URL);
		return mv;
	}
	
	//공지 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertNotice(HttpSession session, ModelAndView mv) {
		isManager(mv, session, URL + "Insert");

		mv.addObject("status", "insert");
		mv.addObject("pageType", URL);
		return mv;
	}
	
	//공지DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertNotice(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_NoticeDTO DTO, @RequestParam("uploadImages") MultipartFile[] file) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			Manage_AccountDTO temp = (Manage_AccountDTO)session.getAttribute("account");
			DTO.setWriterID(temp.getAccountID());
			setResult(mv, Service.insert(DTO, request, file, uploadPath));
		}
		return mv;
	}
	
	//공지 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateNotice(HttpSession session, ModelAndView mv, int PostID) {
		if (isManager(mv, session, URL + "Insert") == 0) {
			mv.addObject("Notice", Service.selectOne(PostID));
			mv.addObject("ImageList", Service.selectImageList(PostID));
		}
		mv.addObject("status", "update");
		mv.addObject("pageType", URL);
		return mv;
	}
		
	//공지DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateNotice(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_NoticeDTO DTO) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			Manage_AccountDTO temp = (Manage_AccountDTO)session.getAttribute("account");
			DTO.setWriterID(temp.getAccountID());
			setResult(mv, Service.update(DTO));
			selectNoticeList(session, mv, request);
		}
		return mv;
	}

	//공지DB에 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteNotice(HttpSession session, ModelAndView mv, HttpServletRequest request, int PostID) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.delete(PostID));
			selectNoticeList(session, mv, request);
		}
		return mv;
	}
}