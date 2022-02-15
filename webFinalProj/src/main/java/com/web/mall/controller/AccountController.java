package com.web.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.web.mall.model.AccountService;
import com.web.mall.model.AccountVO;
import com.web.mall.model.SocialAccountVO;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@RequestMapping(value="/jusoPopup", method=RequestMethod.GET)
	public String jusoPopupGET() {
		return "jusoApi/jusoPopup";
	}
	@RequestMapping(value="/jusoPopup", method=RequestMethod.POST)
	public String jusoPopupPOST() {
		return "jusoApi/jusoPopup";
	}
	@RequestMapping(value="/google/auth", method=RequestMethod.POST)
	public String googleLoginAuth(SocialAccountVO vo, String credential, Model model, HttpSession session, HttpServletRequest request) throws GeneralSecurityException, IOException {
		String referer = request.getHeader("Referer");
		referer = referer.substring(referer.indexOf('/', 8));
		HttpTransport transport = Utils.getDefaultTransport();
		JsonFactory jsonFactory = Utils.getDefaultJsonFactory();
		
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				.setAudience(Collections.singletonList("494231445138-2h489p3ollojmgeb6531mas1508c9eb0.apps.googleusercontent.com")).build();
		System.out.println("google auth");

		GoogleIdToken idToken = verifier.verify(credential);
		if (idToken != null) {
		  Payload payload = idToken.getPayload();
		  
		  vo.setRand_id(payload.getSubject()); //id
		  vo.setEmail(payload.getEmail());
		  vo.setName((String) payload.get("name"));
		  vo.setNickname(vo.getName());
		  vo.setLogin_type(2);
		  System.out.println(vo);
		  
		  return loginSocialAccount(session, model, vo, request);
		} 
		else {
		  System.out.println("Invalid ID token.");
		  model.addAttribute("login_result","fail");
		}
			
		return "redirect:" + referer;
	    
	}//googleLogin
	@ResponseBody
	@RequestMapping(value="/kakaologin/doing", method=RequestMethod.POST)
	public Map<String, String> dokakaologin(SocialAccountVO vo, String id, String email, String nickname, HttpSession session, Model model, HttpServletRequest request) {
		vo.setRand_id(id); //id
		vo.setEmail(email);
		vo.setName(nickname);
		vo.setNickname(vo.getName());
		vo.setLogin_type(3);
		System.out.println(vo);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("res", loginSocialAccount(session, model, vo, request));
		System.out.println(result);
		return result;
	}
	public String loginSocialAccount(HttpSession session, Model model, SocialAccountVO vo, HttpServletRequest request) {
		SocialAccountVO sameData = service.checkSameAccount(vo);
		String referer = request.getHeader("Referer");
		referer = referer.substring(referer.indexOf('/', 8));
		System.out.println(referer);
		if(sameData != null) { //같은 사람이 있으면
			System.out.println("이미 계정에 같은 정보의 사람이 있음");
			if(sameData.getLogin_type() == vo.getLogin_type()) {
				System.out.println(sameData);
				session.setAttribute("logined", true);
				session.setAttribute("account", sameData);
				session.setAttribute("usertype", "social");
				return "redirect:" + referer;
			}
			else{
				if(sameData.getLogin_type() == 1) {
				model.addAttribute("error_msg", "네이버 회원으로 등록되어있습니다.");
				}
				else if(sameData.getLogin_type() == 2) {
				model.addAttribute("error_msg", "구글 회원으로 등록되어있습니다.");
				}
				else {
				model.addAttribute("error_msg", "카카오 회원으로 등록되어있습니다.");
				}
			}
			model.addAttribute("isError", true);
			return "redirect:" + referer;
		}
		else {
			System.out.println("같은 정보의 사람이 없음. ");
			if(service.socialJoin(vo)) {
				SocialAccountVO data = service.login(vo);
				System.out.println("login data = " + data);
				if(data != null) {
					session.setAttribute("logined", true);
					session.setAttribute("account", data);
					session.setAttribute("usertype", "social");
					return "redirect:" + referer;
				}
				else {
					System.out.println("login 실패");
					model.addAttribute("error_msg", "로그인 오류. 다른 외부계정으로 로그인하거나 회원가입 하세요.");
					return "redirect:" + referer;
				}
			}
			else {
				System.out.println("join 실패");
				model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다. 다른 외부계정으로 로그인하거나 회원가입 하세요.");
				return "redirect:" + referer;
			}
		}
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(AccountVO accountVo, SocialAccountVO socialVo, String zipNo, Model model, HttpServletRequest request) {
		//관리자는 관리자 로그인 후 회원관리카테고리에서 관리자 회원가입 누를수 있는 버튼 추가. 일반회원은 일반 회원가입과 동일. 위치에 따라 userType 이 다르게 들어오도록 처리.
		model.addAttribute("accountVO", accountVo);
		String referer = request.getHeader("Referer");
		referer = referer.substring(referer.indexOf('/', 8));
		if(accountVo.getAccount_id().indexOf("USER") == 0) {
			model.addAttribute("isError", true);
			model.addAttribute("error_msg", "ID는 USER로 시작할 수 없습니다.");
			return "redirect:" + referer;
		}
		else {
			AccountVO sameData = service.checkSameAccount(accountVo);
			SocialAccountVO sameSocialData = service.checkSameAccount(socialVo);
			if(sameData != null || sameSocialData != null) { //같은 사람이 있으면
				System.out.println("이미 계정에 같은 정보의 사람이 있음");
				if(sameData.getUser_type() == 1) {
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "회원으로 등록되어있습니다.");
				}
				else if(sameData.getUser_type() == 2) {
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "비회원으로 등록되어있습니다.");
				}
				else if(sameData.getUser_type() == 3){
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "관리자로 등록되어있습니다.");
				}
				else {
					if(sameSocialData.getLogin_type() == 2) {
						model.addAttribute("isError", true);
						model.addAttribute("error_msg", "구글 로그인으로 등록되어있습니다.");
					}
					else {
						model.addAttribute("isError", true);
						model.addAttribute("error_msg", "카카오 로그인으로 등록되어있습니다.");
					}
				}
				return "redirect:" + referer; //나중에 가능하면 y,n 입력받아서 회원으로 재등록할지 확인 후 처리
			}
			else {
				System.out.println("같은 정보의 사람이 없음. ");
				sameData = service.login(accountVo);
				if(sameData != null) {
					System.out.println("같은 아이디가 있음.");
					model.addAttribute("error_msg", "데이터베이스에 같은 아이디의 계정이 있습니다.");
					return "redirect:" + referer;
				}
				else {
					accountVo.setNickname(accountVo.getAccount_id());
					accountVo.setAddress_no(zipNo);
					if(service.join(accountVo)) {
						return "redirect:" + referer;
					}
					else {
						System.out.println("join 실패");
						model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
						return "redirect:" + referer;
					}
				}
			}
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(AccountVO accountVo, HttpSession session, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		referer = referer.substring(referer.indexOf('/', 8));
		System.out.println(referer);
		System.out.println(accountVo.getUser_type());
		if(accountVo.getUser_type() == 2) {
			accountVo.setAccount_id(accountVo.getEmail());
			AccountVO sameData = service.checkSameAccount(accountVo);
			if(sameData != null) { //같은 사람이 있으면
				System.out.println("이미 계정에 같은 정보의 사람이 있음");
				if(sameData.getIs_banned() == 'T') {
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "회원 탈퇴 혹은 정지된 계정입니다.");
				}
				else {
					if(sameData.getUser_type() == 1) {
						model.addAttribute("isError", true);
						model.addAttribute("error_msg", "회원으로 등록되어있습니다.");
					}
					else if(sameData.getUser_type() == 2) {
						model.addAttribute("isError", true);
						model.addAttribute("error_msg", "비회원으로 등록되어있습니다.");
					}
					else {
						model.addAttribute("isError", true);
						model.addAttribute("error_msg", "관리자로 등록되어있습니다.");
					}
				}
				
				return "redirect:" + referer; //나중에 가능하면 y,n 입력받아서 회원으로 재등록할지 확인 후 처리
			}
			else {
				System.out.println("같은 정보의 사람이 없음. ");
				sameData = service.login(accountVo);
				if(sameData != null) {
					System.out.println("같은 아이디가 있음.");
					model.addAttribute("error_msg", "데이터베이스에 같은 아이디의 계정이 있습니다.");
				}
				else {
					if(service.join(accountVo)) {
						sameData = service.login(accountVo);
						session.setAttribute("logined", true);
						session.setAttribute("account", sameData);
						session.setAttribute("usertype", "web");
					}
					else {
						System.out.println("join 실패");
						model.addAttribute("error_msg", "데이터베이스에 정상적으로 저장되지 않았습니다.");
					}
				}
			}
		}
		else {
			AccountVO data = service.login(accountVo);
			if(data != null) {
				if(data.getIs_banned() == 'T') {
					model.addAttribute("isError", true);
					model.addAttribute("error_msg", "회원 탈퇴 혹은 정지된 계정입니다.");
				}
				else {
					if(data.getPassword().equals(accountVo.getPassword())) {
						model.addAttribute("accountVO", accountVo);
						session.setAttribute("logined", true);
						session.setAttribute("account", data);
						session.setAttribute("usertype", "web");
					}
					else {
						model.addAttribute("accountVO", accountVo);
						model.addAttribute("isError", true);
						model.addAttribute("error_msg", "패스워드가 잘못되었습니다.");
						session.setAttribute("id", accountVo.getAccount_id()); //돌아갔을때 아이디 그대로 써있도록
					}
				}
			}
			else {
				model.addAttribute("isError", true);
				model.addAttribute("error_msg", "동일한 아이디가 없습니다.");
			}
		}
		return "redirect:" + referer;
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, String type, HttpServletRequest request, Model model) {
		//로그아웃 시 구글, 카카오, 일반 모두 작동되도록할 것
		String referer = request.getHeader("Referer");
		referer = referer.substring(referer.indexOf('/', 8));
		session.removeAttribute("logined");
		
		if(session.getAttribute("logined") == null) {
			session.removeAttribute("account");
			session.removeAttribute("usertype");
			return "redirect:/";
		}
		else {
			System.out.println("logout 오류 발생");
			return "redirect:" + referer;
		}
	}
	@RequestMapping(value="/drop", method=RequestMethod.GET)
	public String dropAccount(HttpSession session, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		referer = referer.substring(referer.indexOf('/', 8));
		if(session.getAttribute("usertype").equals("web")) {
			AccountVO nowAcc = (AccountVO)session.getAttribute("account");
			if(service.dropAccount(nowAcc)) {
				return "redirect:/";
			}
		}
		else {
			SocialAccountVO nowAcc = (SocialAccountVO)session.getAttribute("account");
			if(service.dropAccount(nowAcc)) {
				return "redirect:/";
			}
		}
		model.addAttribute("isError", true);
		model.addAttribute("error_msg", "계정삭제가 정상적으로 이루어지지 않았습니다.");
		return "redirect:" + referer;
	}
	@RequestMapping(value="/findMyinfo", method=RequestMethod.GET)
	public String myinfoPage() {
		return "user/mypage/mypage";
	}
	@RequestMapping(value="/checkMyinfo", method=RequestMethod.GET)
	public String seeMyinfo() {
		return "user/mypage/info";
	}
	@RequestMapping(value="/checkMyinfo", method=RequestMethod.POST)
	public String updateMyinfo(AccountVO accountVo, SocialAccountVO socialVo, HttpSession session) {
		if(session.getAttribute("usertype").equals("web")) {
			if(service.updateMyinfo(accountVo)) {
				AccountVO data = service.login(accountVo);
				session.setAttribute("account", data);
				return "user/mypage/info";
			}
		}
		else {
			if(service.updateMyinfo(socialVo)) {
				SocialAccountVO data = service.login(socialVo);
				session.setAttribute("account", data);
				return "user/mypage/info";
			}
		}
		session.setAttribute("error_msg", "정보수정에 오류가 발생했습니다.");
		return "user/mypage/info";
	}
}
