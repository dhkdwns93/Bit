<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<SCRIPT language=javascript>
	function checkValReview() {
		var f = window.document.writeForm;
		if (f.re_title.value == "") {
			alert("제목을 입력해주세요.");
			f.re_title.focus();
			return false;
		}
		if (f.re_content.value == "") {
			alert("후기를 입력해주세요.");
			f.re_content.focus();
			return false;
		}
		if (f.re_star.value == ""||f.re_star.value==0) {
			alert("평점을 입력해주세요.");
			f.re_star.focus();
			return false;
		}
		if (f.password.value == "") {
			alert("글 비밀번호를 입력해주세요.");
			f.password.focus();
			return false;
		}
		return true;
	}
</SCRIPT>
<style>
div.stars {
	width: 270px;
	display: inline-block;
}

input.star {
	display: none;
}

label.star {
	float: right;
	padding: 10px;
	font-size: 36px;
	color: #444;
	transition: all .2s;
}

input.star:checked ~ label.star:before {
	content: '\f005';
	color: #FD4;
	transition: all .25s;
}

input.star-5:checked ~ label.star:before {
	color: #FE7;
	text-shadow: 0 0 20px #952;
}

input.star-1:checked ~ label.star:before {
	color: #F62;
}

label.star:hover {
	transform: rotate(-15deg) scale(1.3);
}

label.star:before {
	content: '\f006';
	font-family: FontAwesome;
}
</style>

</HEAD>
<BODY>

	<form name="writeForm" method="post" action="../front?cmd=insertReview"
		onSubmit='return checkValReview()'>

		<table align="center" cellpadding="5" cellspacing="2" width="550"
			border="5">

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
				<td width="450" height="20"><b><span style="font-size: 9pt"><input
							name="user_id" value="${loginUser}" style="display: none">&emsp;${loginUser}</span></b></td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">영화</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input name="m_id"
							value="${detail.movieCd}" style="display: none"><input
							name="m_name" value="${detail.movieNm}" style="display: none">&emsp;${detail.movieNm}
					</span></b></td>
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
								cols="50" rows="25"></textarea></span></b></td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="center">
						<b><span style="font-size: 9pt;">별점</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><div class="stars">
							<input class="star star-5" id="star-5" type="radio" name="re_star" value="5"/>
							<label class="star star-5" for="star-5" ></label> <input
								class="star star-4" id="star-4" type="radio" name="re_star" value="4"/> <label
								class="star star-4" for="star-4"></label> <input
								class="star star-3" id="star-3" type="radio" name="re_star" value="3"/> <label
								class="star star-3" for="star-3"></label> <input
								class="star star-2" id="star-2" type="radio" name="re_star" value="2"/> <label
								class="star star-2" for="star-2"></label> <input
								class="star star-1" id="star-1" type="radio" name="re_star" value="1"/> <label
								class="star star-1" for="star-1"></label>
						</div></b></td>
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