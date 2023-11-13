<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.dto.TodoRecord"%>
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
		ArrayList<TodoRecord> todoRecordList = (ArrayList<TodoRecord>) request.getAttribute("todoRecordList");
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
				for (TodoRecord record : todoRecordList) {
				%>

				<tr>
					<td class="todoDateTime"><%=record.getDateTime()%></td>
					<td class="todoText"><a
						href="todoDetail?id=<%=record.getId()%>"><%=record.getTitle()%></a></td>
					<td class="todoPriority"><%=record.getPriority()%></td>
				</tr>

				<%
				}
				%>

			</tbody>
		</table>

		<div class="todoOption">
			<a href="todoNew"><button class="todoNew">新規登録</button></a>
		</div>

		<div class="sortOption">
			<form action="dateTimeAscList" method="GET">
				<button class="sortBtn">古い日付順に並べ替え</button>
			</form>

			<form action="dateTimeDescList" method="GET">
				<button class="sortBtn">新しい日付順に並べ替え</button>
			</form>

			<form action="sortHighTodoList" method="GET">
				<button class="sortBtn">Highのみ表示</button>
			</form>

			<form action="sortNormalTodoList" method="GET">
				<button class="sortBtn">normalのみ表示</button>
			</form>

			<form action="sortLowTodoList" method="GET">
				<button class="sortBtn">lowのみ表示</button>
			</form>

			<form action="todoList" method="GET">
				<button class="sortBtn">全て表示</button>
			</form>
		</div>

	</div>



</body>
</html>