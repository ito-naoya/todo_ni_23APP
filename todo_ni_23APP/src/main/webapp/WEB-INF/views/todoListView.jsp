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

	<%
	String userName = (String) request.getAttribute("userName");
	%>

	<%
	Integer userId = (Integer) request.getAttribute("userId");
	%>

	<%
	if (userName != null && userId != null) {
	%>

	<div class="todoList">

		<h1 class="todoHeader">
			<%=userName%>さんのとぅどぅ
		</h1>

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
					<td class="todoText"><a
						href="todoDetail?id=<%=todo.getTodoId()%>"><%=todo.getTitle()%></a></td>
					<td class="todoPriority"><%=todo.getPriority()%></td>
				</tr>

				<%
				}
				%>

			</tbody>
		</table>

		<div class="newTodo">
			<a href="todoNew"><button class="newBtn">新規登録</button></a> <a
				href="logout"><button class="logoutBtn">ログアウト</button></a>
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
	
	<%
	} else {
	%>
	
	<div class="topPage">

		<h1>ログイン画面</h1>

		<form action="login" method="post">
		
			<label for="userName">ユーザ名</label> 
			<input type="text" name="userName">
			<br> 
			<label for="password">パスワード</label>
			<input type="password" name="password">
			<br> 
			<input type="submit" value="ログイン">
				
		</form>

		<form action="register" method="get">
			<input type="submit" value="新規登録">
		</form>

	</div>
	
	<%
	}
	%>

</body>
</html>