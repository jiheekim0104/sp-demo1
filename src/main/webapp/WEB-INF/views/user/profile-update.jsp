<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/user/update">
		이름 :<input type="text" name="uiId" id="uiId" value="${user.uiId}"><br>
		생년월일 :<input type="text" name="uiBirth" id="uiBirth"
			value="${user.uiBirth}"><br> 전화번호 :<input type="text"
			name="uiPhone" id="uiPhone" value="${user.uiPhone}"><br>
		이메일 :<input type="text" name="uiEmail" id="uiEmail"
			value="${user.uiEmail}"><br> <input type="hidden"
			name="uiCredat" id="uiCredat" value="${user.uiCredat}"> <input
			type="hidden" name="uiCretim" id="uiCretim" value="${user.uiCretim}">
		<button>수정</button>
	</form>

</body>
</html>