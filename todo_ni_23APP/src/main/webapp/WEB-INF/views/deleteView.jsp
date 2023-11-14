<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Todo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/delete.css">
</head>
<body>

	<h1>削除完了</h1>

	<p><%=request.getAttribute("deleteMessage")%>
	</p>

	<a href="list">戻る</a>

</body>
</html>