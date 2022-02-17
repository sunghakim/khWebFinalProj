package com.web.mall.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Manage_NoticeService extends Manage_S_Module {
	//Manage_S_Module에 중복 로직을 작성
	
	@Autowired
	private Manage_NoticeDAO dao;

	@Autowired
	private Manage_ImageService ImageService;
	
	//공지의 페이지 갯수 반환
	public int selectTotalPageCount() {
		//공지글 갯수를 페이지 갯수에 맞게 변환
		return PostCountToPageCount(dao.selectTotalCount());
	}
	
	public Manage_NoticeDTO selectOne(int PostID) {
		return dao.selectOne(PostID);
	}
	
	public List<Manage_NoticeDTO> selectList(int Page) {
		return dao.selectList(Page);
	}
	
	public List<Manage_ImageDTO> selectImageList(int PostID) {
		return ImageService.selectList(PostID, "NOTICE");
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insert(Manage_NoticeDTO dto, HttpServletRequest request, MultipartFile[] file
			, String uploadPath) throws Exception {
		if (dao.insert(dto) == 1) {
			//첨부파일이 있는지 확인
			if (file.length != 0) {
				int ReferencesID = dto.getPostID();
				
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
		}
		throw new Exception("공지사항 추가 처리중 문제발생");
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean update(Manage_NoticeDTO dto, HttpServletRequest request, MultipartFile[] file
			, String uploadPath, int[] deleteImages) throws Exception {
		if (dao.update(dto) == 1) {
			//이미지는 최대 1개만 업로드 가능하다
			//업로드된 이미지가 없으면 이미지수정을 하지 않는다.
			//업로드시 기존의 이미지는 삭제한다.
			
			//이미지 추가
			if (file[0] != null || file[0].getOriginalFilename() != "") {
				int ReferencesID = dto.getPostID();
				List<Manage_ImageDTO> ImageList = BuildImageDTOList(request, file, uploadPath, ReferencesID);
				if (ImageService.insertList(ImageList)) {
					saveImages(ImageList);
				} else {
					throw new Exception("공지 수정을 위한 이미지 추가 처리중 문제발생");
				}

				//이미지 삭제
				if (deleteImages != null) {
					for (int ImageID : deleteImages) {
						if (ImageService.deleteOne(ImageID) == 1) {
							return true;
						} else {
							throw new Exception("공지 수정을 위한 이미지 삭제 처리중 문제발생");
						}
					}
				}
			}

			return true;
		}
		throw new Exception("공지 수정 처리중 문제발생");
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(int PostID) throws Exception {
		//게시글 삭제
		if (dao.delete(PostID) == 1) {
			Manage_ImageDTO ImageDTO = new Manage_ImageDTO();
			ImageDTO.setReferencesID(PostID);
			ImageDTO.setIDType("NOTICE");
			//이미지 삭제
			if (ImageService.deleteList(ImageDTO)) {
				return true;
			}
			throw new Exception("이미지 삭제 처리중 문제발생");
		}
		throw new Exception("공지사항 삭제 처리중 문제발생");
	}
}
