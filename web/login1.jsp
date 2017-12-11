<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 15.08.2017
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Тюменский электромеханический завод</title>
    <style>
        .div1 {
            position: absolute; left: 40%; top: 10%;
            width: 300px;
            color: black;
            font-family: "Verdana";
            padding: 15px 15px;
            font-size: 16px;
            margin: 4px 2px;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
            background-clip: border-box;
            background-color: darkgrey;
            background-size: contain;
        }
        body {  background: url("Resources/index.jpg")}
        .button {
            background-color: #555555;
            border: none;
            border-radius: 4px;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body background="index.jpg"  bgcolor="#a9a9a9">




<div  class="div1" >
    <h2 align="center" >Добро пожаловать!</h2>

    <form name='f' action='/login' method='POST'>
        <input type='text' name='username' value='' > login
        <br>
        <input type='password' name='password'> password
        <br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit"  class="button" value="Login" align="center">
        <input type="checkbox"  name="_spring_security_remember_me" value="remember me">
    </form>
    <h2 style="color: crimson">Incorrect login/password</h2>
</div>




</body>
</html>
