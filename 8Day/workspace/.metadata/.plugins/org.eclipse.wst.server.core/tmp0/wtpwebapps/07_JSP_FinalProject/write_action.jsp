<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="Board.DAO" scope="page"></jsp:useBean>
<jsp:useBean id="board" class="Board.DTO" scope="page"></jsp:useBean>
<jsp:setProperty property="title" 	name="board"/>
<jsp:setProperty property="content" name="board"/>
<jsp:setProperty property="id" 		name="board"	value='<%=session.getAttribute("id") %>'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("id") != null) {
		dao.insert(board); %>
		<!-- 게시글 등록 DAO -->
		<script type="text/javascript">location.href='board.jsp'</script>
	<% }else{ %>
		<script type="text/javascript">location.href='login.jsp'</script>
	<% } %>
</body>
</html>


