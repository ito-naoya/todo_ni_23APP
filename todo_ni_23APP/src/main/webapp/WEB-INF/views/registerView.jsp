<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<body>
	<h1>新規登録画面</h1>

	<form action="register" method="post">
	
		<label for="userName">ユーザー名</label> 
		<input name="userName" type="text">
		<br>
		
		<label for="password">パスワード</label> 
		<input name="password" type="password">
		<br>
		
		<input type="submit" value="新規登録">
	</form>
</body>
</html>