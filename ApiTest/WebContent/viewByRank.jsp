<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>박스오피스 순위</title>
</head>
<body>
	<h1>BoxOffice Rank</h1>
	<table>
		<tr>
			<th>순위</th>
			<th>영화</th>
		</tr>
		<c:forEach items="${jArr}" var="i" varStatus="state">
			<tr>
				<th>${state.count}</th>
				<th><a href="detailView?code=${i.movieCd}">${i.movieNm}</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>