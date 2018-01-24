<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>상세보기</title>

</head>
<body>
	<div class="con">
		<table class="con" border="3" bordercolor="#424242" width="700"
			height="250" style="font-size: 20px;border:solid">
			<tr>
				<th>영화</th>
				<th colspan="4" style="padding-left: 30px"><h2>${detail.movieNm}</h2>
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
				<th colspan="4"><c:forEach items="${detail.actors}" var="i"
						end="3">
				${i.peopleNm}
			</c:forEach></th>
			</tr>
		</table>

		<h1 style="color: blue; font-variant: small-caps; font-size: 50px;">Review
			List</h1>
		<table class="con" style="width: 700px">
			<tr style="font-size: 20px">
				<th style="text-align: center; width: 90px">글번호</th>
				<th style="text-align: center; width: 120px">작성자</th>
				<th style="text-align: center">제목</th>
				<th style="text-align: center; width: 50px">평점</th>
			</tr>
			<c:choose>
				<c:when test="${empty dList}">
					<tr>
						<td colspan="4">
							<p align="center">
								<b><span style="font-size: 9pt;">등록된 리뷰가 없습니다.</span></b>
							</p>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:set var="sumStar" value="${0}" />
					<c:forEach items="${dList}" var="i" varStatus="state">
						<c:set var="sumStar" value="${sumStar + i.reStar}" />
						<c:set var="cnt" value="${state.count}" />
						<tr>
							<th style="text-align: center"><h1 style="font-size: 20px">${i.reId}</h1></th>
							<th style="text-align: center"><h5 style="font-size: 20px">${i.userId}</h5></th>
							<th style="text-align: center"><a style="font-size: 20px"
								href="front?cmd=detailView&code=${i.mId}">${i.reTitle}</a></th>
							<th style="text-align: center"><h5 style="font-size: 20px">${i.reStar}</h5></th>
						</tr>
					</c:forEach>
					<!--<fmt:formatNumber value="${sumStar/cnt}" pattern=".0" />-->
					<c:forEach begin="1" end="${sumStar/cnt}">
						<img src="css/star.png">
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<br> <a
			style="font-size: 20px; color: white; background: red; padding: 10px"
			href="${pageContext.request.contextPath}/review/insertReview.jsp">${detail.movieNm}
			의 후기 쓰러가기</a>
	</div>
</body>
</html>

<jsp:include page="common/footer.jsp" />