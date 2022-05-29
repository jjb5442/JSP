<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(id != null) {
			if(id.equals("admin")){ %>
				<h1>관리자로 로그인 하였습니다.</h1>
				<div>
					<input type="button" value="회원정보 리스트">
					<input type="button" value="회원정보 수정">
					<input type="button" value="회원정보 삭제">
				</div>
			<% }else { %>
				<h1><%= id %>회원님 반갑습니다.</h1>
			<% } %>
	<% } %>
	<a href="Tutorial03_Login.jsp">돌아가기</a>
</body>
</html>











