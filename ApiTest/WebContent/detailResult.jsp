<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
	<table border="1" align="left" width="400">
		<tr>
			<th>영화</th>
			<th colspan="4"><h2>${detail.movieNm}</h2>
				<h5>(${detail.movieNmEn})</h5></th>
		</tr>
		<tr>
			<th>감독</th>
			<th colspan="4">${detail.directors[0].peopleNm}</th>
		</tr>
		<tr>
			<th>개요</th>
			<th><c:forEach items="${detail.genres}" var="i">${i.genreNm} </c:forEach></th>
			<th>${detail.nations[0].nationNm}</th>
			<th>${detail.showTm}분</th>
			<th>${detail.openDt}개봉</th>
		</tr>
		<tr>
			<th>출연</th>
			<th colspan="4"><c:forEach items="${detail.actors}" var="i" end="3">
				${i.peopleNm}
			</c:forEach></th>
		</tr>
	</table>
</body>
</html>