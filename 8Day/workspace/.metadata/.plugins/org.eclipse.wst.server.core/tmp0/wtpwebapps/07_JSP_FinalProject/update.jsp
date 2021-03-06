<%@page import="Board.DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="Board.DAO" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%! DTO board = null; %>
<% if(request.getParameter("no") == null){ %>
	<script type="text/javascript">location.href='board.jsp'</script>
<% }else{
		board = dao.getBoard(Integer.parseInt(request.getParameter("no")));
		if(board == null || board.getId().equals(session.getAttribute("id")) == false){%>
			<script type="text/javascript">location.href='board.jsp'</script>
<% 		} 
   }%>
</head>
<body>
	<% if(session.getAttribute("id") == null) {%>
		<script type="text/javascript">location.href='login.jsp';</script>
	<% } %>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<form action="update_action.jsp" method="get">
				<input type="hidden" name="no" value='<%= request.getParameter("no") %>'>
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
									maxlength="40" required value='<%= board.getTitle() %>'/>
							</td>
						</tr>
						<tr>
							<td>
								<textarea rows="30" style="resize: none;" class="form-control"
									placeholder="내용" name="content" maxlength="2048" required><%= board.getContent() %></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="수정하기"/>
			</form>		
		</div>
	</div>
</body>
</html>



