<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.table {
	text-align: center;
}
</style>
<body>
	<h1>Board Detail Page</h1>
	<!-- 글번호, 글제목, 작성자, 작성날짜, 조회수, 글내용 출력 -->
	<table class="table">
		<tr>
			<!-- boardNum, title, context, writer, today, view_count -->
			<th>boardNum</th>
			<th>title</th>
			<th>context</th>
			<th>writer</th>
			<th>today</th>
			<th>view_count</th>
		</tr>
		<tr>
			<td>${dto.boardNum }</td>
			<td>${dto.title}</td>
			<td>${dto.context }</td>
			<td>${dto.writer }</td>
			<td>${dto.today }</td>
			<td>${dto.view_count }</td>
		</tr>
	</table>
	<form action="/detail.naver" method="post">
		<h3>Detail</h3>
		<a href="../">Home Page</a>
		<br>
		<a href="./list.naver">List Page</a>
		<br>
		<a href="./modify.naver?boardNum=${dto.boardNum }">Modify Page</a>
		<a href="./delete.naver?boardNum=${dto.boardNum }">Delete Page</a>
		<br>

	</form>
</body>
</html>