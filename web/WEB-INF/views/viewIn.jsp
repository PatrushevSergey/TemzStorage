<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

    <title>Приход инструмента:</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="Resources/js/jquery.min.js"></script>
    <script src="Resources/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
    <link href="Resources/js/jquery-ui-1.12.1.custom/jquery-ui.css" rel="stylesheet" type="text/css">





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
    <form action="/main" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button">Главная</button>
    </form>
    <form action="/viewProduct" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button">Показать детали</button>
    </form>
    <form action="/createOrder" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button">Новый заказ</button>
    </form>
    <form action="/viewOrder" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button">Показать заказы</button>
    </form>


    <form action="/createTool" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button">Новый инструмент</button>
    </form>
    <form action="/createIn" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button">Приход</button>
    </form>
    <form action="/createOut" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button">Расход</button>
    </form>

    <form action=/logout method="post">
        <button type="submit"  class="button" value="Выход" >Выход</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


</div>
<div class="tgs">
    <table  class="tg" bgcolor="#555555" style="color: white; font-family: Verdana"  frame="border" rules="all" >
        <tr  >
            <th width="200px">Производитель</th>
            <th width="200px">Наименование</th>
            <th width="200px">Количество</th>
        </tr>
        <c:forEach items="${inList}" var="in">
            <tr>
                <td >${in.tool.manufacturer}</td>
                <td > ${in.tool.label}</td>
                <td >${in.toolAmount}</td>
            </tr>
        </c:forEach>

    </table>
    <form action="/addedToolIn" method="get" >

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table id="content" class="tg" bgcolor="#555555" style="color: white; font-family: Verdana"  frame="border" rules="all" >
            <tr>
                <th width="200px">Производитель</th>
                <th width="200px">Наименование</th>
                <th width="200px">Количество</th>
            </tr>
            <tr>
                <td><input id="manuf" title="auto" name="manufacturer" type="text"/></td>
                <td><input id="label" title="auto" name="label" type="text" required/></td>
                <td><input id="num" title="auto" name="toolAmount" type="number" required/></td>
            </tr>
        </table>
        <c:if test= "${isError}">
            <font size= "2" color= "red"><b>Что-то пошло не так! Попробуйте еще раз :)</b></font>
        </c:if>
        <p>Поле "Производитель" необязательно для заполнения;</p>
        <p>начните вводить наименование инструмента и выберите подходящее из выпадающего списка</p>
        <table style=" font-family: Verdana">
            <tr>
                <th> <button type="submit" class="button"> + </button> </th>
                <th> <p>Нажмите "+" для добавления информации о приходе инструмента</p> </th>
            </tr>
        </table>
    </form>

    <form action="/main" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="button"> Сохранить приход</button> <b>Вернет вас на главную страницу приложения</b>
    </form>
    <form id="1" action="/inByDate" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table style=" font-family: Verdana">

            <tr>
                <th> <input type="submit" class="button" value="выбор по дате"> </th>
                <th> <select form="1" name="month">
                    <option value="00">январь </option>
                    <option value="01">февраль </option>
                    <option value="02">март </option>
                    <option value="03">апрель </option>
                    <option value="04">май </option>
                    <option value="05">июнь </option>
                    <option value="06">июль </option>
                    <option value="07">август </option>
                    <option value="08">сентябрь </option>
                    <option value="09">октябрь </option>
                    <option value="10">ноябрь </option>
                    <option value="11">декабрь </option>
                </select></th>
                <th>
                    <select form="1" name="year">
                        <option  value="2017">2017</option>
                        <option  value="2018">2018</option>
                        <option  value="2019">2019</option>
                        <option  value="2020">2020</option>
                        <option  value="2021">2021</option>
                        <option  value="2022">2022</option>
                        <option  value="2023">2023</option>
                    </select> Выберите месяц и год, за который нужно отобразить приход инструмента
                </th>

            </tr>
        </table>
    </form>
    <form id="2" action="/inByLabel" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table style=" font-family: Verdana">

            <tr>
                <th> <input type="submit" class="button" value="выбор по марке"> </th>
                <th> <select form="2" name="label">
                    <c:forEach items="${toolList}" var="tool">
                        <option value="${tool.label}">${tool.label} </option>
                    </c:forEach>

                </select>Выберите наименование инструмента, приход по которому хотите увидеть
                </th>



            </tr>
        </table>
    </form>


</div>
<script>
    var availableTags = [
        <c:forEach items="${StringList}" var="tool">
        "${tool}",
        </c:forEach>
        "SAU"
    ];
    $('#manuf').autocomplete({source: availableTags});
</script>
<script>
    var availableTags = [
        <c:forEach items="${toolList}" var="tool">
        "${tool.label}",
        </c:forEach>
        "CCGT 060202 .Z57"
    ];
    $('#label').autocomplete({source: availableTags});
</script>




</body>
</html>