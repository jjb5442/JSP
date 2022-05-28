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
		
		String PagePath = request.getParameter("NextPagePath");
		System.out.println("Tutorial08_Forward_Result01.jsp 페이지 지나감"); 
		System.out.println("NextPagePath : " + PagePath); 
	%>
	
	<jsp:forward page='<%= PagePath %>'>
		<jsp:param value="051-123-1234" name="tel"/>
	</jsp:forward>
</body>
</html>