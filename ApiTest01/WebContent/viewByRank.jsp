<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="common/header.jsp" />
<!DOCTYPE html5>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>박스오피스 순위</title>
<style type="text/css">
$
main-color: #F44336 ; $secondary-color: white ; $main-color: #333 ; $secondary-color: #2196f3 
	; $width: 550px ; // Change Me

* {
	box-sizing: border-box;
}

body {
	background: $main-color;
}

.centered {
	width: $width;
	height: $width/5;
	margin: auto;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
}

.group {
	width: 100%;
	height: $width/5;
	overflow: hidden;
	position: relative;
}

label {
	position: absolute;
	top: $width/15;
	color: rgba(white, .5);
	font: 400$width/15 Roboto;
	cursor: text;
	transition: .25s ease;
}

input {
	display: block;
	width: 100%;
	padding-top: $width/15;
	border: none;
	border-radius: 0; // For iOS // border-bottom : solid $ width/ 150
	rgba( white, .5);
	color: #F44336;
	background: $main-color;
	font-size: $width/15;
	transition: .3s ease; &: valid { // border-bottom-color : rgba( white,
	.5); ~ label { top : 0;
	font: 700$width/25 Roboto;
	color: rgba(white, .5);
}

}
&
:focus {
	outline: none; //
	border-bottom-color: $secondary-color; ~ label { top : 0;
	font: 700$width/25 Roboto;
	color: $secondary-color;
}

~
.bar:before {
	transform: translateX(0);
}

}
//
Stop Chrome 's hideous pale yellow background on auto-fill
  
  &:-webkit-autofill {
	-webkit-box-shadow: 0 0 0px 1000px$main-color inset;
	-webkit-text-fill-color: white !important; //
	border-bottom-color: rgba(white, .5);
}

}
.bar { //
	background: $secondary-color;
	background: rgba(white, .5);
	content: '';
	width: $width; //
	height: $width/100;
	height: $width/150; //
	transform: translateX(-100%);
	transition: .3s ease; //
	margin-top: -2px; //
	position: relative; &: before { content : '';
	position: absolute;
	width: 100%;
	height: 150%;
	background: $secondary-color;
	transform: translateX(-100%);
}

}
::selection {
	background: rgba($ secondary-color, .3);
}
</style>
</head>

<body>
	<div class="con">

		<h1>BoxOffice Rank</h1>
		<input type="text" id="mName" placeholder="영화 명을 입력하세요."> <input
			type="button" onclick="search()" value="검색">
		<script>
			function search() {
				location.href = "front?cmd=searchView" + "&movieName="
						+ encodeURI(document.getElementById("mName").value);
			}
		</script>
		<table class="con" style="width: 600px">
			<tr style="font-size: 20px">
				<th style="text-align: center">순위</th>
				<th style="text-align: center">영화</th>
				<th>누적관객수</th>
			</tr>
			<c:forEach items="${jArr}" var="i" varStatus="state">
				<tr>
					<th style="text-align: center"><h1 style="font-size: 20px">${state.count}</h1></th>
					<th style="text-align: center"><a
						href="front?cmd=detailView&code=${i.movieCd}">${i.movieNm}</a></th>
					<th style="text-align: right"><h5>${i.audiAcc}</h5></th>
				</tr>
			</c:forEach>
		</table>
			<h1>Review List</h1>
		<table class="con" style="width: 600px">
			<tr style="font-size: 20px">
				<th style="text-align: center">글번호</th>
				<th style="text-align: center">작성자</th>
				<th>제목</th>
			</tr>
			<c:forEach items="${list}" var="i">
				<tr>
					<th style="text-align: center"><h1 style="font-size: 20px">${i.reId}</h1></th>
					<th style="text-align: center"><a
						href="front?cmd=detailView&code=${i.mId}">${i.userId}</a></th>
					<th><h5>${i.reTitle}</h5></th>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
</body>
</html>
<jsp:include page="common/footer.jsp" />