<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="exerciseDiary.model.entity.Video, exerciseDiary.model.entity.Youtube, exerciseDiary.model.entity.Purpose" %>

<table border="1">
	<tr>
		<th>프로그램 번호</th>
		<th>플레이리스트</th>
		<th>채널</th>
		<th>운동 목적</th>
	</tr>
	<c:forEach items="${requestScope.vListPurpose}" var="data">
		<tr>
			<td>${data.programNo}</td>
			<td><a href="exerciseDiary?command=getVideoDetail&playlist=${data.playlist}">${data.playlist}</a></td>
			<td>${data.channel.getChannel()}</td>
			<td>${data.purpose.getPurpose()}</td>
		</tr>
	</c:forEach>
</table>
