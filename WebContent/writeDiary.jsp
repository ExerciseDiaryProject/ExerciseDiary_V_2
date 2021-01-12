<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeDiary.jsp</title>
</head>
<body>
<form name="writeForm" method="post" action="exerciseDiary">

<input type="hidden" name="command" value="addDiary">
<input type="hidden" name="userId" value='${sessionScope.id}'>

${successMsg}

<table align="center" cellpadding="5" cellspacing="2" width="600" border="1">

    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#336699">
            <p align="center"><font color="white" size="3"><b>다이어리 작성</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">작성자</span></b></p>
        </td>
        <td width="450" height="20" colspan="3"><b><span style="font-size:9pt;">
		${sessionScope.id}</span></b></td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">목 적</span></b></p>
        </td>
        <td width="100" height="20" ><select id="purpose" name="purpose">
							    <option value="다이어트">다이어트</option>
							    <option value="근육량 증가">근육량증가</option>
							    <option value="체형관리">체형관리</option>
							  </select></td>
		
		<td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">체 중</span></b></p>
        </td>
        <td width="100" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="todayWeight" size="50"></span></b></td>
    </tr>
    
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">영상</span></b></p>
        </td>
        <td width="450" height="20" colspan="3"><b><span style="font-size:9pt;">
		<input type=text name="programNo" size="50"></span></b></td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">제 목</span></b></p>
        </td>
        <td width="450" height="20" colspan="3"><b><span style="font-size:9pt;">
		<input type=text name="diaryTitle" size="50"></span></b></td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
        <td width="450" height="20" colspan="3"><b><span style="font-size:9pt;">
		<textarea name="diaryContent" cols="50" rows="10"></textarea></span></b></td>
    </tr>
    
    <tr>
        <td width="450" height="20" colspan="4" align="center"><b><span style="font-size:9pt;"><input type=submit value=글쓰기> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="exerciseDiary?command=getDiaryList&userId=${sessionScope.id}">리스트로 돌아가기</a>&gt;</span></div>

</BODY>
</HTML>