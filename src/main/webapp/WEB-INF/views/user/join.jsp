<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function validation(){
	const uiName = document.querySelector('#uiName');
	if(uiName.value.trim().length<2){
		alert('이름은 2글자 이상입니다.');
		uiName.value='';
		uiName.focus();
		return false;
	}
	const uiId = document.querySelector('#uiId');
	if(uiId.value.trim().length<4){
		alert('아이디는 4글자 이상입니다.');
		uiId.value='';
		uiId.focus();
		return false;
	}
	const uiPwd = document.querySelector('#uiPwd');
	if(uiPwd.value.trim().length<4){
		alert('비밀번호는 4글자 이상입니다.');
		uiPwd.value='';
		uiPwd.focus();
		return false;
	}
	const uiPwd1 = document.querySelector('#uiPwd1');
	if(uiPwd1.value!=uiPwd.value){
		alert('비밀번호를 확인해주세요.');
		uiPwd1.value='';
		uiPwd1.focus();
		return false;
	}
	const uiBirth = document.querySelector('#uiBirth');
	if(uiBirth.value==''){
		alert('생년월일을 확인해주세요.');
		uiBirth.value='';
		uiBirth.focus();
		return false;
	}
	return true;
}
</script>
<body>
	<form action="/join" method="POST" onsubmit="return validation()">
		<h1>회원가입</h1>
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="uiName" id="uiName"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="uiId" id="uiId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="uiPwd" id="uiPwd"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="uiPwd1" id="uiPwd1"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="uiBirth" id="uiBirth"></td>
			</tr>
			<tr>
				<th>휴대전화번호</th>
				<td><input type="text" name="uiPhone" id="uiPhone"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="uiEmail" id="uiEmail"></td>
			</tr>
			<tr>
				<th colspan="2"><button>가입</button></th>
			</tr>
		</table>
	</form>
</body>
</html>