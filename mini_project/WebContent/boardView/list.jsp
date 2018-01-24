<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

\${pageContext.request.contextPath} = ${pageContext.request.contextPath}

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<link rel="stylesheet" href="${path}/css/style.css">

<jsp:include page="../common/header.jsp"/>

<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption><h2 align="center">리뷰게시판 LIST</h2></caption>
	<colgroup>
		<col width="15%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">게시판 번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">영화 번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">작성자</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">리뷰 제목</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">별점</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">내용</span></b></font></p>
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 리뷰게시물이 없습니다..</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
    
	<c:forEach items="${requestScope.list}" var="i">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${i.reId}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					  ${i.movieId}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${i.userId}"</span></p>
		        </td>
		        <c:if test="${i.userId eq session.userId }">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <!-- board?command=updateAnd&userId=${i.userId}
		            ${path}/boardView/update.jsp?userId=${i.userId} -->

		            <a href="${pageContext.request.contextPath}/board?command=updateAnd&userId=${i.userId}">${i.reTitle}</a></span></p>
		             
		        </td>
		          </c:if>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${i.reStar}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${i.reContent }</span></p>
		        </td>
		        <td>
		       
		        </td>
		    </tr>
    </c:forEach>
	
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="${path}/boardView/write.jsp">글쓰기</a>&gt;</span></div>

<jsp:include page="../common/footer.jsp"/>












