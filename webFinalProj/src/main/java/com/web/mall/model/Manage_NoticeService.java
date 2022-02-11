package com.web.mall.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Manage_NoticeService extends Manage_S_Module {
	
	@Autowired
	Manage_NoticeDAO dao;

	@Autowired
	Manage_ImageService ImageService;
	
	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}

	public Manage_NoticeDTO selectOne(int PostID) {
		return dao.selectOne(PostID);
	}
	
	public List<Manage_NoticeDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	public List<Manage_ImageDTO> selectImageList(int PostID) {
		return ImageService.selectList(PostID, "Notice");
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insert(Manage_NoticeDTO dto, HttpServletRequest request, MultipartFile[] file
			, String uploadPath) throws Exception {
		if (dao.insert(dto) == 1) {
			int ReferencesID = dto.getPostID();
			List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
			ImageService.insertList(ImageList);
			saveImages(ImageList);
			return true;
		} else {
			throw new Exception("공지사항 추가 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_NoticeDTO dto) throws Exception {
		if (dao.update(dto) == 1) {
			return true;
		} else {
			throw new Exception("공지사항 수정 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(int PostID) throws Exception {
		if (dao.delete(PostID) == 1) {
			return true;
		} else {
			throw new Exception("공지사항 삭제 처리중 문제발생");
		}
	}
}
