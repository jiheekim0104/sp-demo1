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
<script>
	let str = '{"name":"test", "age":10}';
	let obj = JSON.parse(str);
	alert(obj.name);
	alert(obj.age);
	
	let objStr = JSON.stringify(obj);
	alert(objStr);
	
</script>
</body>
</html>