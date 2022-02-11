package com.web.mall.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Manage_S_Module {
	//서비스에서 중복되는 로직을 모듈화한다.
	
	//전체게시글 갯수를 페이지수로 변환하여 반환
	public int PostCountToPageCount(int result) {
		if (result < 11) {
			return 1;
		} else {
			return (result/10)+1;
		}
	}
	
	//DB업로드용 이미지 정보(DTO)로 가공
	public List<Manage_ImageDTO> BuildImageDTOList(HttpServletRequest request, MultipartFile[] files
			, String uploadPath, int ReferencesID) throws Exception {
		//DB저장용 정보 설정
		List<Manage_ImageDTO> List = new ArrayList<Manage_ImageDTO>();
		for (MultipartFile file : files) {
			Manage_ImageDTO dto = new Manage_ImageDTO();
			dto.setReferencesID(ReferencesID);
			dto.setIDType(request.getParameter("IDType"));
			dto.setFileName(file.getOriginalFilename());
			dto.setFileURL(uploadPath + "/" + dto.getIDType());
			dto.setRealPath(request.getSession().getServletContext().getRealPath(uploadPath + "/"));
			dto.setFile(file);
			List.add(dto);
			System.out.println("다중 업로드 dto생성: " + dto.toString());
		}
		return List;
	}
	
	//이미지 저장
	public void saveImages(List<Manage_ImageDTO> List) throws Exception {
		for (Manage_ImageDTO dto : List) {
			if(dto.getFile() == null) {
				System.out.println("파일이 없습니다.");
				System.out.println("saveImages: " + dto.toString());
				break;
			}
			
			//경로가 없을 경우 생성
			if (!new File(dto.getRealSavedPath()).exists()) {
	            new File(dto.getRealSavedPath()).mkdirs();
	            System.out.println("다중 경로 생성: " + dto.getRealPath());
			}
			//파일저장
			File dest = new File(dto.getRealSavedFile());
			dto.getFile().transferTo(dest);
			System.out.println("다중 파일 저장: " + dest.getAbsoluteFile());
		}
	}
}
