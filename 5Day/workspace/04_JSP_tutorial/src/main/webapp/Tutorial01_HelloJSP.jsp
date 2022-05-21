<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorial01</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	<h1>안녕하세요 JSP 페이지입니다.</h1>
	<%-- Scriptlet : HTML 코드 사이에 Java 코드를 사용하는 JSP 태그--%>
	<% 
		int i = 100;
		//out : Servlet의 PrintWriter 와 동일한 동작을해주는 객체
		//Java 주석
		out.print("i : " +  i);
	%>
	<h1>모든 페이지 출력은 HTML코드로 동작합니다.</h1>
	
</body>
</html>