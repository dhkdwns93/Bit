<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화커뮤니티</title>

<link rel="StyleSheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<style type="text/css">
.con {
	max-width: 700px;
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>
	<div class="navbar navbar-default">
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}">Home</a></li>

				<c:if test="${loginUser == null }">
					<li><a
						href="${pageContext.request.contextPath}/user/login.jsp">Login</a></li>
				</c:if>

				<li><a
					href="${pageContext.request.contextPath}/front?cmd=listView">영화순위</a></li>
				<c:if test="${loginUser != null }">
					<li><a
						href="${pageContext.request.contextPath}/user/userUpdateForm.jsp">회원정보수정</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/userDelete.jsp">회원탈퇴</a></li>
				</c:if>
			</ul>
			<c:if test="${loginUser != null}">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#">${loginUser}!</a></li>
					<li><a href="${pageContext.request.contextPath}/logout"
						class="btn btn-danger">Logout</a></li>
				</ul>
			</c:if>
		</div>
	</div>