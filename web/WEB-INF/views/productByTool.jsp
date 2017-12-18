<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="Resources/js/jquery.min.js"></script>
    <script src="Resources/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
    <script src="Resources/js/imtech_pager.js"></script>
    <link href="Resources/js/jquery-ui-1.12.1.custom/jquery-ui.css" rel="stylesheet">
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
            overflow: hidden; /* Обрезаем все, что не помещается в область */
            text-overflow: ellipsis; /* Добавляем многоточие */
        }
        #content td div {
            width: 250px;
            overflow: hidden; /* Обрезаем все, что не помещается в область */
            text-overflow: ellipsis; /* Добавляем многоточие */
        }


        body {  background: darkgrey;}

    </style>


</head>
<body>

<div class="leftMenu">

    <%@include file="LeftMenu.jsp"%>

</div>

<div class="tgs">
    <table id="content" class="tg" bgcolor="#555555" style="color: white;  font-family: Verdana"   frame="border" rules="all" >
        <tr class="y" >
            <th width="40px">№</th>
            <th width="100px">Шифр</th>
            <th width="150px">Наименование</th>
        </tr>
        <% int i = 0;%>
        <c:forEach items="${productList}" var="prod">
            <tr class="z" >
                <td ><%
                    i++;
                    out.print(i);
                %></td>
                <td ><nobr>${prod.ofLabel}</nobr></td>
                <td ><nobr>${prod.proLabel}</nobr></td>
            </tr>
        </c:forEach>

    </table><br><br>

    <div id="pagingControls"></div>

    <form id="2" action="/showTool" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table style=" font-family: Verdana">

            <tr>
                <th> <input type="submit" class="button" value="выбор по марке"> </th>
                <th> <select form="2" name="proLabel">
                    <c:forEach items="${productList}" var="tool">
                        <option value="${tool.proLabel}">${tool.proLabel} </option>
                    </c:forEach>

                </select>Выберите наименование детали, чтобы увидеть необходимый для ее изготовления инструмент
                </th>



            </tr>
        </table>
    </form>

</div>

<script type="text/javascript">
    var pager = new Imtech.Pager();
    $(document).ready(function() {
        // кол-во выводимых строк на одной странице
        pager.paragraphsPerPage = 5;
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
