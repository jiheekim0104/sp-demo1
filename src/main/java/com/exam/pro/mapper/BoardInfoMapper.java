package com.exam.pro.mapper;

import java.util.List;

import com.exam.pro.vo.BoardInfoVO;

public interface BoardInfoMapper {
	List<BoardInfoVO> selectBoardInfos(BoardInfoVO board);
	BoardInfoVO selectBoardInfo(BoardInfoVO board);
	int updateBoardInfoCnt(BoardInfoVO board);
}
