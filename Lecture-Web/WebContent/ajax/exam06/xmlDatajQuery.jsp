<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="httpRequest.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function sendOnClick() {
		sendProcess("GET", "sample.xml", null, callback);

	}
	function callback() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				
				/* var data = httpRequest.responseText;
				var xmlDoc = $.parseXML(data); */
				
				var xmlDoc = httpRequest.responseXML;//응답완료

				var memberList = $(xmlDoc).find('member');
				//console.log(memberList);
				var msg = '회원수 	:' + memberList.length + '명\n';

				memberList.each(function(index) {//.each() : forEach문 또는 이터레이터에 가깝다.
					var id = $(this).find('id').text();
					var name = $(this).find('name').text();
					console.log(id);
					console.log(name);

					msg += id + '(' + name + ')\n';
				});

				debugTrace(msg);
			}
		}
	}

	function debugTrace(msg) {
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
		<br> <input type="button" value="서버 자료요청" onclick="sendOnClick()" />
	</form>
</body>
</html>