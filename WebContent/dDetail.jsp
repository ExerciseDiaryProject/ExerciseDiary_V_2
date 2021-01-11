<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<HEAD>
<SCRIPT language=javascript>
function sendUpdate(){
	document.requestForm.command.value ="updateForm";
	document.requestForm.submit();
}
function sendDelete(){
	let recheck = confirm("정말 삭제하시겠습니까?");

	if(recheck) {
		document.requestForm.command.value ="deleteDiary";
		document.requestForm.submit();
	} else{
		return false;
	}
}
</script>
</HEAD>

<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#336699">
            <p align="center"><font color="white" size="3"><b>
            ${requestScope.diaryDetail.diaryNo}번째 일기입니다.</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">작성자</span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${requestScope.diaryDetail.userId.getUserId()}</b></span>
        </td>
         <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">운동 목적</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>${requestScope.diaryDetail.purpose.getPurpose()}</b></p>
		</td>
        
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">작성일</span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${requestScope.diaryDetail.writeDate}</b></span>
        </td>
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">체중</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>${requestScope.diaryDetail.todayWeight}</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">제 목</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${requestScope.diaryDetail.diaryTitle}</b></span>
        </td>
    </tr>
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span style="font-size:9pt;"><b>${requestScope.diaryDetail.diaryContent}</b></span></td>
    </tr>
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><span style="font-size:9pt;"> ${requestScope.diaryDetail.diaryNo}번째 운동 영상</span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span style="font-size:9pt;"><iframe src='https://www.youtube.com/embed/${requestScope.diaryDetail.programNo.youtubeUrl}'></iframe></span></td>
    </tr>
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
			<form name="requestForm" method=post action="exerciseDiary">
				<input type=hidden name="command" value="">
				<input type=hidden name="diaryNo" value="${requestScope.diaryDetail.diaryNo}">
				<input type=button value="삭제하기" onclick="sendDelete()">
			</form>
		</td>
    </tr>
</table>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="exerciseDiary?command=getDiaryList&userId=${sessionScope.id}">리스트로 돌아가기</a>&gt;</span></div>