

    <%@ page pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page session="false"%>
    <html>
    <head>

        <title>Ошибка</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <META HTTP-EQUIV=REFRESH CONTENT="2; URL=/main">





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

    <p>Что-то пошло не так... Подождите, сейчас Вас вернет на главную...</p>

</div>
<br><br>






</body>
</html>
