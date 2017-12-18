<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

    <title>Редактируем инструмент</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">






    <style>
        .leftMenu {
            position: absolute;
            left: 0%;
            width: 200px;
            height:80%;
            color: black;
            font-family: "Verdana";
            padding: 15px 15px;
            font-size: 16px;
            margin: 4px 2px;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
            background-clip: border-box;
            background-size: contain;
        }
        .button {
            background-color: #555555;
            width: 190px;
            height: 60px;
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
        .tgs { position: absolute;
            position: absolute;
            left: 250px;
            height: 80%;
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
        body {  background: darkgrey;}
    </style>
</head>


<body>


<div class="leftMenu">

    <%@include file="LeftMenu.jsp"%>


</div>

<div class="tgs">
    <form action="/updated" method="post" >

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="id" value="${id}">
        <input type="text" name="manufacturer" value="${manufacturer}" >Производитель
        <br>
        <input type="text" name="label" value="${label}">Наименование
        <br>
        <input type="text" name="function" value="${function}">Функция
        <br>
        <input type="number" name="toolAmount" value="${amount}">Количество
        <br>
        <input type="text" name="comment" value="${comment}">Комментарий
        <br>
        <select  name="proLabel">
            <option value=""></option>
            <c:forEach items="${productList}" var="prod">
                <option value="${prod.proLabel}">${prod.proLabel} </option>
            </c:forEach>

        </select>изготавливаемая деталь
        <br>
        <input type="submit" class="button" value="Отредактировать">

    </form>
    <form action="/deleted/${id}" method="get">
        <input type="submit" class="button" value="Удалить инструмент">
    </form>
</div>




</body>
</html>
