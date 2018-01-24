<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Scope Test</h1>

<!-- 
	pageContext -> request -> session -> application
	
		: 공통의 메소드  //application이 유지되는동안
			~.setAttribute(String name, Object obj);
			Object obj = ~.getAttribute(String name);		
 -->
 
<h1>저장하기</h1>
<%
	session.setAttribute("id", "wang");
	session.setAttribute("addr", "경기도 광주시 초월읍");
	
	application.setAttribute("message", "Scope공부중..");
	application.setAttribute("hobbys", new String[]{"등산", "낚시", "게임"});
%>


<h3>저장된 정보 가져오기</h3>

<h4>
	아이디 : <%=session.getAttribute("id") %> / ${sessionScope.id }<br>
	주소   : <%=session.getAttribute("addr") %>/${sessionScope.addr }<br>
	메시지 : <%=application.getAttribute("message") %>/${applicationScope.message }<br>
	취미   : <%=application.getAttribute("hobbys") %>/${applicationScope.hobbys }<br>
	<a href="applicationResult.jsp">확인하러가기</a>
</h4>
</body>
</html>