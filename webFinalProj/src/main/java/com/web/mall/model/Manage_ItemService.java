package com.web.mall.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Manage_ItemService extends Manage_S_Module {
	
	@Autowired
	private Manage_ItemDAO dao;

	@Autowired
	private Manage_ImageService ImageService;
	
	public int selectTotalPageCount() {
		return PostCountToPageCount(dao.selectTotalCount());
	}

	public Manage_ItemDTO selectOne(Manage_ItemDTO DTO) {
		return dao.selectOne(DTO);
	}
	
	public List<Manage_ItemDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	public List<Manage_ImageDTO> selectImageList(int PostID) {
		return ImageService.selectList(PostID, "ITEM");
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insert(Manage_ItemDTO dto, HttpServletRequest request, MultipartFile[] file
			, String uploadPath) throws Exception {
		if (dao.searchItemID(dto) == null) {
			if (dao.insertItem(dto) == 1) {
				//첨부파일이 있는지 확인
				if (file[0].getOriginalFilename() != "") {
					int ReferencesID = dto.getItemID();
					
					//전달받은 정보로 DB에 저장할 DTO목록 생성
					List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
					
					//DB에 이미지 정보 저장
					if (ImageService.insertList(ImageList)) {
						
						//서버에 이미지 저장(이클립스 테스트환경이 아닌 실제 톰캣 경로에 저장된다.)
						saveImages(ImageList);
						return true;
					}
					throw new Exception("이미지 추가 처리중 문제발생");
				}
				return true;
			} else {
				throw new Exception("상품 추가 처리중 문제발생");
			}
		}
		if (dao.insertItemOption(dto) == 1) {
			return true;
		} else {
			throw new Exception("상품옵션 추가 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_ItemDTO dto, HttpServletRequest request, MultipartFile[] file
			, String uploadPath, int[] deleteImages) throws Exception{
		if (dao.updateItem(dto) == 1) {
			if (dao.updateItemOption(dto) != 1) {
				throw new Exception("상품옵션 수정 처리중 문제발생");
			}
			if (file[0].getOriginalFilename() != "") {
				int ReferencesID = dto.getItemID();
				List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
				if (ImageService.insertList(ImageList)) {
					saveImages(ImageList);
				} else {
					throw new Exception("상품 수정을 위한 이미지 추가 처리중 문제발생");
				}
			}
			if (deleteImages != null) {
				for (int ImageID : deleteImages) {
					if (ImageService.deleteOne(ImageID) == 1) {
						return true;
					} else {
						throw new Exception("상품 수정을 위한 이미지 삭제 처리중 문제발생");
					}
				}
			}
			return true;
		} else {
			throw new Exception("상품 수정 처리중 문제발생");
		}
	}
}
