<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
<link rel="stylesheet" href="./css/register.css">
</head>
<body>
	<div class="registerPage">
	
	<h1>新規登録画面</h1>

	<form action="register" method="post">
	
		<label for="userName">ユーザー名</label> 
		<input name="userName" type="text" required>
		<br>
		
		<label for="password">パスワード</label> 
		<input name="password" type="password" required>
		<br>
		
		<input type="submit" value="新規登録" class="registerBtn">
	</form>
	<a href="login">戻る</a>
	</div>
</body>
</html>