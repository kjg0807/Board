package com.naver.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.naver.start.util.DBConnector;

public class BoardDAO
{
	public ArrayList<BoardDTO> getlist() throws Exception
	{
		Connection con = DBConnector.getConnection();
		// String sql = "insert into bankaccount values(account_seq.nextval, ?, ?,
		// sysdate)";
		String sql = "select * from board order by boardnum desc";
		PreparedStatement st = con.prepareStatement(sql);
		// st.setString(1, bankAccountDTO.getUserID());
		ResultSet rs = st.executeQuery();

		ArrayList<BoardDTO> ar = new ArrayList();
		BoardDTO boardDTO = null;
		while (rs.next())
		{
			boardDTO = new BoardDTO();
			// �۹�ȣ, ������, �ۼ���, �ۼ���¥, ��ȸ���� ���
			boardDTO.setBoardNum(rs.getLong("boardnum"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setRegdate(rs.getDate("regdate"));
			boardDTO.setHit(rs.getLong("hit"));
			ar.add(boardDTO);
		}
		System.out.println("boardnum: " + boardDTO.getBoardNum());

		DBConnector.disConnect(rs, st, con);

		return ar;
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception
	{
		Connection DBConn = DBConnector.getConnection();
		String sql = "select * from board where boardnum = ?";
		PreparedStatement st = DBConn.prepareStatement(sql);
		st.setLong(1, boardDTO.getBoardNum());
		ResultSet rs = st.executeQuery();

		if (rs.next())
		{
			boardDTO.setBoardNum(rs.getLong("boardnum"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setContext(rs.getString("context"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setRegdate(rs.getDate("regdate"));
			boardDTO.setHit(rs.getLong("hit"));
		}

		DBConnector.disConnect(rs, st, DBConn);

		return boardDTO;
	}
}
