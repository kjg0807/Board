package com.naver.start.board;

import java.sql.Date;

public class BoardDTO
{
	private long boardNum;
	private String title;
	private String context;
	private String writer;
	private Date today;
	private long view_count;

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

	public Date getToday()
	{
		return today;
	}

	public void setToday(Date today)
	{
		this.today = today;
	}

	public long getView_count()
	{
		return view_count;
	}

	public void setView_count(long view_count)
	{
		this.view_count = view_count;
	}

}
