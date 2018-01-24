
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ServletContextListener에서 저장된 자료 가져오기</h1>

<fieldset>
	<legend>나라선택</legend>
	<c:forEach items="${applicationScope.map}" var="nation">
		<input type="radio" name="nation" value="${nation.key}">${nation.value}
	</c:forEach>
</fieldset>
</body>
</html> 