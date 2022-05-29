<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h1>쿠키 출력 페이지</h1>
	
	<% 
		System.out.println("서버에서 생성된 쿠키를 받아왔습니다.");
	
		Cookie[] cookies = request.getCookies();
		
		for(Cookie co : cookies){
			String name = co.getName();
			String value = co.getValue();
	%>
			<h3>Name : <%= name %>  Value : <%= value %></h3>
	<%	} %>
	<br/><br/>
	<a href="Tutorial05_Cookie_Delete.jsp">쿠키 삭제페이지 이동</a>
</body>
</html>





