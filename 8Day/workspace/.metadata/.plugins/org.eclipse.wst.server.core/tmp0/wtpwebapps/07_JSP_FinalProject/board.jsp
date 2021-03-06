<%@page import="Board.DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="Board.DAO" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
	int pageNum = 1;
	if(request.getParameter("pageNum") != null){
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
	}
%>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid black;">
				<thead>
					<tr style="background-color: #eeeeee;">
						<th style="text-align: center;">번호</th>
						<th style="text-align: center;">제목</th>
						<th style="text-align: center;">작성자</th>
						<th style="text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<% for(DTO board : dao.getBoardList(pageNum)) {%>
						<tr>
							<td><%= board.getNo() %></td>
							<td><a href="view.jsp?no=<%= board.getNo() %>"><%= board.getTitle() %></a></td>
							<td><%= board.getId() %></td>
							<td><%= board.getRegist() %></td>
						</tr>
					<% } %>
				</tbody>
			</table>
			<% if(session.getAttribute("id") != null) {%>
				<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
			<% } %>
			<% if(pageNum > 1) {%>
				<a 	href="board.jsp?pageNum=<%= pageNum - 1 %>" 
					class="btn btn-success btn-arraw-left">이전</a>
			<% } %>
			<% if(dao.getNextNO() - 1 > pageNum * 10) {%>
				<a 	href="board.jsp?pageNum=<%= pageNum + 1 %>" 
					class="btn btn-success btn-arraw-right">다음</a>
			<% } %>
		</div>
	</div>
</body>
</html>

