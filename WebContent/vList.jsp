<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vList.jsp</title>
</head>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script type="text/javascript">

	function listtable(){
		axios.get('exerciseDiary' , {
			params : {
				command : "purpose",
				value : purpose.value
			}
		
		})
		.then(response => {
			console.log(response.data);
			document.getElementById("listtable").innerHTML = response.data;
		})
		 .catch(error => {
			   console.log(error);
			 }); 
	};
	
	function logout() {
		let recheck = confirm("로그아웃 하시겠습니까?");
		
		if(recheck) {
			location.href="exerciseDiary?command=logout";
		} else{
			return false;
		}
	}
	
	</script>

<body>
	<br>
	<div align="right">
	
	<a href="exerciseDiary?command=getUser&userId=${sessionScope.id}">마이페이지</a>
	<a href="exerciseDiary?command=getDiaryList&userId=${sessionScope.id}">다이어리 관리</a>
	<a href="#none" onclick="logout()">로그아웃</a>
	
	</div>
	<center>
	${successMsg}
		<h3>운동 영상 list</h3>
		<hr>
		
			<select id="purpose" name="purpose">
				<option value="다이어트">다이어트</option>
				<option value="근육량 증가">근육량증가</option>
				<option value="체형관리">체형관리</option>
			</select> <input type="submit" value="검색" onclick="listtable()">
		<p>
		<hr>
		<p>
		<div id = "listtable">
		<table border="1">
			<tr>
				<th>프로그램 번호</th>
				<th>플레이리스트</th>
				<th>채널</th>
				<th>운동 목적</th>
			</tr>
			<c:forEach items="${requestScope.vList}" var="data">
				<tr>
					<td>${data.programNo}</td>
					<td><a href="exerciseDiary?command=getVideoDetail&playlist=${data.playlist}">${data.playlist}</a></td>
					<td>${data.channel.getChannel()}</td>
					<td>${data.purpose.getPurpose()}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<br> <br> <br> 
	</center>

</body>
</html>