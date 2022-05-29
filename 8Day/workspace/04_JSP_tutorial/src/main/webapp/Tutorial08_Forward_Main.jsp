<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Forward ActionTag Test Page</h2>
	<form action="Tutorial08_Forward_Result01.jsp" method="get">
		<!-- type="hidden" : 화면상에 보여지진 않지만 다음 페이지로 데이터를 전달시 사용하는 타입 -->
		<input type="hidden" name="NextPagePath" value="Tutorial08_Forward_Result02.jsp">
		
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>