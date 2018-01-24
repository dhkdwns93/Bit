<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!-- 서버에서 해석되는 인코딩 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!-- 브라우저에서 해석되는 인코딩 -->
<title>Insert title here</title>
</head>
<body>
<h1>include 지시자</h1>

<%
	String addr="제주도....";
%>

<%@include  file="top.jsp" %>

<hr>

여기는 index.jsp 문서입니다.

<hr color="red"/>

<%@ include file="footer.jsp" %>




</body>
</html>