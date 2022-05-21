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
		String Name = request.getParameter("name");
		int Score = Integer.parseInt(request.getParameter("score"));
		
		//쿠키 생성
		Cookie Name_Cookie = new Cookie("name",Name);
		Cookie Score_Cookie = new Cookie("score", Integer.toString(Score));
		Name_Cookie.setMaxAge(60);
		Score_Cookie.setMaxAge(60);
		response.addCookie(Name_Cookie);
		response.addCookie(Score_Cookie);
		
		System.out.println("Quiz_ScoreResult.jsp 페이지를 지나쳤습니다.");
		
		//response.sendRedirect : 특정 페이지로 바로 이동하는 함수
		if(Score >= 60){
			response.sendRedirect("Quiz_pass.jsp");
		}else{ 
			response.sendRedirect("Quiz_notPass.jsp");
	 	} 
	%>
</body>
</html>



