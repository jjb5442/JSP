<%@page import="Board.DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="Board.DAO" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%! DTO board; %>
<% if(request.getParameter("no") == null) {%>
	<script type="text/javascript">location.href='board.jsp'</script>
<% }else{ 
		int no = Integer.parseInt(request.getParameter("no"));
		board = dao.getBoard(no);
		if(board == null){%>
			<script type="text/javascript">location.href='board.jsp'</script>
<%		}
}%>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<table 	class="table table-striped" 
					style="text-align: center; border: 1px solid black;">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">
							게시글
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">제목</td>
						<td colspan="2"><%= board.getTitle() %></td>
					</tr>
					<tr>
						<td style="width: 20%;">작성자</td>
						<td colspan="2"><%= board.getId() %></td>
					</tr>
					<tr>
						<td style="width: 20%;">작성일자</td>
						<td colspan="2"><%= board.getRegist() %></td>
					</tr>
					<tr>
						<td style="width: 20%;">내용</td>
						<td colspan="2" style="text-align: left;">
							<%= board.getContent().replaceAll(" ","&nbsp;").replaceAll("\n", "<br/>") %>
						</td>
					</tr>
				</tbody>
			</table>
			<% if(session.getAttribute("id") != null && 
					board.getId().equals(session.getAttribute("id"))) {%>
					<a href="update.jsp?no=<%= board.getNo() %>" class="btn btn-primary">수정</a>
			<% } %>
					
			<a href="board.jsp" class="btn btn-primary">목록</a>
		</div>
	</div>
</body>
</html>






