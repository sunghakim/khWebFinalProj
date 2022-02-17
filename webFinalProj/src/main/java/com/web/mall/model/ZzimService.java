package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZzimService {
	@Autowired
	private ZzimDAO dao;
	
	public List<ZzimListVO> getZzims(ZzimListVO vo) {
		return dao.selectZzimList(vo);
	}
	public boolean deleteZzimItem(ZzimListVO vo) {
		int res = dao.deleteZzimItem(vo);
		if(res == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public ZzimListVO getZzim(ZzimListVO vo) {
		return dao.selectZzim(vo);
	}
	public void addZzim(ZzimListVO vo) {
		dao.insertZzim(vo);
	}
	public int getZzimNumberForItem(ZzimListVO vo) {
		return dao.selectZzimNumberForItem(vo);
	}
}
