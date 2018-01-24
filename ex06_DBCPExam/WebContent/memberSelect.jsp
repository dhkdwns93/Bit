<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table{width:100%; border:5px dobule red}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none}
 </style>
<script type="text/javascript">
function del(val){
	
	location.href="deleteServlet?id="+val;
} 
 
 //삭제 기능을 담당하는 servlet 하나 작성한다.
</script>
</head>

<body>

${list }

<center>
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="9" style="text-align:right">
      <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
      <a href="index.html">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  <tr bgColor="pink">
    <th>번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>나이</th>
    <th>주소</th>
    <th>연락처</th>
    <th>가입일</th>
    <th>삭제</th>
  </tr>
  	<!-- list를 반복을 돌면서 출력..(JSTL) -->
  		<c:forEach items="${list }" var="i" varStatus="state">
  	<tr>
  			<td>${state.count }</td>
  			<td>${i.id }</td>
  			<td>${i.pwd }</td>
  			<td>${i.name }</td>
  			<td>${i.age }</td>
  			<td>${i.addr }</td>
  			<td>${i.phone }</td>
  			<td>${i.joinDate }</td>
  			<td><input type="button" value="삭제" onClick="del('${i.id}')"></td>
  		
  	</tr>
  		</c:forEach>
       
 
</table>
<p>

<form name="search" action="" method="post">
 <select name="keyField">
   <option value="0">--선택--</option>
   <option value="id">아이디</option>
   <option value="name">이름</option>
   <option value="addr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="button" value="검색" />  

</form>





</center>



</body>
</html>




