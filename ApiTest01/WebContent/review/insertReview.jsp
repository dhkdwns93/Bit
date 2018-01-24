<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>
	function checkValReview() {
		var f = window.document.writeForm;

		if (f.re_title.value == "") {
			alert("제목을 입력해 주세요.");
			f.re_title.focus();
			return false;
		}
		if (f.re_content.value == "") {
			alert("후기를 입력해 주세요.");
			f.re_content.focus();
			return false;
		}
		if (f.re_star.value == "") {
			alert("글 비밀번호를 입력해 주세요.");
			f.re_star.focus();
			return false;
		}
		if (f.password.value == "") {
			alert("글 비밀번호를 입력해 주세요.");
			f.password.focus();
			return false;
		}
		return true;
	}
</SCRIPT>


</HEAD>
<BODY>

	<form name="writeForm" method="post" action="../front?cmd=insertReview"
		onSubmit='return checkValReview()'>

		<table align="center" cellpadding="5" cellspacing="2" width="550"
			border="1">

			<tr>
				<td width="1220" height="20" colspan="2" bgcolor="#474722">
					<p align="center">
						<font color="white" size="3"><b> 후기 등록 </b></font>
					</p>
				</td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">작성자</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt"><input name="user_id"
							value="${loginUser}" style="display: none">&emsp;${loginUser}</span></b></td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">영화</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input name="m_id"
							value="${detail.movieCd}" style="display: none">&emsp;${detail.movieNm}</span></b></td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">후기 제목</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type=text name="re_title"
							size="50"></span></b></td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">후기 내용</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <textarea name="re_content"
								cols="50" rows="10"></textarea></span></b></td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">별점</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type=text name="re_star"
							size="50"></span></b></td>
			</tr>

			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">비밀번호</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type=password
							name="password" size="12">(후기 수정 / 삭제 시 필요합니다.)
					</span></b></td>
			</tr>
			<tr>
				<td width="450" height="20" colspan="2" align="center"><b><span
						style="font-size: 9pt;"><input type=submit value=글쓰기>
							<input type=reset value=다시쓰기></span></b></td>
			</tr>
		</table>

	</form>

	<jsp:include page="../common/footer.jsp" />