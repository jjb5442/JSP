<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- Declaration : 변수,메소드 선언(전역) --%>
	<%! 
		int i = 10;
		String Name = "최정호";
		
		public int Add(int n1,int n2){
			return n1 + n2;
		}
	%>
	<p><b>i의 값 : <%= i %></b>
	<p><b>Name  : <%= Name %></b>
	<p><b>Add(10,20) 호출 결과값  : <%= Add(10,20) %></b>
</body>
</html>







