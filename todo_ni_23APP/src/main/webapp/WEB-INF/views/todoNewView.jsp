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

	<h1>TODO新規作成</h1>

	<form action="todoCreate" method="post">

		<div class="todoTitleDiv">
			<label for="title" class="todoTitleLabel">タイトル</label> <br> <input
				type="text" name="title">
		</div>

		<div class="todoContentDiv">
			<label for="content" class="todoContentLabel">コンテンツ</label> <br>
			<textarea name="content"></textarea>
		</div>

		<div class="todoPriorityDiv">
			<span class="todoPrioritySpan">優先度</span> <br> <select
				name="priority">
				<option>high</option>
				<option selected>normal</option>
				<option>low</option>
			</select>
		</div>

		<button type="submit" class="todoUpdate">追加する</button>

	</form>

	<a href="todoList" class="returnBtn">戻る</a>

</body>
</html>