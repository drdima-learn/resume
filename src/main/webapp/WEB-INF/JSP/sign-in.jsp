<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-info small-center-block">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-sign-in"></i> Вход в Ваш личный кабинет
        </h3>
    </div>
    <div class="panel-body">
        <form action="/sign-in-handler" method="post">
            <c:if test="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION != null}">
                <div class="alert alert-danger" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                        ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
                    <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
                </div>
            </c:if>
            <div class="help-desk">Вы можете использовать Ваши UID или Email или Phone в качестве логина</div>
            <div class="form-group">
                <label for="uid">Логин</label>
                <input id="uid" name="uid" class="form-control" required autofocus
                       placeholder="UID или Email или Phone">
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <input id="password" type="password" name="password" class="form-control" placeholder="Password">
            </div>
            <div class="form-group">
                <label>
                    <input type="checkbox" name="remember-me" value="true"> Запомнить меня
                </label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary pull-left">Войти</button>
                <a href="#" class="pull-right">Восстановить доступ</a>
            </div>
            <div class="form-group text-center">
                <a href="/fbLogin" class="btn btn-warning">Войти через Facebook</a>
            </div>
        </form>
    </div>
</div>
