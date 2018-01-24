<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> scopeResult.jsp 문서 : 저장된 정보 가져오기</h3>

<h4>
	아이디 : <%=session.getAttribute("id") %><br>
	주소   : <%=session.getAttribute("addr") %><br>
	메시지 : <%=application.getAttribute("message") %><br>
	취미   : <%=application.getAttribute("hobbys") %><br>
</h4>

<hr>

<!-- 
	-pageScope  => page기본객체에 저장된 속성
    -reqeustScope =>request기본객체에 저장된 속성
    -sessionScope => session기본객체에 저장된 속성
    -applicationScope => application기본객체에 저장된 속성
    
    : xxx.Scope 단어는 생략 가능하다.
      자동의 pageScope => reqeustScope => sessionScope => applicationScope 순서로 찾는다.
    
    : 만약 각각의 scope영역에 동일 이름이 존재할 경우는 먼저 찾은 scope이 출력된다.
      이런 경우는 xxxScope을 사용하는게 좋다.
 -->
 
 <h4>
	아이디 : ${id }<br>
	주소   : ${addr }<br>
	메시지 : ${message }<br>
	취미   : ${hobbys}<br>
</h4>
</body>
</html>