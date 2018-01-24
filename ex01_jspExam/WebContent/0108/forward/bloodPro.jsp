<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 넘어오는 혈액형에 따라 페이지를 이동시킨다. -->
	<%
	request.setCharacterEncoding("UTF-8"); //POST방식 한글 인코딩 처리 
	String blood = request.getParameter("blood");
	%>	
<jsp:forward page='<%=blood+".jsp" %>'/>





</body>
</html>