<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("POST"))
   		request.setCharacterEncoding("UTF-8");
%>
name=${param.name};