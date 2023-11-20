<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>アカウント新規登録完了</h1>

<p><%= request.getAttribute("registerMessage") %></p>

<a href="login">戻る</a>

</body>
</html>