<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 검색 결과</title>
</head>
<body>
	<h3>[ ${name} ] 에 대한 검색결과  : ${jSearch.totCnt} 개의 데이터 </h3>
	<ul>
		<c:forEach items="${jSearch.movieList}" var="i">
			<li><a href="detailView?code=${i.movieCd}">${i.movieNm}</a></li>
			<br>
		</c:forEach>
	</ul>


</body>
</html>