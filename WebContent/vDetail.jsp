<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<input type="hidden" value="userId=${sessionScope.id}">
	프로그램 번호 : ${videoDetail.programNo} <br>
	플레이리스트 : ${videoDetail.playlist} <br>
	채널 : ${videoDetail.channel.getChannel()} <br>
	운동목적 : ${videoDetail.purpose.getPurpose()} <br>
	<iframe src='https://www.youtube.com/embed/${videoDetail.youtubeUrl}'></iframe><br>
</div>
<a href="writeDiary.jsp"><input type="button" value="다이어리 작성"></a>
</body>
</html>