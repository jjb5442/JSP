<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="Member.DTO" scope="page"></jsp:useBean>
<!-- Member.DTO member = new Member.DTO(); -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bean Data Set</h1>
	<jsp:setProperty property="*" name="member"/>
	<font size="12" color="blue">
		번호 : 		<jsp:getProperty property="no" 			name="member"/><br/>
		이름 : 		<jsp:getProperty property="name" 		name="member"/><br/>
		아이디 : 		<jsp:getProperty property="id" 			name="member"/><br/>
		비밀번호 : 	<jsp:getProperty property="password" 	name="member"/><br/>
		생년월일 : 	<jsp:getProperty property="birthday" 	name="member"/><br/>
		주소 : 		<jsp:getProperty property="address" 	name="member"/><br/>
		이메일 : 		<jsp:getProperty property="email" 		name="member"/><br/>
	</font>
	<!-- member.setNo(1); -->
	<% 
		Date Birthday = new SimpleDateFormat("yyyyMMdd").parse("19910618");
	%>
	<jsp:setProperty property="no" 			name="member" value="1"/>
	<jsp:setProperty property="name" 		name="member" value="홍길동"/>
	<jsp:setProperty property="id" 			name="member" value="Hong"/>
	<jsp:setProperty property="password" 	name="member" value="kkk123"/>
	<jsp:setProperty property="birthday" 	name="member" value='<%=Birthday %>'/>
	<jsp:setProperty property="address" 	name="member" value="부산진구 부전동"/>
	<jsp:setProperty property="email" 		name="member" value="abcd@naver.com"/>
	<hr/>
	<font size="12" color="blue">
		번호 : 		<jsp:getProperty property="no" 			name="member"/><br/>
		이름 : 		<jsp:getProperty property="name" 		name="member"/><br/>
		아이디 : 		<jsp:getProperty property="id" 			name="member"/><br/>
		비밀번호 : 	<jsp:getProperty property="password" 	name="member"/><br/>
		생년월일 : 	<jsp:getProperty property="birthday" 	name="member"/><br/>
		주소 : 		<jsp:getProperty property="address" 	name="member"/><br/>
		이메일 : 		<jsp:getProperty property="email" 		name="member"/><br/>
	</font>
</body>
</html>









