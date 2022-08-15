package com.naver.start.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController
{

	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public String list(Model model) throws Exception
	{
		System.out.println("List GET");

		BoardDAO boardDAO = new BoardDAO();

		ArrayList<BoardDTO> ar = boardDAO.getlist();
		model.addAttribute("list", ar);

		return "board/list";
	}

	// @RequestMapping(value = "list.naver", method = RequestMethod.POST)
	// public String list(Model model) throws Exception
	// {
	// System.out.println("List Post");
	//
	//
	// return "board/list";
	// }

	@RequestMapping(value = "detail.naver", method = RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Detail Test");

		BoardDAO boardDAO = new BoardDAO();
		boardDTO = boardDAO.getDetail(boardDTO);
		mv.setViewName("board/detail");
		mv.addObject("dto", boardDTO);

		return mv;
	}
}
