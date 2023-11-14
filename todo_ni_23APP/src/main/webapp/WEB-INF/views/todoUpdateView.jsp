<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Todo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/todoUpdate.css">
</head>
<body>

	<h1>更新完了</h1>

	<p><%=request.getAttribute("updateMessage")%>
	</p>

	<a href="todoList">戻る</a>

</body>
</html>