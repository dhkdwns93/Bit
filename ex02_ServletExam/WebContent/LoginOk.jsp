<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LoginOk.jsp문서</h2>

주소 : ${sessionScope.addr } / ${addr } <br>
메세지 : ${applicationScope.message } / ${message }<br> 
이름 : ${requestScope.userName } / ${userName}<br>
<hr>

<%=application.getInitParameter("message") %>
</body>
</html>