<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String MainPageName = request.getParameter("page");
	if(MainPageName == null){
		MainPageName = "Home.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Page</title>
<style type="text/css">
	table {
		margin: auto;
		width: 1880px;
		height: 960px;
		color: blue;
		border: 2px red;
	}
</style>
</head>
<body>
	<table border="1">
		<tr><!-- Top -->
			<td height="15%" align="center">
				<a href="./Main.jsp?page=Home.jsp">개발자 쇼핑몰</a> 
			</td>
			<td height="15%" colspan="2" align="right">
				<jsp:include page="Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<!-- Left -->
			<td width="20%" align="right" valign="middle">
				<jsp:include page="Left.jsp"></jsp:include>
			</td>
			<!-- Main -->
			<td colspan="2" align="center">
				<jsp:include page='<%= MainPageName %>'></jsp:include>
			</td>
		</tr>
		<tr>
			<!-- Bottom -->
			<td width="100%" height="10%" colspan="3" align="center">
				<jsp:include page="Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>