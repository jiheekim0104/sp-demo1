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
<form action="/translate">
	<div id="lDiv">
		<select name="source">
			<option value="ko" ${param.source=='ko'?'selected':'' }>한국어</option>
			<option value="en" ${param.source=='en'?'selected':'' }>영어</option>
		</select><br>
		<textarea name="text">${param.text} </textarea>
	</div>
	<div id="rDiv">
		<select name="target">
			<option value="ko" ${param.target=='ko'?'selected':'' }>한국어</option>
			<option value="en" ${param.target=='en'?'selected':'' }>영어</option>
		</select><br>
		<textarea id="result">${translatedText}</textarea>
	</div>
	<div id="cDiv">
	<button>번역</button>
	</div>
</form>
	
</body>
</html>