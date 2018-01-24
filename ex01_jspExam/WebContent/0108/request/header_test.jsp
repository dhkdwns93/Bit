<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration<String> e = request.getHeaderNames();
	while(e.hasMoreElements()){
		String name = e.nextElement();
		String value = request.getHeader(name);
		out.print(name+"="+value+"<br>");
	}
%>
<hr>
<h1>request 관련 메소드</h1>
request.getContextPath() : <%=request.getContextPath() %><br>
request.getRealPath("/") : <%=request.getRealPath("/") %><br>
request.getRequestURL()  : <%=request.getRequestURI() %>
</body>
</html>