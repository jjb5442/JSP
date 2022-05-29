<%@page import="Member.DTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
%>
<jsp:useBean id="dao" class="Member.DAO" scope="page"></jsp:useBean>
<jsp:useBean id="member" class="Member.DTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>
<!-- input tab 의 name을 DTO의 맴버변수명과 일치시킨뒤 *를 할경우 자동으로 데이터가 저장된다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
 	<h1>회원 정보</h1>
 	<% if(member.getId() != null) {%>
		<% if(dao.SearchID(member.getId()) == true){ %>
				<h1>이미 존재하는 아이디입니다.</h1>
		<% }else{ 
				dao.Insert(member);		
		%>
				<h1>회원가입에 성공하셧습니다.</h1>
		<% } %> 
	<% } %>
	<% 
		ArrayList<DTO> list = dao.GetMemberList();
		for(DTO m : list){
	%>
			<p><b>
				<%= m.getNo() %>&nbsp;
				<%= m.getId() %>&nbsp;
				<%= m.getPassword() %>&nbsp;
				<%= m.getName() %>&nbsp;
				<%= m.getAddress() %>&nbsp;
				<%= m.getEmail() %>&nbsp;
			</b></p>
	<% } %>
	

</body>
</html>



