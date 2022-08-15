<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>

	<P>The time on the server is ${serverTime}.</P>

	<a href="./board/list.naver">List Page</a>
	<br>
	<a href="./board/add.naver">Add Page</a>	
</body>
</html>
