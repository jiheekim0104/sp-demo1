package com.exam.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.pro.mapper.BoardInfoMapper;
import com.exam.pro.vo.BoardInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BoardInfoService {
	
	@Autowired
	private BoardInfoMapper biMapper;
	
	public PageInfo<BoardInfoVO> getBoardInfos(BoardInfoVO board){
		PageHelper.startPage(100, 10);
		return new PageInfo<>(biMapper.selectBoardInfos(board));
	}
	
}
