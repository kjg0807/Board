package com.naver.start.bankBook;

public class BankBookDTO
{
	private long bookNum; // auto increment
	private String bookName; // �삁湲덉＜
	private double bookRate; // �씠�옄�쑉
	private Integer bookSale; // �뙋留ㅻ맜�뒗吏� �븘�땶吏�

	public long getBookNum()
	{
		return bookNum;
	}

	public void setBookNum(long bookNum)
	{
		this.bookNum = bookNum;
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	public double getBookRate()
	{
		return bookRate;
	}

	public void setBookRate(double bookRate)
	{
		this.bookRate = bookRate;
	}

	public Integer getBookSale()
	{
		return bookSale;
	}

	public void setBookSale(Integer bookSale)
	{
		this.bookSale = bookSale;
	}

}
