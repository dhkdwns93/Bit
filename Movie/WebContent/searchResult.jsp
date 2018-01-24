<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 검색 결과</title>
</head>
<body>
	<div class="con" style="text-align: left">

		<span style="font-size: 25px; color: #F44336">[ ${name} ]</span><span>에
			대한 검색결과 : ${jSearch.totCnt} 개의 데이터</span><br><br><br>

		<ul style="list-style: none">
			<c:forEach items="${jSearch.movieList}" var="i">
				<li><h3 style="margin:2px">
						<a style="font-size: 20px" href="front?cmd=detailView&code=${i.movieCd}">${i.movieNm}</a>
					</h3></li>
				<br>
			</c:forEach>
		</ul>
	</div>

</body>
</html>
<jsp:include page="common/footer.jsp" />