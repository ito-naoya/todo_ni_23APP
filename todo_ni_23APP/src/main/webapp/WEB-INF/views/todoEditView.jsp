<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Todo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/todoEdit.css">
</head>
<body>

	<%
	Todo todo = (Todo) request.getAttribute("todo");
	%>

	<%
	String[] todoPriority = { "high", "normal", "low" };
	%>

	<h1>TODO編集</h1>

	<form action="todoUpdate" method="POST">
		<input type="hidden" name="id" value="<%=todo.getId()%>"></input>

		<div class="todoTitleDiv">
			<label for="title" class="todoTitleLabel">タイトル</label> <br> <input
				type="text" name="title" value="<%=todo.getTitle()%>">
		</div>


		<div class="todoContentDiv">
			<label for="content" class="todoContentLabel">コンテンツ</label> <br>
			<textarea name="content"><%=todo.getContent()%></textarea>
		</div>

		<div class="todoDateTimeDiv">
			<span class="todoDateTimeSpan">最終更新日</span> <br> <span><%=todo.getDateTime()%></span>
		</div>


		<div class="todoPriorityDiv">
			<span class="todoPrioritySpan">優先度</span> <br> <select
				name="priority">

				<%
				for (String priority : todoPriority) {
				%>

				<%
				if (priority.equals(todo.getPriority())) {
				%>

				<option selected><%=priority%></option>

				<%
				} else {
				%>

				<option><%=priority%></option>

				<%
				}
				%>

				<%
				}
				%>

				<p>
					優先度：<%=todo.getPriority()%>
				</p>
				
			</select>
		</div>
		<button type="submit" class="todoUpdate">更新する</button>
	</form>

	<a href="todoList" class="returnBtn">戻る</a>


</body>
</html>