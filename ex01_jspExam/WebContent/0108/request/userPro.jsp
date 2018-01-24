<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 넘어오는 모든 name=value 형식으로 출력해 본다. -->
	<%
	request.setCharacterEncoding("UTF-8");
	Enumeration<String> e = request.getParameterNames();
	
	while(e.hasMoreElements()){//요소가 존재하는 동안 반복해라.
		String name = e.nextElement();//요소를 꺼낸다.
		String value = request.getParameter(name);
		out.print(name+"="+value+"<br>");
	}
	%>
</body>
</html>