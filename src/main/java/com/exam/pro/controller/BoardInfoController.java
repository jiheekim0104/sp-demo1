package com.exam.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.exam.pro.service.BoardInfoService;
import com.exam.pro.vo.BoardInfoVO;

@Controller
public class BoardInfoController {
	
	@Autowired	
	private BoardInfoService biService;
	
	@GetMapping("/boards")
	public String getBoards(@ModelAttribute BoardInfoVO board, Model m) {
		m.addAttribute("page", biService.getBoardInfos(board));
		return "board/board-list";
	}
}
