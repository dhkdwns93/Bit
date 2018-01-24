<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	

	//parameter로 전달되는 값 받기
	String addr = request.getParameter("addr");
	String id = request.getParameter("id");
%>
<h3>주소 : <%=addr %> / <%=id %></h3>
</body>
</html>