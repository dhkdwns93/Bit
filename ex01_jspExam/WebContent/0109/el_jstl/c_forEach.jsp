<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>&lt;c:forEach></h1>
	<!-- items는 collection의 형태를 쓸때 사용 -->
		<c:forEach begin="1" end="10" var="i">
			${i},
		</c:forEach>
		
	<hr>
	
	
	<jsp:useBean id="bean" class="ex0109.el.ListBean" scope="page" />
	<!-- 이름을 가져와서 select 박스에 만들기  -->
	<select>
		<c:forEach items="${bean.names}" var="name">
			<option value="${name}">${name}</option>
		</c:forEach>
	</select>

 	<hr>

	<!-- 메뉴를 가져와서 checkBox 만들기 -->
	<jsp:useBean id="menu" class="ex0109.el.ListBean" scope="session" />
	<c:forEach items="${bean.menus}" var="food">
		<input type="checkbox" name="menu" value="${food}" />${food}
	</c:forEach>
	
	<hr>
	<!-- board를 가져와서 테이블 만들기 -->
	<jsp:useBean id="board" class="ex0109.el.ListBean" scope="session"/>
	<table>
	<tr>
		<th>순서&emsp;</th>
		<th>번호&emsp;</th>
		<th>작성자&emsp;</th>
		<th>제목&emsp;</th>
		<th>날짜</th>
	</tr>										<!-- varStatus : 카운트, index(번지수) -->
	<c:forEach items="${bean.boardList}" var="bd" varStatus="state">
			<tr>
				<td>${state.count}/${state.index}</td>
				<td>${bd.no}</td><!-- board.getNo()호출 -->
				<td>${bd.writer}</td>
				<td>${bd.subject}</td>
				<td>${bd.date}</td>
			</tr>
		
	</c:forEach>
	</table>
	
	<hr>
	<c:forEach items="${bean.map }" var="map">
		${map.key} = ${map.value} <br>
	</c:forEach>
	
	<hr>
	2500000 / <fmt:formatNumber value="2500000"/>
	
	
</body>
</html>