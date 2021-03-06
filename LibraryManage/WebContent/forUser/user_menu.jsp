<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<link rel="stylesheet" type="text/css" href="/LibraryManage/css/menu_style.css">

<c:if test="${empty sessionScope.loginInfo}">
   <c:set scope="session" var="returnURL" value='<%=  request.getAttribute( "javax.servlet.forward.request_uri" )+"?page="+request.getParameter("page")+"&select="+request.getAttribute("select")+"&keyword="+request.getAttribute("keyword")%>'/>
</c:if>


	<c:choose>
		<c:when test = "${empty sessionScope.loginInfo}">
			<div>
			<a href = "/LibraryManage/forUser/login.jsp">로그인</a>
			<a href = "/LibraryManage/forUser/userCreate.jsp">회원가입</a>
			</div>
		</c:when>
		<c:otherwise>
			<span class="userWelcome">${sessionScope.loginInfo.userId }님 환영합니다.</span>
			<div>
			<a href = "/LibraryManage/logout">로그아웃</a>
			<a href = "/LibraryManage/forUser/MyPage.jsp">마이페이지</a>
			<a href = "/LibraryManage/RentalList">대출목록</a>
			<a href = "/LibraryManage/WaitList">대기목록</a>
			<a href = "/LibraryManage/BookSearchByKeyword?select=title">도서검색</a>
			</div>		
		</c:otherwise>
	</c:choose>

 <br> <hr>
