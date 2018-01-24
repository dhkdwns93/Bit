<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>request 전송된 데이터 - 왕준</h1>

	<%
		//Post방식 한글 인코딩
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String ip = request.getRemoteAddr();//접속한 클라이언트의 IP
	%>



	<h3>
		이름 :
		<%=name%><br> 나이 :
		<%=age%><br> 취미 :
		<%
		String[] hobbys = request.getParameterValues("hobby");

		for (String h : hobbys) {
			out.print(h + ",");
		}
	%><br> 접속자 IP :<%=ip%><br>

	</h3>

</body>
</html>