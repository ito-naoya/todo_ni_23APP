<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Todo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>とぅどぅ</title>
<link rel="stylesheet" href="./css/list.css">
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
					<td class="todoText"><a href="detail?id=<%=todo.getId()%>"><%=todo.getTitle()%></a></td>
					<td class="todoPriority"><%=todo.getPriority()%></td>
				</tr>

				<%
				}
				%>

			</tbody>
		</table>

		<div class="todoOption">
			<a href="new"><button class="todoNew">新規登録</button></a>
		</div>

		<div class="sortOption">
			<form action="list" method="GET">
				<button type="submit" class="sortBtn" value="asc">古い日付順に並べ替え</button>
				<input type="hidden" value="asc" name="sortParam">
			</form>

			<form action="list" method="GET">
				<button type="submit" class="sortBtn" value="desc">新しい日付順に並べ替え</button>
				<input type="hidden" value="desc" name="sortParam">
			</form>

			<form action="list" method="GET">
				<button type="submit" class="sortBtn" value="high">Highのみ表示</button>
				<input type="hidden" value="high" name="sortParam">
			</form>

			<form action="list" method="GET">
				<button type="submit" class="sortBtn" value="normal">normalのみ表示</button>
				<input type="hidden" value="normal" name="sortParam">
			</form>

			<form action="list" method="GET">
				<button type="submit" class="sortBtn" value="low">lowのみ表示</button>
				<input type="hidden" value="low" name="sortParam">
			</form>

			<form action="list" method="GET">
				<button type="submit" class="sortBtn" value="all">全て表示</button>
				<input type="hidden" value="all" name="sortParam">
			</form>
		</div>

	</div>



</body>
</html>