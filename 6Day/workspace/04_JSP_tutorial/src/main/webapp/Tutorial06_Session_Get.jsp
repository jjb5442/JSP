<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- Session 특정 데이터 확인 --%>
	<% 
		String id = (String)session.getAttribute("id");
		String password = (String)session.getAttribute("password");
	%>
	<h1>id : <%= id %> password : <%= password %></h1>
	
	<%-- Session 전체 데이터 확인 --%>
	<hr/>
	<% 
		String SessionName = new String();
		String SessionValue = new String();
		
		//getAttributeNames : 저장된 모든 세션의 Name을 반환
		//Enumeration : 세션Name들을 저장하는 자료형
		Enumeration<String> eNames = session.getAttributeNames();
		//hasMoreElements : Enumeration 에 저장된 데이터가 남아있는지 확인
		//nextElement : 저장된 한개의 데이터를 들고오는 명령어
		while(eNames.hasMoreElements() == true){
			SessionName = eNames.nextElement();
			SessionValue = (String)session.getAttribute(SessionName);
	%>	
			<h1>Name : <%= SessionName %> Value : <%= SessionValue %></h1>
	<% 	} %>
	
	<%-- Session ID 확인 --%>
		<hr/>
	<%	String SessionID = session.getId();%>
		<h1>SessionID : <%= SessionID %></h1>
		
	<%-- Session 유효시간 확인 --%>
	<%-- SessionInterval 기본값 설정 위치 : Servers -> web.xml -> 629Line --%>
		<hr/>
	<% int SessionInterval = session.getMaxInactiveInterval();	%>
		<h1>SessionInterval = <%= SessionInterval %></h1>
		
	<%-- Session 삭제 --%>
		<hr/>
	<% session.removeAttribute("password"); %>
	<% 
		eNames = session.getAttributeNames();
		while(eNames.hasMoreElements() == true){
			SessionName = eNames.nextElement();
			SessionValue = (String)session.getAttribute(SessionName);
	%>	
			<h1>Name : <%= SessionName %> Value : <%= SessionValue %></h1>
	<% 	} %>
	
	<%-- Session 전체 삭제 --%>
		<hr/>
	<% 
		session.invalidate(); 
		//isRequestedSessionIdValid : 사용할 세션이 있는지 확인하는 함수
		if(request.isRequestedSessionIdValid()){
	%>
			<h1>Session Valid</h1>
	<% 	}else{ %>
			<h1>Session InValid</h1>
	<% 	} %>
</body>
</html>




