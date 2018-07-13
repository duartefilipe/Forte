<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/Login/css/login.css'/>">
    <title>ForteSecurity - Faça seu login</title>

    <script src="<c:url value='/resources/Login/css/login.css'/>"></script>

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
        <input type="text" placeholder="Email" name="email" value="filipeduarte.si@gmail.com"><br>
        <input type="password" placeholder="Senha" name="senha" value="1234" ><br>
        <button type="submit" class="btn btn-app">Login</button>
    </form>

</div>

<script src="<c:url value='/resources/Login/js/login.min.js'/>"></script>

</body>

</html>