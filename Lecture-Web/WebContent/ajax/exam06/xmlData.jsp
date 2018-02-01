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
		sendProcess("GET", "sample.xml", null, callback);
		
		
	}
	function callback(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				//console.log(httpRequest.responseText);
				//console.log(httpRequest.responseXML);
				var xmlDoc = httpRequest.responseXML;
				var memberList = xmlDoc.getElementsByTagName("member");
				var msg = '회원수 : '+memberList.length +"명\n";
				for(var i = 0 ; i<memberList.length;i++){
					var mem = memberList[i];
				//	console.log(mem.getElementsByTagName("id")[0].innerHTML);
				//	console.log(mem.getElementsByTagName("id")[0].firstChild.nodeValue);//firstChild.nodeValue : 첫번째 자식의 값
				//	console.log(mem.getElementsByTagName("name")[0].firstChild.nodeValue);//firstChild.nodeValue : 첫번째 자식의 값
					
					
					var id = mem.getElementsByTagName("id")[0].firstChild.nodeValue;
					var name = mem.getElementsByTagName("name")[0].firstChild.nodeValue;
					
					msg+= id+'('+name+')\n';
				
				}
				//console.log(memberList);
				
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
	<h2>XML DATA 예제</h2>
	<br>
	<form>
		<textarea rows="10" cols="80" id="debug"></textarea>
		<br>
		<input type="button" value="서버 자료요청" onclick="sendOnClick()" />
	</form>	
</body>
</html>