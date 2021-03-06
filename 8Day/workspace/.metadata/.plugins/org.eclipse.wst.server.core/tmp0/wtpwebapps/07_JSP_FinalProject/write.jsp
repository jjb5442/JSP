<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("id") == null) {%>
		<script type="text/javascript">location.href='login.jsp';</script>
	<% } %>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<form action="write_action.jsp" method="get">
				<table class="table table-striped" style="text-align: center; border: 1px solid black">
					<thead>
						<tr style="background-color: #eeeeee";>
							<th style="text-align: center;">글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="text" class="form-control" placeholder="제목" name="title"
									maxlength="40" required/>
							</td>
						</tr>
						<tr>
							<td>
								<textarea rows="30" style="resize: none;" class="form-control"
									placeholder="내용" name="content" maxlength="2048" required></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기"/>
			</form>		
		</div>
	</div>
</body>
</html>