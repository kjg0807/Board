package com.naver.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.naver.start.util.DBConnector;

public class BankBookDAO implements BookDAO
{

	// Bankbook table에 Insert
	// BookNum: 현재시간을 밀리세컨즈로 변환해서 입력
	// BookSale : 1로 입력
	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "insert into bankbook values(?, ?, ?, 1)";
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		// st.setInt(4, bankBookDTO.getBookSale());
		// 5. 최종 전송 후 결과를 처리
		int rs = st.executeUpdate();

		System.out.println("BookNum: " + bankBookDTO.getBookNum() + ", BookName: " + bankBookDTO.getBookName() + ", BookRate: "
				+ bankBookDTO.getBookRate() + ", BookSale: " + bankBookDTO.getBookSale());

		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	// bankbook 모든 데이터 조회 - 최신순으로
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception
	{
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "select * from bankbook order by booknum desc";
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		ArrayList<BankBookDTO> ar = new ArrayList();
		BankBookDTO bankBookDTO = null;
		while (rs.next())
		{
			bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getInt("booknum"));
			bankBookDTO.setBookName(rs.getString("bookname"));
			bankBookDTO.setBookRate(rs.getDouble("bookrate"));
			bankBookDTO.setBookSale(rs.getInt("booksale"));
			ar.add(bankBookDTO);

			// System.out.println("BookNum: " + bankBookDTO.getBookNum() + ", BookName: " + bankBookDTO.getBookName() + ", BookRate: "
			// + bankBookDTO.getBookRate() + ", BookSale: " + bankBookDTO.getBookSale());
		}

		DBConnector.disConnect(rs, st, DBConn);

		return ar;
	}

	// Sale의 값 변경
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "update bankbook set booksale = 0 where booknum = ?";
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		// 5. 최종 전송 후 결과를 처리
		int rs = st.executeUpdate();

		// 6. 연결 해제
		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	// bookNum 값으로 조회
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "select * from bankbook where bookNum = ?";
		// 전체 출력 -> select * from bankmembers where userid = ? -> 검색
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		// st.setString(1, "%" + search + "%"); // 검색하려면 주석 해제
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		// BankBookDTO bankBookDTO2 = null;
		if (rs.next())
		{
			// bankBookDTO2 = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getInt("booknum"));
			bankBookDTO.setBookName(rs.getString("bookname"));
			bankBookDTO.setBookRate(rs.getDouble("bookrate"));
			bankBookDTO.setBookSale(rs.getInt("booksale"));
		}

		// System.out.println("BookNum: " + bankBookDTO.getBookNum() + ", BookName: " + bankBookDTO.getBookName() + ", BookRate: "
		// + bankBookDTO.getBookRate() + ", BookSale: " + bankBookDTO.getBookSale());

		DBConnector.disConnect(rs, st, DBConn);

		return bankBookDTO;
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "update bankbook set bookname = ?, bookrate = ? where booknum = ?";
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setLong(3, bankBookDTO.getBookNum());
		// 5. 최종 전송 후 결과를 처리
		int rs = st.executeUpdate();

		// 6. 연결 해제
		DBConnector.disConnect(st, DBConn);

		return rs;
	}

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception
	{
		// 1. DB연결 - 로그인sss
		Connection DBConn = DBConnector.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "delete bankbook where booknum = ?";
		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		// 5. 최종 전송 후 결과를 처리
		int rs = st.executeUpdate();

		// 6. 연결 해제
		DBConnector.disConnect(st, DBConn);

		return rs;
	}

}
