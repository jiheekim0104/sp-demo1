package com.exam.pro.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.pro.mapper.UserInfoMapper;
import com.exam.pro.vo.UserInfoVO;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoMapper uiMapper;
	
	public boolean join(UserInfoVO user) {
		return uiMapper.insertUserInfo(user)==1;
	}
	
	public UserInfoVO getUserInfoVOByUiId(UserInfoVO user) {
		return uiMapper.selectUserInfoById(user);
	}
	
	public boolean login(UserInfoVO user, HttpSession session) {
		user = uiMapper.selectUserInfoForLogin(user);
		if(user!=null) {
			session.setAttribute("user", user);
			return true;
		}
		
		return false;
	}

	public boolean update(UserInfoVO user) {
		return uiMapper.updateUserInfo(user)==1;
	}
}
