<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

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


