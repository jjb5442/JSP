<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("id") != null) {%>
		<script type="text/javascript">location.href='main.jsp';</script>
	<% } %>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<h3 style="text-align:center;">로그인</h3>
			<form action="login_action.jsp" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="ID"
						name="id" maxlength="20" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						name="password" maxlength="20" required>
				</div>
				<input type="submit" class="btn btn-primary form-control" value="로그인">
			</form>
		</div>
	</div>
</body>
</html>