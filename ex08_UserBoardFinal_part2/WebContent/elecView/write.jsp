<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		
	if ( f.model_num.value == "") {
	    alert( "모델번호를 입력해 주세요." );
	    f.model_num.focus();
		return false;
    }
	if ( f.model_name.value == "" ) {
		alert( "모델이름을 입력해 주세요." );
		f.model_name.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "가격을 입력해 주세요." );
		f.price.focus();
		return false;
	}
	if ( f.description.value == "" ) {
        alert( "상품 설명을 입력해 주세요." );
        f.description.focus();
        return false;
    }
	if ( f.password.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.password.focus();
        return false;
    }
	
    return true;
}
</SCRIPT>


</HEAD>
<BODY>

<form name="writeForm" method="post" action="../elec?command=insert" 
  onSubmit='return checkValid()' enctype="multipart/form-data">

<table>
		<input type="hidden" name="movieId" value="어벤져스"/>
		<input type="hidden" name="reId" value="5"/>
	<tr>
		<td>
		게시물 비밀번호 
		</td>
		<td><input type="text" name="rePwd" value="${board.rePwd }"></td>
	</tr>
	<tr>
	<td>
		회원 아이디
	</td>
	<td><input type="text" name="userId" value="${board.userId }"></td>
	</tr>
	<tr>
	<td>
		게시물 제목
	</td>
	<td><input type="text" name="reTitle" value="${board.reTitle }"></td></tr>
	<tr>
	<td>
		별점
	</td>
	<td><input type="text" name="reStar" value="${board.reStar}"></td>
	</tr>
	<tr>
	<td>
		내용
	</td>
	<td><input type="text" name="reContent" value="${board.reContent}"></td>
	</tr>

</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="../elec?command=list">리스트로 돌아가기</a>&gt;</span></div>

<jsp:include page="../common/footer.jsp"/>