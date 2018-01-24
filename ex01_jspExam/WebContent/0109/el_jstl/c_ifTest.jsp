<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> &lt;c:if> Test </h1>
	
	<!-- 출력 -->
	<c:out value="왕준"/><br>
	
	
	<%
		String[] hobbys = {"A", "B", "C"};
		//session.setAttribute("hobbys", hobbys);
	%>
	
	
	<!-- 저장 var=변수 value=값 set이 저장되는곳은 scope영역에 저장되는 것이다.-->
	<!-- c:set == session.setAttribute()와 동일 -->
	<c:set var="id" value="jang" scope="session"/><br>
	<c:set var="hobbys" value="<%=hobbys%>" scope="session"/>
	
	<c:out value="${id}"/><!-- 변수에 넣어서 출력하고 싶을 때 -->

	<hr>
	
	<!-- 
		http://localhost:8000/ex01_jspExam/0109/el_jstl/c_ifTest.jsp?id=wang
		
		<c:if test="${param.id!=null }"></c:if>
	 -->
	<c:if test="${not empty param.id!=null }">
	<h3>${param.id}님</h3>
	</c:if>
	
	
	
	<!-- 
		http://localhost:8000/ex01_jspExam/0109/el_jstl/c_ifTest.jsp?id=wang&age=20
	 	:나이가 18보다 적으면 미성년자, 아니면 성인입니다. 출력
	 -->
	<c:choose>
		<c:when test="${param.age > 18 }">
			${param.age }살은 성인입니다.
		</c:when>
		<c:otherwise>
			${param.age }살은 미성년자입니다.
		</c:otherwise>
	</c:choose>
	 


</body>
</html>