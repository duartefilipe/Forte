<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/Login/css/login.css'/>">
    <title>ForteSecurity - Faça seu login</title>

    <%--<script src="<c:url value='/resources/Login/css/login.css'/>"></script>--%>

</head>

<body>

<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>Forte<span>Security</span></div>
</div>
<br>
<div class="login">
    <form action="login" method="post">
        <input type="text" placeholder="Email" name="email"><br>
        <input type="password" placeholder="Senha" name="senha"><br>
        <button type="submit" class="btn btn-app">Login</button>
    </form>

</div>

<script src="<c:url value='/resources/Login/js/login.min.js'/>"></script>

</body>

</html>