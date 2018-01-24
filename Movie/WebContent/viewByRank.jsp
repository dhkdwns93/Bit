<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="common/header.jsp" />
<!DOCTYPE html5>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>박스오피스 순위</title>

</head>

<body>
	<div class="con">

		<h1 style="color: blue; font-variant: small-caps; font-size: 50px;">BoxOffice
			Rank</h1>
		<input type="text" id="mName" placeholder="영화 명을 입력하세요."
			style="height:40px;width: 550px"> <input type="button"
			class="btn btn-danger" onclick="search()" value="검색">
		<script>
			function search() {
				location.href = "front?cmd=searchView" + "&movieName="
						+ encodeURI(document.getElementById("mName").value);
			}
		</script>

		<table class="con" style="width: 600px" border="1">
			<tr style="font-size: 20px">
				<th style="text-align: center">순위</th>
				<th style="text-align: center">영화</th>
				<th>누적관객수</th>
			</tr>
			<c:forEach items="${jArr}" var="i" varStatus="state">
				<tr>
					<th style="text-align: center"><h1 style="font-size: 20px">${state.count}</h1></th>
					<th style="text-align: center"><a
						href="front?cmd=detailView&code=${i.movieCd}">${i.movieNm}</a></th>
					<th style="text-align: right"><h5>
							<fmt:formatNumber value="${i.audiAcc}" pattern=""></fmt:formatNumber>
						</h5></th>
				</tr>
			</c:forEach>
		</table>

		<h1 style="color: blue; font-variant: small-caps; font-size: 50px;">Review
			List</h1>

		<table class="con" style="width: 700px" border="1">
			<tr style="font-size: 20px">
				<th style="text-align: center; width: 90px">글번호</th>
				<th style="text-align: center; width: 120px">작성자</th>
				<th style="text-align: center">제목</th>
				<th style="text-align: center; width: 50px">별점</th>
			</tr>
			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td colspan="4">
							<p align="center">
								<b><span style="font-size: 9pt;">등록된 리뷰가 없습니다.</span></b>
							</p>
						</td>
					</tr>
				</c:when>
				<c:otherwise>

					<c:forEach items="${list}" var="i">
						<tr>
							<th style="text-align: center"><h1 style="font-size: 20px">${i.reId}</h1></th>
							<th style="text-align: center"><h5 style="font-size: 20px">${i.userId}</h5></th>
							<th style="text-align: center"><a style="font-size: 20px"
								href="front?cmd=detailView&code=${i.mId}">${i.reTitle}</a></th>
							<th style="text-align: center"><h5 style="font-size: 20px">${i.reStar}</h5></th>

						</tr>
					</c:forEach>
				</c:otherwise>

			</c:choose>
		</table>
	</div>
</body>
</html>
<jsp:include page="common/footer.jsp" />