<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 삭제 페이지</h1>
	<% 
		System.out.println("서버에서 쿠키를 삭제하였습니다.");
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie co : cookies){
			String name = co.getName();
			if(name.equals("id") || name.equals("age")){
	%>
				<h3>쿠키 <%= name %> 삭제완료</h3>
	<% 
				co.setMaxAge(0);
				response.addCookie(co);
			}
		}
	%>
	<br/><br/>
	<a href="Tutorial05_Cookie_Set.jsp">쿠키 생성페이지 이동</a>
</body>
</html>



