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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	var httpRequest = null;
	function getHttpRequest(){
		if(window.ActiveXObject){
			return new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}else{
			return null;
		}
	}
	//function sendRequest(method, url, param, callback){}
	function sendRequest(method, url, param, callback){
		httpRequest.onreadystatechange = callback;
		httpRequest.open(method, url, true);
		httpRequest.send(param);
	}
	
	function requestMsg() {
		httpRequest = getHttpRequest();
		
		sendRequest("GET", "hello.jsp", null, responseMsg);
	}
	
	function responseMsg(){
		if(httpRequest.readyState == 4){//모든 데이터 전송 완료
			if(httpRequest.status == 200){//서버에서 응답완료 
				//status가 에러를 나타날때 보여지는건데. 200은 정상적으로 작동했다는 것을 의미.
				var msgView = document.getElementById("msgView");
				msgView.innerHTML = httpRequest.responseText;
			}
		}
	}
</script>

</head>
<body>
	<h2>서버에서 받은 메세지</h2>
	<div id="msgView"></div>
	<input type="button" value="서버의 자료요청" onclick="requestMsg()" />
</body>
</html>