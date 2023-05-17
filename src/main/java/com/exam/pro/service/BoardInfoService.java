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
		PageHelper.startPage(board.getPage(), board.getRows());
		return new PageInfo<>(biMapper.selectBoardInfos(board),10);
	}
	
	public BoardInfoVO selectBoardInfo(BoardInfoVO board){
		BoardInfoVO boardInfo = biMapper.selectBoardInfo(board);
		if(boardInfo!=null) {
			biMapper.updateBoardInfoCnt(boardInfo);
		}
		return boardInfo;
	}
}
