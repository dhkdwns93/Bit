

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>
	function checkValid() {
		var f = window.document.writeForm;

		if (f.rePwd.value == "") {
			alert("게시판 비밀번호를 정해주세요");
			f.rePwd.focus();
			return false;
		}
		if (f.userId.value == "") {
			alert("회원 ID를 입력해주세요.");
			f.userId.focus();
			return false;
		}
		if (f.reTitle.value == "") {
			alert("리뷰 제목을 입력해주세요");
			f.reTitle.focus();
			return false;
		}
		if (f.reStar.value == "") {
			alert("별점을 정해주세요.");
			f.reStar.focus();
			return false;
		}
		if (f.reContent.value == "") {
			alert("내용을 입력해 주세요");
			f.reContent.focus();
			return false;
		}

		return true;
	}
</SCRIPT>


</HEAD>
<BODY>

	<form name="writeForm" method="post" action="../board?command=insert"
		onSubmit='return checkValid()'>

		<table>

		
				<input type="hidden" name="reId" >
			<tr>
				<td>영화 번호</td>
				<td><input type="text" name="movieId"></td>
			</tr>
			<tr>
				<td>게시물 비밀번호</td>
				<td><input type="text" name="rePwd"></td>
			</tr>
			<tr>
				<td>회원 아이디</td>
				<td><input type="text" name="userId" value="${userId}" readonly></td>
			</tr>
			<tr>
				<td>게시물 제목</td>
				<td><input type="text" name="reTitle"></td>
			</tr>
			<tr>
				<td>별점</td>
				<td><input type="text" name="reStar"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="reContent" cols="50" rows="10"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="글등록"></td>
				<td><input type="reset" value="초기화"></td>
			</tr>

		</table>
	</form>
	<hr>
	<div align=right>
		<span style="font-size: 9pt;">&lt;<a
			href="../board?command=list">리스트로 돌아가기</a>&gt;
		</span>
	</div>

	<jsp:include page="../common/footer.jsp" />