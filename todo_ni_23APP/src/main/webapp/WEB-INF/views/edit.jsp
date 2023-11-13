<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.dto.TodoRecord"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/todoEdit.css">
</head>
<body>

	<%
	TodoRecord record = (TodoRecord) request.getAttribute("record");
	%>
	
	<%
	String[] todoPriority = { "high", "normal", "low" };
	%>

	<h1>TODO編集</h1>

	<form action="todoUpdate" method="POST">
		<input type="hidden" name="id" value="<%=record.getId()%>"></input>

		<div class="todoTitleDiv">
			<label for="title" class="todoTitleLabel">タイトル</label> <br> <input
				type="text" name="title" value="<%=record.getTitle()%>">
		</div>


		<div class="todoContentDiv">
			<label for="content" class="todoContentLabel">コンテンツ</label> <br>
			<textarea name="content"><%=record.getContent()%></textarea>
		</div>

		<div class="todoDateTimeDiv">
			<span class="todoDateTimeSpan">更新日</span> <br> <span><%=record.getDateTime()%></span>
		</div>


		<div class="todoPriorityDiv">
			<span class="todoPrioritySpan">優先度</span> <br> <select name="priority">
				<%
				for (String priority : todoPriority) {
				%>
				<%
				if (priority.equals(record.getPriority())) {
				%>
				<option selected><%=priority%></option>
				<%
				} else {
				%>
				<option>
					<%=priority%></option>
				<%
				}
				%>
				<%
				}
				%> 優先度：<%=record.getPriority()%><
			</select>
		</div>
		<button type="submit" class="todoUpdate">更新する</button>
	</form>

	<a href="todoList" class="returnBtn">戻る</a>


</body>
</html>