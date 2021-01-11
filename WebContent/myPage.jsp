<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myPage.jsp</title>
</head>
<body>
<center>
${sessionScope.successMsg}
<br><br><br>
<h3>마이페이지</h3>
<hr><p>

<form action="exerciseDiary" method="post">
	<input type="hidden" name="command" value="updateUserReq">
	<input type="hidden" name="userId" value="${sessionScope.id}">
	<table border="1">
		
		<tr>
			<td>id</td><td>${user.userId}</td>
		</tr>
	 	<tr>
	 		<td>name</td><td>${user.userName}</td>
		</tr>
	 	<tr>
	 		<td>gender</td><td>${user.userGender}</td>
		</tr>
		<tr>
	 		<td>age</td><td>${user.userAge}</td>
		</tr>
		<tr>
	 		<td>height</td><td>${user.userHeight}</td>
		</tr>
		<tr>
	 		<td>weight</td><td>${user.userWeight}</td>
		</tr>
		<tr>
			<td>purpose</td><td>${user.purpose.purpose}</td>
		</tr>
	 	<tr align="center">
	 		<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
	 		<input type="button" value="탈퇴" onclick="location.href='exerciseDiary?command=userDelete&userId=${sessionScope.id}'"></td>
	 	</tr>
	</table>
	</form>
	<span style="font-size:15;">&lt;<a href="exerciseDiary?command=getAllVideoList&userId=${sessionScope.id}">돌아가기</a>&gt;</span></div>

<br><br><br>

</center>
</body>
</html>