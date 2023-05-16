<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${user.uiId}<br>
생년월일 : ${user.uiBirth}<br>
전화번호 : ${user.uiPhone}<br>
이메일 : ${user.uiEmail}<br>
<button onclick="location.href='/profile-update'">정보수정</button>
<button onclick="location.href='/profile-delete'">회원탈퇴</button>
</body>
</html>