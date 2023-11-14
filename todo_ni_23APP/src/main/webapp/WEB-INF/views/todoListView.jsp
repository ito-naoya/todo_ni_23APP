<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Todo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/todoList.css">
</head>
<body>

	<div class="todoList">

		<h1 class="todoHeader">とぅどぅ</h1>

		<%
		ArrayList<Todo> todoList = (ArrayList<Todo>) request.getAttribute("todoList");
		%>

		<table class="todoTable">
			<thead>
				<tr>
					<th><h2>date</h2></th>
					<th><h2>text</h2></th>
					<th><h2>priority</h2></th>
				</tr>
			</thead>
			<tbody>

				<%
				for (Todo todo : todoList) {
				%>

				<tr>
					<td class="todoDateTime"><%=todo.getDateTime()%></td>
					<td class="todoText"><a href="todoDetail?id=<%=todo.getId()%>"><%=todo.getTitle()%></a></td>
					<td class="todoPriority"><%=todo.getPriority()%></td>
				</tr>

				<%
				}
				%>

			</tbody>
		</table>

		<div class="newTodo">
			<a href="todoNew"><button class="newBtn">新規登録</button></a>
		</div>

		<%
		Map<String, String> sortMap = new LinkedHashMap<String, String>() {
			{
				put("asc", "古い日付順に並べ替え");
				put("desc", "新しい日付順に並べ替え");
				put("all", "登録順に並べ替え");
				put("high", "highのみ表示");
				put("normal", "normalのみ表示");
				put("low", "lowのみ表示");
			}
		};
		%>

		<div class="sortOption">
			<%
			for (Map.Entry<String, String> entry : sortMap.entrySet()) {
			%>
			<form action="todoList" method="GET">
				<button type="submit" class="sortBtn"><%=entry.getValue()%></button>
				<input type="hidden" value="<%=entry.getKey()%>" name="sort">
			</form>
			<%
			}
			%>
		</div>
	</div>

</body>
</html>