/**
 * Ajax 통신과 관련된 함수 라이브러리
 */

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
 
function sendProcess(method, url, params, callback){
	
	httpRequest = getHttpRequest();
	httpRequest.onreadystatechange = callback;
	
	httpMethod = method.toUpperCase();// toUpperCase():문자열에 있는 모든 영문자를 대문자로 변환합니다.
	if(httpMethod != "GET" && httpMethod != "POST" )
		httpMethod = "GET";
	
	var httpParams = '';
	if(params != null && params!=''){
		if(typeof params =='object'){
			for(var key in params){
				if(httpParams != ''){
					httpParams += '&';
				}
				httpParams += key + "=" + params[key];
			}
		}else{
			httpParams = params;	
		}
		
	}
	
	
	var httpUrl = url;
	if(httpMethod == 'GET' && httpParams != ''){
		httpUrl = url + "?" + httpParams;
	}
	//요청처리
	httpRequest.open(httpMethod, httpUrl, true);
	
	if(httpMethod =="POST"){
		httpRequest.setRequestHeader("Content-type", 'application/x-www-form-urlencoded');
	}
	httpRequest.send(httpMethod == 'GET'?null : httpParams);
}