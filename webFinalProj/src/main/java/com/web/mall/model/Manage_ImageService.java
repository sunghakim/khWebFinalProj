package com.web.mall.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Manage_ImageService extends Manage_S_Module {
	
	@Autowired
	Manage_ImageDAO dao;
	
	public List<Manage_ImageDTO> selectList(int ReferencesID, String IDType) {
		//가져올 이미지의 정보 구성 후 가져옴
		Manage_ImageDTO dto = new Manage_ImageDTO();
		dto.setReferencesID(ReferencesID);
		dto.setIDType(IDType);
		return dao.selectList(dto);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insertList(List<Manage_ImageDTO> List) throws Exception{
		//저장된 이미지 갯수와 저장해야할 이미지 갯수가 틀리면 롤백
		if (dao.insertList(List) != List.size()) {
			throw new Exception("이미지 추가 처리중 문제발생");
		}
		return true;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int deleteOne(int ImageID) throws Exception{
		//삭제 전 DB에서 실제 등록된 이미 갯수와 삭제 갯수가 틀리면 롤백
		//공지글 수정시 이미지 삭제시 사용
		int res = dao.deleteOne(ImageID);
		if (res == 1) {
			return res;
		} else {
			throw new Exception("이미지 삭제 처리중 문제발생");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean deleteList(Manage_ImageDTO dto) throws Exception{
		//삭제 전 DB에서 실제 등록된 이미 갯수와 삭제 갯수가 틀리면 롤백
		//공지글 삭제시 이미지 전체삭제에 사용
		if (dao.selectReferencesIDCount(dto) == dao.deleteList(dto)) {
			return true;
		} else {
			throw new Exception("이미지 삭제 처리중 문제발생");
		}
	}
}
