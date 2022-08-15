<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Page</h1>
	<table>
		<thead>
			<tr>
				<!-- boardNum, title, context, writer, today -->
				<th>boardNum</th>
				<th>title</th>
				<th>context</th>
				<th>writer</th>
				<th>today</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${pageScope.dto.boardNum}</td>
					<td><a href="./detail.naver?boardNum=${pageScope.dto.boardNum}">${pageScope.dto.title}</a></td>
					<td>${pageScope.dto.writer}</td>
					<td>${pageScope.dto.today}</td>
					<td>${pageScope.dto.view_count}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="./list.naver" method="post">
		<a href="../">Home Page </a>
		<br>		
	</form>
</body>
</html>