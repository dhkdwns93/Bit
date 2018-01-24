<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>B형입니다.</h1>
<%=request.getParameter("name") %>님 혈액형은 <%=request.getParameter("blood") %>형
</body>
</html>