<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Todo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/todoCreate.css">
</head>
<body>

	<h1>新規登録完了</h1>

	<p><%=request.getAttribute("createMessage")%></p>

	<a href="todoList" >戻る</a>

</body>
</html>