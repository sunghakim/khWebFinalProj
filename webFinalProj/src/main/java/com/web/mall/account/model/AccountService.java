package com.web.mall.account.model;

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
	
	public boolean dropAccount(AccountVO vo) {
		System.out.println("deleteMember 실행됨!");
		if(dao.deleteAccount(vo) == 1) {
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
	
	public AccountVO getMyinfo(AccountVO vo) {		
		return dao.selectLoginAccount(vo);
	}
	public boolean updateMyinfo(AccountVO vo) {
		int res = dao.updateAccountInfo(vo);
		if(res == 0) { // 업데이트 실패
			return false;
		}
		else {
			return true;
		}
	}
}
