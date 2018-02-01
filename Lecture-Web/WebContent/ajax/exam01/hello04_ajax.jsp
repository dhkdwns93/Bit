<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#msgView {
	border: 1px solid red;
	height: 200px;
	width: 500px;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	/*
		$.ajax({ 속성 : 값, ....});
			type 	: 메소드(문자열)
			url 	: 요청 주소(문자열)
			data 	: 파라미터(문자열 , 객체)
			success : 수신성공(함수)
			error   : 수신실패(함수)
			complete: 수신성공/실패에 상관없이 실행(함수)
			async 	: 동기/비동기 설정
	*/
	
	$(document).ready(function(){
		$(":button").click(function(){//버튼을 클릭했을때 발생
			$.ajax({
				url : "hello.jsp",
				type : "get",
				success : function(data){
					console.log(data);
					//.html(): 하나만 출력
					//$('#msgView').html(data);
					//.append() : 계속해서 더해서 출력된다.
					$('#msgView').append(data);
				}
			});
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>서버에서 받은 메세지</h2>
	<div id="msgView"></div>
	<input type="button" value="서버의 자료요청" />
</body>
</html>