<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.kobis.kobisopenapi.consumer.rest.*"%>
<%@ page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>하이요</h1>
	<a href="listView">리스팅</a>
	<input type="text" id="mName">
	<input type="button" onclick="search()" value="검색">
	<script>
		function search() {
			location.href = "searchView"+"?movieName="+encodeURI(document.getElementById("mName").value);
		}
	</script>
</body>
</html>