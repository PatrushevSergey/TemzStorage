<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

    <title>Все заказы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="Resources/js/imtech_pager.js"></script>
    <script src="Resources/js/jquery.min.js"></script>
    <script src="Resources/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
    <link href="Resources/js/jquery-ui-1.12.1.custom/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="Resources/main.css" rel="stylesheet">





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
    <table  id="content" class="tg" bgcolor="#555555" style="color: white; font-family: Verdana"  frame="border" rules="all" >
        <tr class="y" >
            <th width="100px">Производитель</th>
            <th>Наименование</th>
            <th width="50px">Кол-во</th>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <tr class="z">
                <td >${order.manufacturer}</td>
                <td > ${order.toolLabel}</td>
                <td >${order.amount}</td>
            </tr>
        </c:forEach>

    </table>
    <br><br>
    <div id="pagingControls"></div>
    <br><br>
    <form id="1" action="/orderByDate" method="post">
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
                    </select> Выберите месяц и год, за который нужно отобразить заказы
                </th>

            </tr>
        </table>
    </form>
    <form id="2" action="/orderByUser" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table style=" font-family: Verdana">

            <tr>
                <th> <input type="submit" class="button" value="выбор по юзеру"> </th>
                <th> <select form="2" name="login">
                    <c:forEach items="${userList}" var="user">
                        <option value="${user.login}">${user.name} </option>
                    </c:forEach>

                </select>Выберите пользователя, чьи заказы хотите увидеть
                </th>



            </tr>
        </table>
    </form>

</div>

<script>
    var availableTags = [
        <c:forEach items="${toolList}" var="tool">
        "${tool.manufacturer}",
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
<script>
    var availableTags = [
        "5",
        "10",
        "15",
        "20",
        "30",
        "40"
    ];
    $('#num').autocomplete({source: availableTags});
</script>
<script type="text/javascript">
    var pager = new Imtech.Pager();
    $(document).ready(function() {
        // кол-во выводимых строк на одной странице
        pager.paragraphsPerPage = 10;
        // основной контейнер
        pager.pagingContainer = $('#content');
        // обозначаем требуемый блок ('div.z')
        pager.paragraphs = $('tr.z', pager.pagingContainer);
        pager.top = $('tr.y', pager.pagingContainer);
        pager.showPage(1);
    });
</script>



</body>
</html>
