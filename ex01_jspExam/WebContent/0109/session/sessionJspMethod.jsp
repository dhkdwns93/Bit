<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setMaxInactiveInterval(30);//30초
%>


<h1>session Test</h1>
<h3>
<!--세션이 생성되면 자동으로 만들어지는 세션아이디  -->
session.getId :	<%=session.getId() %><br>
<!-- 세션의 유지되는 시간설정(초단위) -->
session.getMaxInactiveInterval()	:	<%=session.getMaxInactiveInterval() %><br>
<!-- 현재 브라우져창의 세션이 새로운것인지 판별
         (true면 새로운페이지, false 기존페이지) -->
session.isNew() : <%=session.isNew() %><br>
<!--  세션이 시작된 시간. -->
session.getCreationTime() : <%=session.getCreationTime() %><br>
<!-- 마지막 접속시간 -->
session.getLastAccessedTime() : <%=session.getLastAccessedTime() %>
</h3>
</body>
</html>