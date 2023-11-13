<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.dto.TodoRecord"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/todoDetail.css">
</head>
<body>

	<div class="detailDiv">

		<%
		TodoRecord record = (TodoRecord) request.getAttribute("record");
		%>

		<h1>TODO詳細</h1>

		<ul cass="todoUl">
			<li class="todoTitle"><%=record.getTitle()%></li>
			<li class="todoContent"><%=record.getContent()%></li>
			<li class="todoDateTIme"><%=record.getDateTime()%></li>
			<li class="todoPriority"><%=record.getPriority()%></li>
		</ul>

		<a href="todoEdit?id=<%=record.getId()%>">編集</a> <a href="todoList">戻る</a>
		<a href="todoDelete?id=<%=record.getId()%>"><button
				class="todoDelete">削除</button></a>

	</div>

</body>
</html>