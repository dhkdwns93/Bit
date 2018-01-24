<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.kobis.kobisopenapi.consumer.rest.*"%>
<%@ page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>미니프로젝트</title>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${not empty loginUser}">
				<h1>${loginUser}님환영합니다.</h1>
				
				
			</c:when>
			<c:otherwise>
				<h4 style="font-weight: bold; line-height: 2.0em">
					1. 주요기능
					<p>
						&emsp;1) 회원관리(로그인 / 로그아웃) - users Table <br> &emsp;2) 해당 영화에
						대한 리뷰와 리뷰 리스트 목록 (리뷰 등록, 영화 검색) - review Table
					<P>
						<br>2. 주요 기술<br> &emsp;1) Refactoring MVC구조 <br>
						&emsp;2) Filter - Session유무 체크 / Encoding(UTF-8)<br>&emsp;
						&emsp;: 접근은 로그인된 사용자만 가능<br> &emsp; &emsp;: 한글인코딩처리<br>
						&emsp;3) ServletContextListener - 객체 생성 및 환경설정 세팅 <br>
						&emsp;4) Action Tag include - Layout Template <br> &emsp;5)
						Bootstrap UI <br>
					<p>
						3. 개발환경<br> &emsp;1) Oracle 11g <br>&emsp;2)
						ApacheTomcat 8.5<br> &emsp;3) JDK 9<br>
				</h4>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>
<jsp:include page="common/footer.jsp" />