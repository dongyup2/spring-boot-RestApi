<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List page</h1>
<hr>
<table border="1">
	<thead>
		<th>mno</th><th>name</th><th>id</th>
	</thead>
	<tbody id="tbody">
		<c:forEach var="member" items="${list }">
			<tr>
				<td>${member.mno }</td>
				<td>${member.name }</td>
				<td>${member.id }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>