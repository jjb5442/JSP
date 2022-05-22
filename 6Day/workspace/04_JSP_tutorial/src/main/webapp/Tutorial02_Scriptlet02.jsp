<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		response.setIntHeader("Refresh",1);
		Calendar cal = Calendar.getInstance();
		int Hour = cal.get(Calendar.HOUR_OF_DAY);
		int Minute = cal.get(Calendar.MINUTE);
		int Second = cal.get(Calendar.SECOND);
	%>
	<%-- Expression : 값 출력 --%>
	<h1>현재 시간 : <%= Hour %>시 <%= Minute %>분 <%= Second %>초 입니다.</h1>
	<% if(Hour > 12) {%>
		<h2>오후 입니다.</h2>
	<% }else{ %>
		<h2>오전 입니다.</h2>
	<% } %>
</body>
</html>



