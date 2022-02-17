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

import com.web.mall.model.AccountVO;
import com.web.mall.model.Manage_AccountDTO;
import com.web.mall.model.Manage_ImageDTO;
import com.web.mall.model.Manage_NoticeDTO;
import com.web.mall.model.Manage_NoticeService;

@Controller
public class Manege_NoticeController extends Manage_C_Module {
	//Manage_C_Module에 중복 로직을 작성
	
	@Autowired
	Manage_NoticeService Service;
	
	//root-context.xml에 등록한 파일 경로 가져옴
	@Resource(name="uploadPath")
    String uploadPath;

	//페이지 링크
	private final String URL = "/Manager/Notice";
	
	//공지 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectNoticeList(HttpSession session, ModelAndView mv, HttpServletRequest request) {

		//로그인여부, 관리자여부, mv에 경로를 넣어준다.(Manage_C_Module)
		if (isManager(mv, session, URL) == 0) {
			
			//페이징에서 최대로 이동 가능한 페이지수를 위한 int값을 파라미터로 넣어줌
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);
			
			//몇번째 페이지인지 체크하고 값을 넣어준다. (Manage_C_Module)
			int Page = setPage(mv, request);
			
			//공지 목록을 구성
			List<Manage_NoticeDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
			mv.addObject("Page", Page);
		}
		return mv;
	}
	
	//공지 상세 페이지 접속
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectNoticeOne(HttpSession session, ModelAndView mv, int PostID) {

		//로그인여부, 관리자여부, mv에 경로를 넣어준다.(Manage_C_Module)
		if (isManager(mv, session, URL, "Detail") == 0) {
			
			//해당 공지글 정보 불러오기
			mv.addObject("Notice", Service.selectOne(PostID));
			
			//해당 공지글에 등록된 이미지 목록 불러오기
			List<Manage_ImageDTO> ImageList = Service.selectImageList(PostID);
			if (ImageList.get(0) != null) {
				mv.addObject("Image", ImageList.get(0));
			}
		}
		return mv;
	}
	
	//공지 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertNotice(HttpSession session, ModelAndView mv) {

		//로그인여부, 관리자여부, mv에 경로를 넣어준다.(Manage_C_Module)
		isManager(mv, session, URL, "Detail");
		
		mv.addObject("status", "insert");
		return mv;
	}
	
	//공지DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertNotice(HttpSession session, ModelAndView mv, HttpServletRequest request
		, Manage_NoticeDTO DTO, @RequestParam("uploadImages") MultipartFile[] file) throws Exception {

		//로그인여부, 관리자여부, mv에 경로를 넣어준다.(Manage_C_Module)
		if (isManager(mv, session, URL) == 0) {
			AccountVO temp = (AccountVO)session.getAttribute("account");
			DTO.setWriterID(temp.getAccount_id());
			
			//요청 처리 결과를 파라미터 값으로 넣어준다.(Manage_C_Module)
			setResult(mv, Service.insert(DTO, request, file, uploadPath));
			
			//화면 구성을위해 컨트롤러의 메소드를 불러온다.
			selectNoticeList(session, mv, request);
		}
		return mv;
	}
	
	//공지 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateNotice(HttpSession session, ModelAndView mv, int PostID) {

		//로그인여부, 관리자여부, mv에 경로를 넣어준다.(Manage_C_Module)
		if (isManager(mv, session, URL, "Detail") == 0) {
			
			mv.addObject("Notice", Service.selectOne(PostID));
			List<Manage_ImageDTO> ImageList = Service.selectImageList(PostID);
			if (ImageList.get(0) != null) {
				mv.addObject("Image", ImageList.get(0));
			}
		}
		mv.addObject("status", "update");
		return mv;
	}
		
	//공지DB에 수정 요청(파일 수정 불가)
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateNotice(HttpSession session, ModelAndView mv, HttpServletRequest request
		, Manage_NoticeDTO DTO, int[] deleteImages, @RequestParam("uploadImages") MultipartFile[] file) throws Exception {

		//로그인여부, 관리자여부, mv에 경로를 넣어준다.(Manage_C_Module)
		if (isManager(mv, session, URL) == 0) {
			
			//공지 작성자 정보를 dto에 저장
			Manage_AccountDTO temp = (Manage_AccountDTO)session.getAttribute("account");
			DTO.setWriterID(temp.getAccountID());
			
			//요청 처리 결과를 파라미터 값으로 넣어준다.(Manage_C_Module)
			setResult(mv, Service.update(DTO, request, file, uploadPath, deleteImages));
			
			//화면 구성을위해 컨트롤러의 메소드를 불러온다.
			selectNoticeList(session, mv, request);
		}
		return mv;
	}

	//공지DB에 삭제 요청
	@RequestMapping(value = URL + "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteNotice(HttpSession session, ModelAndView mv, HttpServletRequest request, int PostID) throws Exception {
		
		//로그인여부, 관리자여부, mv에 경로를 넣어준다.(Manage_C_Module)
		if (isManager(mv, session, URL) == 0) {
			//요청 처리 결과를 파라미터 값으로 넣어준다.(Manage_C_Module)
			setResult(mv, Service.delete(PostID));
			
			//화면 구성을위해 컨트롤러의 메소드를 불러온다.
			selectNoticeList(session, mv, request);
		}
		return mv;
	}
}