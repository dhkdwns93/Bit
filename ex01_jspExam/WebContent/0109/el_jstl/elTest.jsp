<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL = 표현언어</h1>
<h3>
<!-- \(빽슬래쉬)를 붙이면 문자로 보여준다. -->
	\${5} = ${5 }<br>
	\${5*2} = ${5*2 }<br>
	\${5<3} = ${5<3 }<br>
	\${5gt 3} = ${5 gt 3 }<br>
	
	\${"왕준} = ${"왕준" }<br>
	\${'안녕'} = ${'안녕'}<br>
	\${3>2?"OK":"fail"} = ${3>2?"OK":"fail"}<br>
	\${3==3 and 2>1} = ${3==3 and 2>1 }<br>
	
	<hr>
	
	<!-- 
	http://localhost:8000/ex01_JspExam/ex0109/el_jstl/elTest.jsp?id=wang
	만약 id있으면 ~님, 없으면 Guest 출력
	 -->
	 ${param.id==null ? "Guest":param.id}님<br>
	 
	 <hr>
	 
	 Bean 사용하기<p><!-- Bean은 class하나 Beans는 class가 여러개 -->
	 
	 <jsp:useBean id="vo" class="ex0109.el.ProductVO"/><!-- vo = new ProductVO()동일 -->
	 
	 <!-- vo의 변수가 호출되는것이 아니라 vo의 vo.getName()이 호출된것. -->
	<%--  상품이름 : <%= vo.getName() %> / ${vo.name}<p> <br>
	 상품가격 : <%= vo.getPrice() %> / ${vo.price} <br>
	 상품 내용 : <%= vo.getDetail() %> / ${vo.detail} <br>
	 상품 수량 : <%= vo.getQty() %> / ${vo.qty} <br>
	 총 금액 : <%= vo.getPrice()*vo.getQty() %> / ${vo.price*vo.qty } <br>
	  --%>
	 
</h3>
</body>
</html>