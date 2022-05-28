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
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	%>
	<h1>아이디 : <%= id %>  비밀번호 : <%= password %></h1>
	<% 
		String[] Save_ID = request.getParameterValues("save_id");
		if(Save_ID != null){
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(600);
			response.addCookie(cookie);
		}else{
			Cookie[] cookies = request.getCookies();
			for(Cookie co : cookies){
				if(co.getName().equals("id")){
					co.setMaxAge(0);
					response.addCookie(co);
					break;
				}
			}
		}
	%>
	<a href="Quiz_Login.jsp">돌아가기</a>
</body>
</html>




