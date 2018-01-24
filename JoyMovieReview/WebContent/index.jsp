<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="common/header.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<blockquote>
  <h1>Joy Movie Community !!!!</h1>
  
  <h4>
    1. 주요기능 <p>
      &nbsp;&nbsp;1) 회원관리(로그인 / 로그아웃) - USERS Table <br>
      &nbsp;&nbsp;2) 해당 영화에 대한 리뷰와 리뷰 리스트 목록 (리뷰 등록, 수정, 삭제, 영화 검색) - REVIEW Table<P><br>
      
    2. 주요 기술 및 환경<p>
      &nbsp;&nbsp;1) Refactoring MVC구조  <br>
      &nbsp;&nbsp;2) Filter  - Session유무 체크 <br>
      &nbsp;&nbsp;&nbsp;&nbsp; : Board에 대한 접근은  인증된 사용자만 가능<br>
      &nbsp;&nbsp;&nbsp;&nbsp; : POST 한글인코딩처리<br>
      &nbsp;&nbsp;3) ServletContextListener - 객체 생성 및 환경설정 세팅 <br>
<!--       &nbsp;&nbsp;4) Servlet Upload + DownLoad <br> -->
      &nbsp;&nbsp;5) Action Tag include - Layout Template  <br>
      &nbsp;&nbsp;6) Bootstrap UI <br>
      &nbsp;&nbsp;7) Oracle 11g <br>
      &nbsp;&nbsp;8) ApacheTomcat 8.5<br>
    
    
  </h4>
  
</blockquote>
</body>
</html>

 <jsp:include page="common/footer.jsp"/>