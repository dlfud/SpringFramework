<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크인</title>
</head>
<body>
	<form action="/ex02/getToWork" method="get" name="checkInFrom">
		<input type="text" name="name"/>
		<br>
		<!-- 무조건 디폴트가 submit이므로 getToWork로 날라감 -->
		<button>출근</button>
		<button type="button">퇴근</button>
	</form>
</body>
<script>
	let form = checkInFrom; // 변수에 저장
//	console.log(form.getAttribute("action")); // 잘들어오는지 확인
	let button = document.querySelector("button[type='button']"); // 버튼 변수에 저장
// 클릭 이벤트 넣음
	button.addEventListener("click", function(){
//		클릭하면 action을 leaveWork로 바꿈
		form.setAttribute("action", "/ex02/leaveWork"); // 퇴근눌렀을때 action을 leaveWork로 바꿈
//		실행
		form.submit();
	})
</script>
</html>