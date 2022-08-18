package com.naver.start.bankBook;

import java.util.ArrayList;

public interface BookDAO
{
	// Bankbook table에 Insert
	// BookNum: 현재시간을 밀리세컨즈로 변환해서 입력
	// BookSale : 1로 입력
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception;

	// bankbook 모든 데이터 조회 - 최신순으로
	public ArrayList<BankBookDTO> getList() throws Exception;

	// Sale의 값 변경
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception;

	// bookNum 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;

	// insert, update, delete는 1이나 0 반환 -> 정수형
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception;

	// delete
	public int setDelete(BankBookDTO bankBookDTO) throws Exception;
}
