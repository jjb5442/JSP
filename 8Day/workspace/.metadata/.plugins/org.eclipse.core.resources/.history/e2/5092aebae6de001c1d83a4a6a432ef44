<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="Member.DAO" scope="page"></jsp:useBean>
<jsp:useBean id="member" class="Member.DTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(dao.SearchID(member.getId())) {%>
		<script type="text/javascript">
			alert('이미 존재하는 아이디입니다.');
			history.back();
		</script>
	<% }else{ 
			dao.Register(member);
	%>
		<script type="text/javascript">location.href='main.jsp'</script>
	<% } %>
</body>
</html>



