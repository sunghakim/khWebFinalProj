package com.web.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mall.model.AccountService;
import com.web.mall.model.AccountVO;

@Controller
@RequestMapping(value="/")
public class AccountController {
	@Autowired
	private AccountService service;
	

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "sunghatest/main";
	}
	@RequestMapping(value="/jusoPopup", method=RequestMethod.GET)
	public String jusoPopupGET() {
		return "sunghatest/jusoPopup";
	}
	@RequestMapping(value="/jusoPopup", method=RequestMethod.POST)
	public String jusoPopupPOST() {
		return "sunghatest/jusoPopup";
	}
	@RequestMapping(value="/naverlogin", method=RequestMethod.GET)
	public String naverlogin() {
		return "sunghatest/naverlogin";
	}
	@RequestMapping(value="/callback", method=RequestMethod.GET)
	public String naverlogincallback(String state, HttpSession session, Model model) {
		// CSRF 방지를 위한 상태 토큰 검증 검증
		// 세션 또는 별도의 저장 공간에 저장된 상태 토큰과 콜백으로 전달받은 state 파라미터의 값이 일치해야 함


		// 콜백 응답에서 state 파라미터의 값을 가져옴
		String state1 = state;


		// 세션 또는 별도의 저장 공간에서 상태 토큰을 가져옴
		String storedState = (String)session.getAttribute("state");


		if( !state.equals( storedState ) ) {
		    model.addAttribute("error_msg", "401 error"); //401 unauthorized
		} else {
			model.addAttribute("error_msg", "200 success"); //200 success
		}

		return "sunghatest/callbackagain";
	}
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "sunghatest/join";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(AccountVO accountVo, String zipNo, Boolean reJoin, Model model) {
		//관리자는 관리자 로그인 후 회원관리카테고리에서 관리자 회원가입 누를수 있는 버튼 추가. 일반회원은 일반 회원가입과 동일. 위치에 따라 userType 이 다르게 들어오도록 처리.
		model.addAttribute("accountVO", accountVo);
		AccountVO sameData = service.checkSameAccount(accountVo);
		if(reJoin == null || reJoin == false) {
			if(sameData != null) { //같은 사람이 있으면
				System.out.println("이미 계정에 같은 정보의 사람이 있음");
				if(sameData.getUser_type() == 1) {
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "회원으로 등록되어있습니다.");
					return "redirect:/login";
				}
				else if(sameData.getUser_type() == 2) {
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "비회원으로 등록되어있습니다. 회원으로 등록하시겠습니까?");
				}
				else {
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "관리자로 등록되어있습니다. 회원으로 등록하시겠습니까?");
				} //회원으로 등록하시겠습니까? -> y,n 확인 받고 처리
				return "sunghatest/join";
			}
			else {
				System.out.println("같은 정보의 사람이 없음. ");
				sameData = service.login(accountVo);
				if(sameData != null) {
					System.out.println("같은 아이디가 있음.");
					model.addAttribute("error_msg", "데이터베이스에 같은 아이디의 계정이 있습니다.");
					return "redirect:/join";
				}
				else {
					accountVo.setAddress_no(zipNo);
					if(service.join(accountVo)) {
						return "redirect:/login";
					}
					else {
						System.out.println("join 실패");
						model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
						return "redirect:/join";
					}
				}
			}
		}
		else {
			accountVo.setUser_type(1);
			if(service.join(accountVo)) {
				return "redirect:/login";
			}
			else {
				System.out.println("join 실패");
				model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
				return "redirect:/join";
			}
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "sunghatest/login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(AccountVO accountVo, HttpSession session, Model model) {
		System.out.println(accountVo.getUser_type());
		if(accountVo.getUser_type() == 2) {
			accountVo.setAccount_id(accountVo.getPhone());
		}
		AccountVO data = service.login(accountVo);
		if(data != null) {
			if(data.getPassword().equals(accountVo.getPassword())) {
				model.addAttribute("accountVO", accountVo);
				session.setAttribute("logined", true);
				session.setAttribute("account", data);
				
				return "sunghatest/main"; //메인페이지가 아니라 이전페이지로 이동하도록 수정 필요.
			}
			else {
				model.addAttribute("accountVO", accountVo);
				model.addAttribute("isError", true);
				model.addAttribute("error_msg", "패스워드가 잘못되었습니다.");
				session.setAttribute("id", accountVo.getAccount_id()); //돌아갔을때 아이디 그대로 써있도록
				return "sunghatest/login";
			}
		}
		else {
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "동일한 아이디가 없습니다.");
			return "sunghatest/login";
		}
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("logined");
		
		if(session.getAttribute("logined") == null) {
			session.removeAttribute("account");
			return "redirect:/main"; //메인페이지가 아니라 이전페이지로 이동하도록 수정 필요.
		}
		else {
			System.out.println("logout 오류 발생");
			return "redirect:/login"; //메인페이지가 아니라 이전페이지로 이동하도록 수정 필요.
		}
	}
	@RequestMapping(value="/drop", method=RequestMethod.GET)
	public String dropAccount(HttpSession session, Model model) {
		AccountVO vo = (AccountVO)session.getAttribute("account");
		if(service.dropAccount(vo)) {
			return "redirect:/main";
		}
		else {
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "계정삭제가 정상적으로 이루어지지 않았습니다.");
			return "redirect:/main";
		}
	}
	@RequestMapping(value="/findMyinfo", method=RequestMethod.GET)
	public String myinfoPage() {
		return "sunghatest/myinfo";
	}
	@RequestMapping(value="/checkMyinfo", method=RequestMethod.GET)
	public String seeMyinfo() {
		return "sunghatest/myinfodetail";
	}
	@RequestMapping(value="/checkMyinfo", method=RequestMethod.POST)
	public String updateMyinfo(AccountVO accountVo, HttpSession session) {
		if(service.updateMyinfo(accountVo)) {
			AccountVO data = service.login(accountVo);
			session.setAttribute("account", data);
			return "sunghatest/myinfodetail";
		}
		else {
			session.setAttribute("error_msg", "정보수정에 오류가 발생했습니다.");
			return "sunghatest/myinfodetail";
		}
	}
}
