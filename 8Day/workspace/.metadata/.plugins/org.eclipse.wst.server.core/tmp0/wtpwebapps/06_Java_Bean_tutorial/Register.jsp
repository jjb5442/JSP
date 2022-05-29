<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#FormArea{
		margin: auto;
		width: 600px;
		border: 1px solid black;
		background-color: gray;
	}
	h1{
		text-align: center;
		color: blue;
	}
</style>
</head>
<body>
	<h1>회원 가입</h1>
	<section id="FormArea">
		<form align="center" action="Register_Result.jsp" method="post">
			<input type="text"		name="id"		placeholder="ID" 		required><br/><br/>
			<input type="password"	name="password"	placeholder="Password" 	required><br/><br/>
			<input type="text"		name="name"		placeholder="Name" 		required><br/><br/>
			<input type="date"		name="birthday"	 						required><br/><br/>
			<input type="text"		name="address"	placeholder="Address" 	required><br/><br/>
			<input type="email"		name="email"	placeholder="Email" 	required><br/><br/>
			<input type="submit"	value="회원가입">
		</form>
	</section>
</body>
</html>