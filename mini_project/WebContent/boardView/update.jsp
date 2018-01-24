<%@page import="model.dto.Reviews"%>
<%@page import="model.service.ReviewService"%>
<%@page import="model.service.ReviewServiceImpl"%>
<%@ page info="게시판 수정하기" contentType="text/html;charset=UTF-8" %>
<jsp:include page="../common/header.jsp"/>

<HTML>
<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT >
function checkValid() {
	var f = window.document.update;
	if ( f.reTitle.value == "" ) {
		alert( "제목을 입력해주세요" );
		f.reTitle.focus();
		return false;
	}
	if ( f.reContent.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.reContent.focus();
		return false;
	}
	if ( f.reStar.value == "" ) {
        alert( "별점을 입력해 주세요." );
        f.reStar.focus();
        return false;
    }
	if ( f.rePwd.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.rePwd.focus();
        return false;
    }
	if ( f.userId.value == "" ) {
        alert( "작성자를 입력해 주세요" );
        f.userId.focus();
        return false;
    }
	
    
}

</SCRIPT>

</HEAD>

<BODY>
<%-- <%
String userId = request.getParameter("userId");
ReviewService service = new ReviewServiceImpl(); 
	Reviews rs = new Reviews();
	rs = service.selectReviewUserId(userId);
	
%> --%>

<form name=updateForm method=post action="update" onSubmit="return checkValid()">
    
    <input type='hidden' name="reId" value="${reId}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>  게시물 수정</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">Movie Name</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="movieId" size="30"
		 value="${movieId }"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">작성자</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="userId" size="30"
		 value="${udpate.userId}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="reContent" cols="50" rows="10">${update.reContent}</textarea></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">별점</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type="text" name="reStar" size="12"> 
            </span></b></td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=password name="rePwd" size="12"> 
            (비밀번호가 맞아야 수정이 가능합니다.)</span></b></td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/elec">리스트로 돌아가기</a>&gt;</span></div>
<jsp:include page="../common/footer.jsp"/>







