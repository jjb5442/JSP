<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(){
		var form_Score = document.form_Score;
		var score = form_Score.score.value;
		
		if(score < 0 || score > 100)
			alert("잘못된 점수입니다.");
		else
			form_Score.submit();
	}
</script>
</head>
<body>
	<h1>점수 입력 페이지</h1>
	<form name="form_Score" action="Quiz_ScoreResult.jsp" method="get">
		<p><b>이름 : </b>
		<input type="text" name="name" required autofocus><br/></p>
		<p><b>점수 : </b>
		<input type="number" name="score" required><br/></p>
		<input type="button" onclick="validate()" value="입력">
	</form>
</body>
</html>