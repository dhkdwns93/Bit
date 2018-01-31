<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	var httpRequest = null;
	function getHttpRequest() {
		if (window.ActiveXObject) {
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			return new XMLHttpRequest();
		} else {
			return null;
		}
	}

	function sendProcess() {
		httpRequest = getHttpRequest();
		
		httpRequest.onreadystatechange = callbackFunction;
		httpRequest.open("GET", "hello.jsp", true);
		httpRequest.send(null);
	}
	
	function callbackFunction(){
		//호출은 4번 실행된다.
		/*
			readyState
			0 : open() 호출 전 
			1 : open() 함수 호출, send()함수 호출 전
			2 : send() 호출, 서버응답전
			3 : 서버 응답(header 전송완료, body 전송중)
			4 : 서버 응답 완료(클라이언트에 전송 완료[body 전송완료])
		*/
		
		var debug = document.getElementById("debug");
			switch (httpRequest.readyState) {
			case 1:
				debug.value+="Loading....\n";
				break;
			case 2:
				debug.value+="Loaded....\n";
				break;
			case 3:
				debug.value+="Interactive....\n";
				break;
			case 4:
				debug.value+="Complete....\n";
				break;
			}
	}
	
	function clearOnClick(){
		var debug = document.getElementById("debug");
		debug.value = "";
	}
</script>
</head>
<body>
	<textarea rows="10" cols="80" id="debug"></textarea><br>
	<input type="button" value="서버호출" onclick="sendProcess()" />
	<input type="button" value="초기화" onclick="clearOnClick()" />
</body>
</html>