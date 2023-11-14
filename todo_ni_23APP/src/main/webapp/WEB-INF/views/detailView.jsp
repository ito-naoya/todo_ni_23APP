<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Todo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/detail.css">
</head>
<body>

	<div class="detailDiv">

		<%
		Todo todo = (Todo) request.getAttribute("todo");
		%>

		<h1>TODO詳細</h1>

		<ul cass="todoUl">
			<li class="todoTitle"><%=todo.getTitle()%></li>
			<li class="todoContent"><%=todo.getContent()%></li>
			<li class="todoDateTIme"><%=todo.getDateTime()%></li>
			<li class="todoPriority"><%=todo.getPriority()%></li>
		</ul>

		<a href="edit?id=<%=todo.getId()%>">編集</a> <a href="list">戻る</a> <a
			href="delete?id=<%=todo.getId()%>"><button class="deleteBtn">削除</button></a>

	</div>

</body>
</html>