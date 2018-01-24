<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
a{text-decoration: none}
</style>
<body>
<ul>
		<c:forEach items="${fileNames}" var="fileName">
			<li><a href="downLoad?fName=${fileName}">${fileName}</a></li>
		</c:forEach>
	</ul>
	<hr>
	
	<h1>다운로드</h1>
	
	<%
		String fileNames[] =(String[])request.getAttribute("fileNames");
		for(String fileName:fileNames){
			String fName = URLEncoder.encode(fileName, "UTF-8");
		%>
		<a href="downLoad?fName=<%=fName %>"><%=fileName %></a><br>
		<%	
		}
	%>
	


</body>
</html>