<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
href = "http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav class = "navber navber-expand navber-dark bg-dark">
<div class = "container">
<div class = "navber-header">
<a class = "navber-brand" href="./welcome.jsp">Home</a>
</div>
</div>
</nav>
<%! String greeting = "Welcome to web Shopping Mall";
String tagline = "Welcome to Web Market!";%>
<div class = "jumbotron">
<div class = "container">
<h1 cladd = "display-3">
<%= greeting %>
</h1>
</div>
</div>
<main role = "main">
<div class = "container">
<div class = "text-center">
<h3>
<%= tagline %>
</h3>
</div>
<hr>
</div>
<footer class = "container">
<p>&copy;WebMarket</p>
</footer>
</body>
</html>