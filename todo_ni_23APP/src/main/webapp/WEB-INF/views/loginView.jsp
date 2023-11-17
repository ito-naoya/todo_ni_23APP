<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="./css/topPage.css"
</head>
<body>

	<div class="topPage">

		<form action="login" method="post">
			<label for="userName">ユーザ名</label> <input type="text" name="userName">
			<br> <label for="password">パスワード</label> <input type="password"
				　name="password"><br> <input type="submit" value="ログイン">
		</form>

		<form action="register" method="get">
			<input type="submit" value="新規登録">
		</form>


	</div>

</body>
</html>