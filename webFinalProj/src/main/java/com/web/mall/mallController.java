package com.web.mall;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.model.Manage_AccountDTO;

@Controller
@RequestMapping(value = "/")
public class mallController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test(HttpSession session) {
		Manage_AccountDTO dto = new Manage_AccountDTO();
		dto.setAccountID("tester");
		dto.setPassword("1234");
		dto.setUserType(0);
		dto.setName("관리자");
		dto.setPhone("01055553333");
		dto.setAddress("문석구 정복동 232-4");
		dto.setNickName("관리자 닉네임");
		dto.setJoinDate(new Date());
		session.setAttribute("Account", dto);
		System.out.println("임시 세션 발급 완료");
		return "test";
	}
}


