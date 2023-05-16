package com.exam.pro.mapper;

import com.exam.pro.vo.UserInfoVO;

public interface UserInfoMapper {
	UserInfoVO selectUserInfoById(UserInfoVO user);
	UserInfoVO selectUserInfoForLogin(UserInfoVO user);
	int insertUserInfo(UserInfoVO user);
	int deleteUserInfo(int uiNum);
	int updateUserInfo(UserInfoVO user);

	
}
