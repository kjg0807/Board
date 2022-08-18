package com.naver.start.bankMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.naver.start.util.DBConnector;

@Repository("mydao")
public class BankMembersDAO implements MembersDAO
{
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception
	{
		Connection con = DBConnector.getConnection();
		String sql = "select userid, name from bankmembers where userid = ? and pwd = ?";
		// SELECT USERNAME, NAME FROM BANKMEMBERS WHERE USERNAME = ?, PASSWORD = ?"
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankMembersDTO.getUserid());
		st.setString(2, bankMembersDTO.getPwd());
		ResultSet rs = st.executeQuery();

		if (rs.next())
		{
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserid(rs.getString("userid"));
			bankMembersDTO.setName(rs.getString("name"));
		}
		else
		{
			bankMembersDTO = null;
		}
		return bankMembersDTO;
	}

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "insert into bankmembers values(?,?,?,?,?)";
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setString(1, bankMembersDTO.getUserid());
		st.setString(2, bankMembersDTO.getPwd());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		// 5. 최종 전송 후 결과를 처리
		int rs = st.executeUpdate();

		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception
	{// 검색하려면 () 안에 -> String search
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "select * from bankmembers where name like ? order by name desc";
		// 전체 출력 -> select * from bankmembers where userid = ? -> 검색
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setString(1, "%" + search + "%"); // 검색하려면 주석 해제
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		ArrayList<BankMembersDTO> ar = new ArrayList();
		while (rs.next())
		{
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserid(rs.getString("userid"));
			bankMembersDTO.setPwd(rs.getString("pwd"));
			bankMembersDTO.setName(rs.getString("name"));
			bankMembersDTO.setEmail(rs.getString("email"));
			bankMembersDTO.setPhone(rs.getString("phone"));
			ar.add(bankMembersDTO);

			System.out.println("USERID: " + bankMembersDTO.getUserid() + ", PWD: " + bankMembersDTO.getPwd() + ", NAME: " + bankMembersDTO.getName()
					+ ", Email: " + bankMembersDTO.getEmail() + ", PHONE: " + bankMembersDTO.getPhone());
			// System.out.println("Name: " + bankMembersDTO.getName());
		}
		DBConnector.disConnect(rs, st, DBConn);

		return ar;
	}
}
