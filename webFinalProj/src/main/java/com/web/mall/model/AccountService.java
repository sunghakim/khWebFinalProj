package com.web.mall.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	public AccountVO login(AccountVO vo) {
		System.out.println("login 시도 실행됨!");
		System.out.println(vo);
		
		AccountVO data = dao.selectLoginAccount(vo);
		return data;
	}
	public SocialAccountVO login(SocialAccountVO vo) {
		System.out.println("login 시도 실행됨!");
		System.out.println(vo);
		
		SocialAccountVO data = dao.selectLoginAccount(vo);
		return data;
	}
	
	public boolean join(AccountVO vo) {
		int res = dao.insertWebUserAccount(vo);
		System.out.println("join 시도 실행됨!");
		System.out.println(vo);
		
		if(res == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean socialJoin(SocialAccountVO vo) {
		int res = dao.insertSocialUserAccount(vo);
		System.out.println("join 시도 실행됨!");
		System.out.println(vo);
		
		if(res == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean dropAccount(AccountVO vo) {		
		System.out.println("deleteMember 실행됨!");
		if(dao.updateAccountHide(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean dropAccount(SocialAccountVO vo) {		
		System.out.println("deleteMember 실행됨!");
		if(dao.updateAccountHide(vo) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public AccountVO checkSameAccount(AccountVO vo) {
		System.out.println("같은 이름과 전화번호가 있는지 확인 실행됨!");
		return dao.selectSameAccount(vo);
	}
	public SocialAccountVO checkSameAccount(SocialAccountVO vo) {
		System.out.println("같은 이름과 전화번호가 있는지 확인 실행됨!");
		return dao.selectSameAccount(vo);
	}
	
	public boolean updateMyinfo(AccountVO vo) {
		int res = dao.updateAccountInfo(vo);
		if(res == 1) { // 업데이트 성공
			return true;
		}
		else {
			return false;
		}
	}
	public boolean updateMyinfo(SocialAccountVO vo) {
		int res = dao.updateAccountInfo(vo);
		if(res == 1) { // 업데이트 성공
			return true;
		}
		else {
			return false;
		}
	}
}
