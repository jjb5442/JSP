<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <script type="text/javascript">
function validate(){
	var form_register = document.form_register;
	var password = form_register.password.value;
	var password_compare = form_register.passwordcm.value;
	if(password != password_compare)
		alert("비밀번호가 일치하지 않습니다.");
}
</script>
<b>아이디 : </b>
<input type="text" 		name="id" 			required><br/><br/>
<b>비밀번호 : </b>
<input type="password" 	name="password" 	required><br/><br/>
<b>비밀번호 확인 : </b>
<input type="password" 	name="passwordcm" 	required><br/><br/>

<b>관심 언어 : </b>
<input type="checkbox" name="language" value="C++">C&nbsp;&nbsp;&nbsp;
<input type="checkbox" name="language" value="Java">Java&nbsp;&nbsp;&nbsp;
<input type="checkbox" name="language" value="Swift">Swift&nbsp;&nbsp;&nbsp;
<input type="checkbox" name="language" value="Python">Python&nbsp;&nbsp;&nbsp;
<input type="checkbox" name="language" value="Kotlin">Kotlin&nbsp;&nbsp;&nbsp;
<br/><br/>

<b>성별 : </b>
<input type="radio" name="gender" value="man" checked>남자
<input type="radio" name="gender" value="woman">여자
<br/><br/>

<b>직종</b>	
<select name="job">
	<option value="Game">게임프로그래머</option>
	<option value="Web">웹프로그래머</option>
	<option value="Android">안드로이드프로그래머</option>
	<option value="IOS">IOS프로그래머</option>
</select>
<br/><br/>
<input type="button" onclick="validate()" value="회원가입">&nbsp;&nbsp;&nbsp;
<input type="reset" value="초기화">&nbsp;&nbsp;&nbsp;