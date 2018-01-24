<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	/* response.setHeader("Pragma", "no-store"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h2>LoginOk.jsp문서</h2>
<h3>로그인 완료</h3>
<!-- ${sessionScope.uesrId == null or sessionScope.userId ==""} -->
<c:choose>
	
	<c:when test="${not empty sessionScope }">
		<img src="kk.jpg" width="300" height="300"> <br>
			&emsp;=> ${sessionScope.userName }님<br>
			접속시간 : ${sessionScope.startTime} <br>
		<a href="sessionClose">로그아웃</a>
	</c:when>
	
	<c:otherwise>
		<script type="text/javascript">
			alert("로그인하고 오세요");
			location.href="LoginForm.html";
		</script>
	</c:otherwise>
</c:choose>



</body>
</html>