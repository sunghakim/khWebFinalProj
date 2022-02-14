package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ZzimDAO {
	@Autowired
	private SqlSession sess;
	
	public List<ZzimListVO> selectZzimList(ZzimListVO vo) {
		return this.sess.selectList("ZzimMapper.selectZzimList", vo);
	}
	public int deleteZzimItem(ZzimListVO vo) {
		return this.sess.delete("ZzimMapper.deleteZzimItem", vo);
	}
	public ZzimListVO selectZzim(ZzimListVO vo) {
		return this.sess.selectOne("ZzimMapper.selectZzim", vo);
	}
	public void insertZzim(ZzimListVO vo) {
		this.sess.insert("ZzimMapper.insertZzim", vo);
	}
}
