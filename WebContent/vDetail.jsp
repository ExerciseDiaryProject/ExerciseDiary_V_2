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
	프로그램 번호 : ${videoDetail.programNo} <br>
	플레이리스트 : ${videoDetail.playlist} <br>
	채널 : ${videoDetail.channel.getChannel()} <br>
	운동목적 : ${videoDetail.purpose.getPurpose()} <br>
	<iframe src='${videoDetail.youtubeUrl}'></iframe><br>
	유튜브URL : ${videoDetail.youtubeUrl} <br>
	<iframe src='https://www.youtube.com/embed/PLvJb0LzWxpUsOvxIeHwWI05Snq7rkykmY'></iframe><br>
	<iframe width="560" height="315" src="https://www.youtube.com/embed/3T8W2vGyRZQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
<button id="btn">다이어리 작성</button>
</body>
</html>