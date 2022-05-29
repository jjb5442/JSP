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
		String id = new String();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie co : cookies){
				if(co.getName().equals("id")){
					id = co.getValue();
					break;
				}else{
					id = "";
				}
			}
		}else{
			id = "";
		}
	%>

	<form action="Quiz_LoginResult.jsp" method="post">
		<p>
		<b>아이디 :</b>
		<input type="text" name="id" required autofocus value=<%= id %> >&nbsp;&nbsp;&nbsp;
		<% if(id.length() != 0) {%>
			<input type="checkbox" name="save_id" value="save" checked>아이디 기억하기
		<% }else{ %>
			<input type="checkbox" name="save_id" value="save">아이디 기억하기
		<% } %>
		</p>
		
		<p>
		<b>비밀번호 :</b>
		<input type="password" name="password" required>
		</p>
		<input type="submit" value="로그인">
	</form>
</body>
</html>



