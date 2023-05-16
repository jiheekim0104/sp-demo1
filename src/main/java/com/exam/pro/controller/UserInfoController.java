package com.exam.pro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.pro.service.UserInfoService;
import com.exam.pro.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserInfoController {
	
	@Autowired
	private UserInfoService uiService;
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute UserInfoVO user,Model m) {
		user.setUiBirth(user.getUiBirth().replace("-",""));
		log.info("========>{}",user.getUiBirth());
		log.info("========>{}",user.getUiCredat());
		log.info("========>{}",user.getUiCretim());
		m.addAttribute("msg","회원가입에 실패하였습니다.");
		m.addAttribute("url","/join");
		if(uiService.getUserInfoVOByUiId(user)!=null) {
			m.addAttribute("msg","이미 등록된 아이디입니다.");
			m.addAttribute("url","/join");
		} else if(uiService.join(user)) {
			m.addAttribute("msg","회원가입을 축하드립니다.");
			m.addAttribute("url","/login");
		}
		return "common/msg";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String getlogin(@ModelAttribute UserInfoVO user,HttpSession session, Model m) {
		String msg="아이디나 비밀번호가 잘못되었습니다.";
		String url="/login";
		if(uiService.login(user, session)) {
			msg="로그인에 성공하였습니다.";
			url="/";
		}
		m.addAttribute("msg",msg);
		m.addAttribute("url",url);
		return "common/msg";
		
	}
	
	@GetMapping("/profile")
	public String goProfile() {
		return "user/profile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/profile-update")
	public String goProfileUpdate() {
		return "user/profile-update";
	}
	
	@PostMapping("/user/update")
	public String goUpdate(UserInfoVO user, HttpSession session, Model m) {
		UserInfoVO sessionUser = (UserInfoVO)session.getAttribute("user");
		user.setUiNum(sessionUser.getUiNum());
		if(uiService.update(user)) {
			m.addAttribute("msg", "수정 완료되었습니다.");
			session.setAttribute("user", user);
		}
		return "user/profile";
	}
}
