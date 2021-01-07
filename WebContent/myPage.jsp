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

<form action="excerciseDiary" method="post">
	<input type="hidden" name="command" value="updateUserReq">
	<input type="hidden" name="userId" value="${id.userId}">
	<table border="1">
		
		<tr>
			<td>id</td><td>${id.userId}</td>
		</tr>
		<tr>	
			<td>pw</td><td>${id.userPassword}</td>
	 	</tr>
	 	<tr>
	 		<td>name</td><td>${id.userName}</td>
		</tr>
	 	<tr>
	 		<td>gender</td><td>${id.userGender}</td>
		</tr>
		<tr>
	 		<td>age</td><td>${id.userAge}</td>
		</tr>
		<tr>
	 		<td>height</td><td>${id.userHeight}</td>
		</tr>
		<tr>
	 		<td>weight</td><td>${id.userWeight}</td>
		</tr>
		<tr>
			<td>purpose</td><td>${sessionScope.id.purpose.purpose}</td>
		</tr>
	 	<tr align="center">
	 		<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
	 		<input type="button" value="탈퇴" onclick="location.href='excerciseDiary?command=userDelete&userId=${id.userId}'"></td>
	 	</tr>
	</table>
	</form>

<br><br><br>

</center>
</body>
</html>