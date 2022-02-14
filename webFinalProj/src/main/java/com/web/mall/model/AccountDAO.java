package com.web.mall.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sess;
	
	public AccountVO selectLoginAccount(AccountVO vo) {
		return this.sess.selectOne("AccountMapper.selectLoginAccount", vo);
	}
	public SocialAccountVO selectLoginAccount(SocialAccountVO vo) {
		return this.sess.selectOne("AccountMapper.selectLoginSocialAccount", vo);
	}
	
	public List<AccountVO> selectAccounts() {
		List<AccountVO> data = this.sess.selectList("AccountMapper.selectListAccount");
		
		return data;
	}
	
	public int insertWebUserAccount(AccountVO vo) {
		return this.sess.insert("AccountMapper.insertWebUserAccount", vo);
	}
	public int insertSocialUserAccount(SocialAccountVO vo) {
		System.out.println(vo);
		return this.sess.insert("AccountMapper.insertSocialUserAccount", vo);
	}
	
	public int deleteAccount(AccountVO vo) {
		return this.sess.delete("AccountMapper.deleteAccount", vo);
	}
	
	public AccountVO selectSameAccount(AccountVO vo) {
		return this.sess.selectOne("AccountMapper.selectSameAccount", vo);
	}
	public SocialAccountVO selectSameAccount(SocialAccountVO vo) {
		return this.sess.selectOne("AccountMapper.selectSameSocialAccount", vo);
	}
	
	public int updateAccountInfo(AccountVO vo) {
		return this.sess.update("AccountMapper.updateAccountInfo", vo);
	}
	public int updateAccountInfo(SocialAccountVO vo) {
		return this.sess.update("AccountMapper.updateSocialAccountInfo", vo);
	}
}
