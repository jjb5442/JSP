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
		int i = 1;
		while(i <= 9){
			out.print("2 x " + i + " = " + (2 * i));
			i++;
	%>
		<br/>
		==============================================
		<br/>
	<%  }%>
</body>
</html>