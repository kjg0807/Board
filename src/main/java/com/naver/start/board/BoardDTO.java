package com.naver.start.board;

import java.sql.Date;

public class BoardDTO
{
	private long boardNum;
	private String title;
	private String context;
	private String writer;
	private Date regdate;
	private long hit;

	public long getBoardNum()
	{
		return boardNum;
	}

	public void setBoardNum(long boardNum)
	{
		this.boardNum = boardNum;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContext()
	{
		return context;
	}

	public void setContext(String context)
	{
		this.context = context;
	}

	public String getWriter()
	{
		return writer;
	}

	public void setWriter(String writer)
	{
		this.writer = writer;
	}

	public Date getRegdate()
	{
		return regdate;
	}

	public void setRegdate(Date regdate)
	{
		this.regdate = regdate;
	}

	public long getHit()
	{
		return hit;
	}

	public void setHit(long hit)
	{
		this.hit = hit;
	}

}
