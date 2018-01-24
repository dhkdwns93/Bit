<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%String addr="제주도..."; 

//request(parameter로 전달되는)로 넘어오는 한글인코딩 처리.
	request.setCharacterEncoding("UTF-8");
%>

<h1>액션태그 - include </h1>

<jsp:include page="top.jsp"/>


<h3>여기는 index.jsp 문서입니다.</h3>

<hr color="blue">

<jsp:include page="footer.jsp">
 <jsp:param value="<%=addr %>" name="addr"/>
 <jsp:param value="wang" name="id"/>
</jsp:include>

</body>
</html>