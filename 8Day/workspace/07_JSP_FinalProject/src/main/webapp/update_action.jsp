<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
%>
<jsp:useBean id="dao" class="Board.DAO" scope="page"></jsp:useBean>
<jsp:useBean id="board" class="Board.DTO" scope="page"></jsp:useBean>
<jsp:setProperty property="title" 	name="board"/>
<jsp:setProperty property="content" name="board"/>
<jsp:setProperty property="id" 		name="board"	value='<%=session.getAttribute("id") %>'/>
<jsp:setProperty property="no" 		name="board"	value='<%= no %>'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% dao.Update(board);%>
	<script type="text/javascript">location.href='board.jsp'</script>
</body>
</html>





