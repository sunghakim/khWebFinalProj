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

import com.web.mall.model.Manage_ImageDTO;
import com.web.mall.model.Manage_ItemCategoryDTO;
import com.web.mall.model.Manage_ItemCategoryService;
import com.web.mall.model.Manage_ItemDTO;
import com.web.mall.model.Manage_ItemService;

@Controller
public class Manage_ItemController extends Manage_C_Module {

	@Autowired
	Manage_ItemService Service;
	
	//추가삭제기능이 아닌 조회용도로만 사용할 서비스(롤백이 필요없어서 컨트롤러에 선언)
	@Autowired
	Manage_ItemCategoryService ItemCategoryService;
	
	//root-context.xml에 등록한 파일 경로 가져옴
	@Resource(name="uploadPath")
    String uploadPath;
	
	//페이지 링크
	private final String URL = "/Manager/Item";
	
	//상품 관리 페이지 접속
	@RequestMapping(value = URL, method = RequestMethod.GET)
	public ModelAndView selectItemList(HttpSession session, ModelAndView mv, HttpServletRequest request) {
		if (isManager(mv, session, URL) == 0) {
			int TotalPageCount = Service.selectTotalPageCount();
			mv.addObject("TotalPageCount", TotalPageCount);
			
			int Page = setPage(mv, request);
			List<Manage_ItemDTO> List = Service.selectList(Page);
			mv.addObject("List", List);
			mv.addObject("Page", Page);
		}
		return mv;
	}
	
	//상품 상세 조회
	@RequestMapping(value = URL + "/Detail", method = RequestMethod.GET)
	public ModelAndView selectItem(HttpSession session, ModelAndView mv, HttpServletRequest request, Manage_ItemDTO DTO) {
		if (isManager(mv, session, URL, "Detail") == 0) {
			mv.addObject("Item", Service.selectOne(DTO));
			List<Manage_ImageDTO> ImageList = Service.selectImageList(DTO.getItemID());
			if (ImageList.get(0) != null) {
				mv.addObject("Image", ImageList.get(0));
			}
			mv.addObject("status", "detail");
		}
		return mv;
	}
	
	//상품 추가 페이지 접근
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.GET)
	public ModelAndView insertItem(HttpSession session, ModelAndView mv) {
		isManager(mv, session, URL, "Detail");
		
		List<Manage_ItemCategoryDTO> List = ItemCategoryService.selectAll();
		if (List.get(0) == null) {
			Manage_ItemCategoryDTO dto = new Manage_ItemCategoryDTO();
			dto.setItemCategoryID(0);
			dto.setItemCategoryName("카테고리 없음");
			dto.setNavShow('F');
			List.set(0, dto);
		}
		mv.addObject("ItemCategoryList", List);

		mv.addObject("status", "insert");
		return mv;
	}
	
	//상품DB에 추가 요청
	@RequestMapping(value = URL + "/Insert", method = RequestMethod.POST)
	public ModelAndView insertItem(HttpSession session, ModelAndView mv, HttpServletRequest request
			, Manage_ItemDTO dto, @RequestParam("uploadImages") MultipartFile file) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.insert(dto, request, file, uploadPath));
			selectItemList(session, mv, request);
		}
		return mv;
	}
	
	//상품 수정 페이지 접근
	@RequestMapping(value = URL + "/Update", method = RequestMethod.GET)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, Manage_ItemDTO DTO) {
		if (isManager(mv, session, URL, "Detail") == 0) {
			mv.addObject("Item", Service.selectOne(DTO));
		}
		
		List<Manage_ItemCategoryDTO> List = ItemCategoryService.selectAll();
		if (List.get(0) == null) {
			Manage_ItemCategoryDTO dto = new Manage_ItemCategoryDTO();
			dto.setItemCategoryID(0);
			dto.setItemCategoryName("카테고리 없음");
			dto.setNavShow('F');
			List.set(0, dto);
		}
		mv.addObject("ItemCategoryList", List);
		
		List<Manage_ImageDTO> ImageList = Service.selectImageList(DTO.getItemID());
		if (ImageList.get(0) != null) {
			mv.addObject("Image", ImageList.get(0));
		}
		mv.addObject("status", "update");
		return mv;
	}
	
	//상품DB에 수정 요청
	@RequestMapping(value = URL + "/Update", method = RequestMethod.POST)
	public ModelAndView updateItem(HttpSession session, ModelAndView mv, HttpServletRequest request
			, Manage_ItemDTO DTO, int[] deleteImages, @RequestParam("uploadImages") MultipartFile file) throws Exception {
		if (isManager(mv, session, URL) == 0) {
			setResult(mv, Service.update(DTO, request, file, uploadPath, deleteImages));
			selectItemList(session, mv, request);
		}
		return mv;
	}
}
