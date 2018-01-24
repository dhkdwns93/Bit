<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>회원가입</title>

<script type="text/javascript">

	function check() {
		var c = document.userInfo;
		if (c.pwd.value!=c.pwd2.value) {
			document.getElementById("checkPwd").style.color = "red";
			document.getElementById("checkPwd").innerHTML = "동일한 암호를 입력하세요.";
		} else {
			document.getElementById("checkPwd").style.color = "black";
			document.getElementById("checkPwd").innerHTML = "암호가 확인 되었습니다.";
		}

		return true;
	}
</script>
<script type="text/javascript" src="httpRequest.js"></script>



</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text-center">
				<div class="col-sm-3"></div>

				<div class="col-sm-6">
					<h2>회원가입</h2>
					<form name="userInfo"
						action="${pageContext.request.contextPath}/user?cmd=insertUser"
						method="post">
						<table class="table table-boardered">
							<tr>
								<th>아이디</th>
								<td><input type="text" class="form-control" name="userId"
									placeholder="ID"></td>
							</tr>
							<tr>
								<th>패스워드</th>
								<td><input type="password" class="form-control" name="pwd"
									placeholder="Password"></td>
							</tr>
							<tr>
								<th>패스워드확인</th>
								<td><input type="password" class="form-control" name="pwd2"
									onkeyup="check()">
									<div id="checkPwd"> </div></td>

							</tr>

							<tr>
								<th>이름</th>
								<td><input type="text" class="form-control" name="name"
									placeholder="Name"></td>
							</tr>
							<tr>
								<th>성별</th>
								<td><input type="radio" name="gender" value="남">남
									&nbsp;&nbsp; <input type="radio" name="gender" value="여">여
									&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									class="btn btn-primary" value="전송"> <input type="reset"
									class="btn btn-danger" value="취소"></td>
							</tr>

						</table>
					</form>

				</div>

			</div>
		</div>
	</div>
</body>
</html><jsp:include page="../common/footer.jsp" />