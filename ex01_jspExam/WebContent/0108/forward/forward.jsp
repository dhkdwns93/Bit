<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward Test입니다.</h1>
	<%
		int i = 0;
		for (i = 1; i <= 10; i++) {
			out.print(i + "<br>");

		}
	%>

	<jsp:forward page="forwardResult.jsp" >
		<jsp:param value="<%=i %>" name="i"/>
	</jsp:forward>

	<h1>난 보이니?...</h1>
</body>
</html>