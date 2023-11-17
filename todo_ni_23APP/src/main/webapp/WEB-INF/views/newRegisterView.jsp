<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%String registerMessage = (String)request.getAttribute("registerMessage"); %>

<h1><%= registerMessage %></h1>

<a href="login">戻る</a>

</body>
</html>