<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="Member.DAO" scope="page"></jsp:useBean>
<jsp:useBean id="member" class="Member.DTO" scope="page"></jsp:useBean>
<jsp:setProperty property="id" name="member" />
<jsp:setProperty property="password" name="member"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		int result = dao.login(member.getId(), member.getPassword());
		if(result == 1){
			session.setAttribute("id", member.getId());
	%>
			<script type="text/javascript"> location.href='main.jsp'; </script>
	<% 	}else if(result == 0){ %>
			<script type="text/javascript">
				alert('존재하지 않는 ID입니다.');
				history.back();
			</script>
	<% 	}else{ %>
			<script type="text/javascript">
				alert('비밀번호가 일치하지 않습니다.');
				history.back();
			</script>
	<% 	} %>
</body>
</html>




