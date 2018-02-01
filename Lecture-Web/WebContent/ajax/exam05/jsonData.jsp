<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="httpRequest.js"></script>
<script>
	function sendOnClick(){
		sendProcess("GET", "sample.jsp", null, callback);
		
		
	}
	function callback(){
		//에러 확인
		if(httpRequest.readyState==4){
			if(httpRequest.status == 200){
				var data = httpRequest.responseText;
				//var memberList = JSON.parse(data);
				var memberList = eval(data);
				//console.log(memberList);
				
				var msg='';
				msg += '회원수 :'+memberList.length+'명\n';
				
				for(var i =0 ; i<memberList.length; i++){
					var mem = memberList[i];
					var id = mem.id;
					var name = mem.name;
					
					msg += id + '('+name+')\n';
				}
				
				debugTrace(msg);
			}
		}
	}
	
	function debugTrace(msg){
		var debug = document.getElementById("debug");
		debug.value += msg;
	}
</script>
</head>
<body>
	<h2>JSON DATA 예제</h2>
	<br>
	<form>
		<textarea rows="10" cols="80" id="debug"></textarea>
		<br>
		<input type="button" value="서버 자료요청" onclick="sendOnClick()" />
	</form>	
</body>
</html>