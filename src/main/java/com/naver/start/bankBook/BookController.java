package com.naver.start.bankBook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book/*")
public class BookController
{
	// BankBookDTO bankBookDTO = new BankBookDTO();
	// BankBookDAO bankBookDAO = new BankBookDAO();

	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public String list(Model model) throws Exception
	{
		// ModelAndView mv = new ModelAndView(); //Model model + "book/list" : 2���� ��ģ ��
		System.out.println("List Test");
		BankBookDAO bankBookDAO = new BankBookDAO();
		// DB 없는 사람 주석해제
		// ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		// for (int i = 0; i < 10; i++)
		// {
		// BankBookDTO bankBookDTO = new BankBookDTO();
		// bankBookDTO.setBookName("bookName" + i);
		// bankBookDTO.setBookNum((long) i);
		// bankBookDTO.setBookRate(Math.random());
		// bankBookDTO.setBookSale(1);
		// ar.add(bankBookDTO);
		// }
		ArrayList<BankBookDTO> ar = bankBookDAO.getList(); // DB 없는 사람 주석
		model.addAttribute("list", ar);

		return "book/list";
	}

	@RequestMapping(value = "detail.naver", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Detail Test");
		// System.out.println("bookNum: " + bookNum);
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO); // DB 없는 사람 주석
		// bankBookDTO.setBookName("name");
		// bankBookDTO.setBookRate(3.14);
		// bankBookDTO.setBookSale(1);
		mv.setViewName("book/detail");
		mv.addObject("dto", bankBookDTO);

		// return "book/detail";
		return mv;
	}

	// /book/add GET /WEB-INF/views/book/add.jsp
	@RequestMapping(value = "add.naver", method = RequestMethod.GET)
	public void add() throws Exception
	{
		System.out.println("Add Test");

		// return "book/add";
	}

	// /book/add POST
	// name, rate
	@RequestMapping(value = "add.naver", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception
	{
		System.out.println("Add Post Test");
		ModelAndView mv = new ModelAndView();
		System.out.println(bankBookDTO.getBookNum());
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		//System.out.println(bankBookDTO.getBookSale());
		BankBookDAO bankBookDAO = new BankBookDAO();
		int rs = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(rs == 1);

		// 등록후 list 페이지로 이동
		mv.setViewName("redirect:./list.naver");

		return mv;
	}

	@RequestMapping(value = "modify.naver", method = RequestMethod.GET)
	public void modify(BankBookDTO bankBookDTO, Model model) throws Exception
	{
		System.out.println("Modify Get Test");
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookNum());

		model.addAttribute("dto", bankBookDTO);
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("book/modify");
		// mv.addObject("dto", bankBookDTO);
	}

	@RequestMapping(value = "modify.naver", method = RequestMethod.POST)
	public String modify(BankBookDTO bankBookDTO) throws Exception
	{
		System.out.println("Modify Post Test");

		BankBookDAO bankBookDAO = new BankBookDAO();
		int rs = bankBookDAO.setUpdate(bankBookDTO);
		System.out.println(rs == 1);

		return "redirect:../book/list.naver";
		// return "redirect:../detail?bookNum=" + bankBookDTO.getBookNum();
	}

	@RequestMapping(value = "delete.naver", method = RequestMethod.GET)
	public void delete(BankBookDTO bankBookDTO) throws Exception
	{
		System.out.println("Delete Get Test");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int rs = bankBookDAO.setDelete(bankBookDTO);
		System.out.println(rs == 1);
	}

	@RequestMapping(value = "delete.naver", method = RequestMethod.POST)
	public ModelAndView delete() throws Exception
	{
		System.out.println("Delete POST Test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../book/list.naver");

		return mv;
	}
}
