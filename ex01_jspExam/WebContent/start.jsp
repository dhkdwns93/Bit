<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Jsp & Servlet 시작하기</h1>
<%
	String name="왕준";
	
	System.out.println("난 어디에 출력되니..??"); // 콘솔창(서버창에 출력)
	
	out.println("밥 먹으로 가요.."); //브라우저 출력
	
	out.println("배고프다..."); //브라우저 출력
%>

<h3>안녕하세요 <%=name %>입니다.</h3>

<%!

	//전역변수 or 메소드 선언
	String addr;
	int age=25;
	public String test(String name){
		return name+"님 나이는"+age+"살, 주소:	"+ addr;
	}

%>
<h2> 메소드 호출 하기</h2>
<%=test("wangjun") %>
</body>
</html>