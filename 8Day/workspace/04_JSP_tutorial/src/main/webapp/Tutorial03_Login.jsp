<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="Tutorial03_LoginResult.jsp" method="post">
		<p><b>아이디 : </b></p>
		<input type="text" name="id" required><br/><br/>
		<p><b>비밀번호 : </b></p>
		<input type="password" name="password" required><br/><br/>
		<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="초기화">
	</form>
</body>
</html>