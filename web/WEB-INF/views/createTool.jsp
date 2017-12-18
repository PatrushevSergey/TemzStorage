<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

    <title>Новый инструмент</title>
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
    <form action="/added" method="post" >

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="text" name="manufacturer"  >Производитель (можно не указывать, если неизвестен)
        <br>
        <input type="text" name="label">Наименование ( тут можно указать в свободной форме, например "Фреза D10")
        <br>
        <input type="text" name="function">Функция (необязательно для заполнения)
        <br>
        <input type="number" name="toolAmount" value="0">Количество (указываем количество инструмента в наличии, заказ в пункте "Новый заказ"
        <br>
        <input type="text" name="comment" a>Комментарий (необязательно для заполнения)
        <br>
        <select  name="proLabel">
            <option value=""></option>
            <c:forEach items="${productList}" var="prod">
                <option value="${prod.proLabel}">${prod.proLabel} </option>
            </c:forEach>

        </select>изготавливаемая деталь (выберите одну или ни одной, остальные можно добавить в режиме редактирования)
        <br>
        <input type="submit" class="button" value="Создать">

    </form>
</div>
<br><br>






</body>
</html>
