<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX06</title>
</head>
<style>
	table{
		text-align: center;
	}
</style>
<body>
	<h1>EX06</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>			
		</tr>
		<tr>
			<!-- getname을 써야 하는데 그냥 써도 이 필드의 getter를 찾아서 실행해줌 -->
			<td><c:out value="${dto.name}"/></td>
			<td><c:out value="${dto.age}"/></td>
			<td><c:out value="${gender}"/></td>			
		</tr>
	</table>
</body>
</html>