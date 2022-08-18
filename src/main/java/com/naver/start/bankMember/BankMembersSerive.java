package com.naver.start.bankMember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service // 객체 생성, Service 역할
@Repository("myservice") // 객체 생성, DAO 역할
public class BankMembersSerive
{
	@Autowired
	private BankMembersDAO bankMembersDAO;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception
	{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception
	{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}

	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception
	{
		return bankMembersDAO.getSearchByID(search);
	}
}
