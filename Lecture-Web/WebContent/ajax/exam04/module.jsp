<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="httpRequest.js"></script>
<script>
	function sendOnClick() {
		var name = document.inputForm.name.value;
		var age = document.inputForm.age.value;
		var addr = document.inputForm.addr;
		
		var params = {'name':name, 'age': age, 'addr':addr.value};
		
		
		//sendProcess("GET", 'sample.jsp', params, callbackFunction);
		sendProcess("POST", 'sample.jsp', params, callbackFunction);
	}

	function callbackFunction() {

		var msg = "";
		switch (httpRequest.readyState) {
		case 1:

			msg += "Loading....\n";
			break;
		case 2:
			msg += "Loaded....\n";
			break;
		case 3:
			msg += "Interactive....\n";
			break;
		case 4:
			msg += "Complete....\n";
			//서버응답 상태 코드 체크
			if (httpRequest.status == 200) {
				msg += "웹서버에서 정상적으로 수행...\n";
				msg += "실행 결과 : " + httpRequest.responseText + "\n";
			} else {
				msg += "웹서버에서 오류 발생...\n";
				msg += '오류 코드 : ' + httpRequest.status + '\n';
				msg += '오류 내용 : ' + httpRequest.statusText + '\n';
			}
			msg += "==================================================\n";
			break;
		}
		debugTrace(msg);
	}
	function debugTrace(msg) {
		var debug = document.getElementById("debug");
		debug.value += msg;
	}
</script>
</head>
<body>
	<h2>서버에 자료 전송결과</h2>
	<textarea rows="10" cols="80" id="debug"></textarea>
	<form name="inputForm">
		이름 : <input type="text" name="name" size="20" /><br> 
		나이 : <input type="text" name="age" size="20" /><br> 
		주소 : <input type="text" name="addr" size="20" /><br> 
		<input type="button" value="서버에 자료전송" onclick="sendOnClick()" />
	</form>
</body>
</html>