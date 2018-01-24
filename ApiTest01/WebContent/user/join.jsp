<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function check() {
		var pwd = document.getElementById("pwd");
		var pwd2 = document.getElementById("pwd2");

		

			if (!(pwd.value == pwd2.value)) {
				alert("패스워드가 서로 같지 않습니다. 정확히 입력해주세요");
				pwd2.focus();
				return false;
			}
		
		return true;
	}
</script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text-center">
				<div class="col-sm-3"></div>

				<div class="col-sm-6">
					<h2>회원가입</h2>

					<form action="../joinUserServlet" method="post">
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
									placeholder="Password Check"></td>
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
								<td colspan="2"><input type="button"
									class="btn btn-primary" onclick="check();" value="확인">
									<input type="reset" class="btn btn-danger" value="취소"></td>
							</tr>


						</table>
					</form>

				</div>

			</div>
		</div>
	</div>
</body>
</html><jsp:include page="../common/footer.jsp" />