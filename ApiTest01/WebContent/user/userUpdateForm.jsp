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


<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text-center">
				<div class="col-sm-3"></div>

				<div class="col-sm-6">
					<h2>회원정보 수정</h2>

					<form action="../updateUserServlet" method="post">
						<table class="table table-boardered">
							<tr>
								<th>아이디</th>
								<td><input type="text" class="form-control" name="userId"
									value="${loginUser}" readonly></td>
							</tr>
							<tr>
								<th>패스워드 확인</th>
								<td><input type="password" class="form-control" name="pwd"
									value="${sessionScope.loginPwd}"></td>
							</tr>

							<tr>
								<th>이름</th>
								
								<td><input type="text" class="form-control" name="name"
									value="${loginName }" readonly></td>
							</tr>
							<tr id="hidden" style="display: none;">
								<th>dd</th>
								<td><input type="text" /></td>
							<tr>
								<th>성별</th>
								<td><input type="text" class="form-control" name="gender"
									value="${sessionScope.loginGender}" readonly>
							</tr>

							<tr>
								<td colspan="2"><input type="submit"
									class="btn btn-primary" value="변경"> <input type="reset"
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