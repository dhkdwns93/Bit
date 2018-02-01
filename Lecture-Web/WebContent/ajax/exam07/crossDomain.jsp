<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#searchResult{
		border:1px solid red;
		width:70%;
		height:800px;
		}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		$(':button').click(function(){
			$.ajax({
				url  : 'https://apis.daum.net/search/blog',
				type : 'get',
				data : { 
					apikey :  "OPEN API KEY", 
					q : '점심메뉴',
					result : 5,
					output : 'json'
				},
				//crossDomain일 경우에는 dataType을 써줘야함
				dataType : "jsonp",
				success : callback ,
				error : function(){
					alert('error');
				}
			});
		});
	});
	function callback(data){
		var itemList = data.channel.item;
		for(var i = 0 ; i < itemList.length ; i++){
			var item = itemList[i];
			
			var title = item.title;
			var description = item.description;
			var link = item.link;
			
			$('#searchResult').append("<hr>");
			$('#searchResult').append('<a href="'+link+'">'+title+"</a>");
			$('#searchResult').append("<br>");
			$('#searchResult').append(description +"<br>");
			$('#searchResult').append("<hr>");
			
		}
	}
</script>
</head>
<body>
	<h2>DAUM 블로그 검색</h2>
	검색어 입력 : <input type="text" name="searchWord" size="20" />
	<input type="button" value="검색" />
	<br>
	<h4>검색 결과</h4>
	<div id="searchResult"></div>
</body>
</html>