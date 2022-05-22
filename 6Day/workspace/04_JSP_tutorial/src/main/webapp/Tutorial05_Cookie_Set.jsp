<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 생성 페이지</h1>
	<% 
		System.out.println("서버에서 쿠키를 생성하였습니다.");
		//new Cookie(name,value);
		Cookie cookie = new Cookie("id","admin");
		//cookie.setMaxAge : 쿠키의 유효시간 설정(초단위) 설정된 시간이 지나면 쿠키값 자동 삭제
		cookie.setMaxAge(60 * 60);//1시간 설정
		response.addCookie(cookie);//생성된 쿠키를 클라이언트에게 전달
	
		cookie = new Cookie("age","20");
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
	%>
	<br/><br/>
	<a href="Tutorial05_Cookie_Get.jsp">쿠키 확인페이지 이동</a>
</body>
</html>



