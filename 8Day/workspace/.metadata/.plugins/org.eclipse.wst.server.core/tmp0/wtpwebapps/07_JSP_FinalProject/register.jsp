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
			<h3 style="text-align:center;">회원가입</h3>
			<form action="register_action.jsp" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="ID" 
					name="id" required maxlength="20"> 
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password" 
					name="password" required maxlength="20"> 
				</div>				
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Name" 
					name="name" required maxlength="20"> 
				</div>
				<div class="form-group" style="text-align: center;">
					<div class="btn-group" data-toggle="buttons">
						<label class="btn btn-primary active">
							<input type="radio" name="gender" value="남자" checked>남자
						</label>
						<label class="btn btn-primary active">
							<input type="radio" name="gender" value="여자"		 >여자
						</label>
					</div>
				</div>
				<div class="form-group">
					<input type="email" class="form-control" placeholder="Email" 
					name="email" required maxlength="20"> 
				</div>
				<input type="submit" class="btn btn-primary form-control" value="회원가입">
			</form>
		</div>
	</div>
</body>
</html>