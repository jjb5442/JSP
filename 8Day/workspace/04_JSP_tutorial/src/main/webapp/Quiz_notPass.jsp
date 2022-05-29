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
		//getParameter의 경우 페이지를 2번이상 넘어갔을 시 해당 값이 모두 제거된다.
		String Name = request.getParameter("name");
		String Score = request.getParameter("score");
		
		//쿠키값 가져오기
/* 		Cookie[] cookies = request.getCookies();
		String Name = new String(),Score = new String();
		for(Cookie co : cookies){
			if(co.getName().equals("name"))
				Name = co.getValue();
			else if(co.getName().equals("score"))
				Score = co.getValue();
		} */
	%>
	<h1><%= Name %>님 <%= Score %>점으로 불합격하셧습니다.</h1>
	<a href="Quiz_Score.jsp">점수 입력창 이동</a>
</body>
</html>