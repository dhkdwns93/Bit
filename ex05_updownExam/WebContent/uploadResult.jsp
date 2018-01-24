<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${name}<br>
제목 : ${subject}<br>
첨부파일이름 : ${fileName}<br>
첨부실제이름 : ${fileOriginal}<br>
파일사이즈 :<fmt:formatNumber value="${fileSize}"/>byte<br>
저장경로 : ${saveDir}<br>

<hr>
<h2>Map으로 가져오기</h2>
이름 : ${map['name'] }<br>
제목 : ${map['subject']}<br>
첨부파일이름 : ${map['fileName']}<br>
첨부실제이름 : ${map['fileOriginal']}<br>
파일사이즈 :<fmt:formatNumber value="${map['fileSize']}"/>byte<br>
저장경로 : ${map['saveDir']}<br>


</body>
</html>