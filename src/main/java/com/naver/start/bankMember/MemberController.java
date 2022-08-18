package com.naver.start.bankMember;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
// �씠 �겢�옒�뒪�뒗 Controller �뿭�븷, Container(媛앹껜 �깮�꽦, �냼硫�) �뿉寃� �씠 �겢�옒�뒪�쓽 媛앹껜
// �깮�꽦 �쐞�엫
public class MemberController
{
//	@Autowired
//	@Qualifier("mydao")
//	private BankMembersDAO bankMembersDAO;

	@Autowired
	@Qualifier("myservice")
	private BankMembersSerive bankMembersSerive;

	// @Autowired
	// public MemberController(BankMembersDAO bankMembersDAO)
	// {
	// this.bankMembersDAO = bankMembersDAO;
	// }

	@RequestMapping(value = "logout.naver", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception
	{
		// 1. session을 소멸시키기
		session.invalidate();

		return "redirect:../";
	}

	// url: /member/Login �씠 �떎�뻾�맆 �븣 Login 硫붿꽌�뱶 �떎�뻾
	@RequestMapping(value = "login.naver", method = RequestMethod.GET) // "" �븞�쑝濡� �씠�룞
	public String login()
	{
		System.out.println("Login Test");

		return "member/login";
	}

	@RequestMapping(value = "login.naver", method = RequestMethod.POST) // "" �븞�쑝濡� �씠�룞
	public String login(HttpSession session, HttpServletRequest request, BankMembersDTO bankMembersDTO, Model model) throws Exception
	{
		System.out.println("DB Login Test");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		bankMembersDTO = bankMembersSerive.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		// model.addAttribute("member", bankMembersDTO);
		// HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO); // DB에 값이 있냐 없냐 판단

		// return "member/login";
		return "redirect:../";
		// return "home";
	}

	// join /member/join Get
	@RequestMapping(value = "join.naver", method = RequestMethod.GET)
	// member/join�뿉�꽌 get�쑝濡� �뱾�뼱�삤�뒗 method留� �궗�슜
	public String join()
	{
		System.out.println("Join get Test");

		return "member/join";
	}

	// Post
	@RequestMapping(value = "join.naver", method = RequestMethod.POST)
	// member/join�뿉�꽌 post�쑝濡� �뱾�뼱�삤�뒗 method留� �궗�슜
	public String join(BankMembersDTO bankMembersDTO) throws Exception
	{
		// (HttpServletRequest request, String pwd, String name, String email, String
		// phone)
		// -> DTO濡� 諛붽씀硫� 諛묒뿉 �꽑�뼵�쓣 �븞�빐�룄 �옄�룞諛붽퓭以�
		System.out.println("Join post Test");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		// String a = request.getParameter("id");
		// bankMembersDTO.setUserid(a);
		// bankMembersDTO.setPwd(pwd);
		// bankMembersDTO.setName(name);
		// bankMembersDTO.setEmail(email);
		// bankMembersDTO.setPhone(phone);
		int rs = bankMembersSerive.setJoin(bankMembersDTO);
		System.out.println(rs == 1);

		return "redirect:./login.naver";
	}

	@RequestMapping(value = "search.naver", method = RequestMethod.GET)
	public String search() throws Exception
	{
		System.out.println("Search Test");

		return "member/search";
	}

	@RequestMapping(value = "search.naver", method = RequestMethod.POST)
	public String search(String search, Model model) throws Exception
	{
		System.out.println("Search Submit Test");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersSerive.getSearchByID(search);
		// ArrayList<BankMembersDTO> ar = new ArrayList();
		// for (int i = 0; i < 10; i++)
		// {
		// BankMembersDTO bankMembersDTO = new BankMembersDTO();
		// bankMembersDTO.setUserid("id" + i);
		// bankMembersDTO.setName("name" + i);
		// bankMembersDTO.setEmail("email" + i);
		// bankMembersDTO.setPhone("phone" + i);
		// ar.add(bankMembersDTO);
		// }

		model.addAttribute("list", ar);

		return "member/list";
	}

	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public String list() throws Exception
	{
		System.out.println("List");

		return "member/list";
	}

	@RequestMapping(value = "list.naver", method = RequestMethod.POST)
	public String list(String search) throws Exception
	{
		System.out.println("List Post");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersSerive.getSearchByID(search);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/list");
		mv.addObject("list", ar);
		return "member/list";
	}
}
