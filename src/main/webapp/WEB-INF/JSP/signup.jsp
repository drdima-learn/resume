<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="signUpForm" type="net.devstudy.resume.form.SignUpForm"--%>
<form:form action="/signup" method="post" modelAttribute="signUpForm">

    firstName <input type="text" name="firstName"><br>
    <div class="row skill-delim">
        <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
            <form:errors path="firstName" cssClass="alert alert-danger" element="div"/>
        </div>
    </div>


    lastName <input type="text" name="lastName"><br>
    <div class="row skill-delim">
        <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
            <form:errors path="lastName" cssClass="alert alert-danger" element="div"/>
        </div>
    </div>

    password <input type="password" name="password"><br>
    <div class="row skill-delim">
        <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
            <form:errors path="password" cssClass="alert alert-danger" element="div"/>
        </div>
    </div>

    confirmPassword <input type="password" name="confirmPassword"><br>
    <div class="row skill-delim">
        <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
            <form:errors path="confirmPassword" cssClass="alert alert-danger" element="div"/>
        </div>
    </div>

    <input type="submit" class="btn btn-primary" value="Сохранить"><br>

    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="row skill-delim">
        <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
            <form:errors path="" cssClass="alert alert-danger" element="div"/>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <h1>-----------</h1>
    ${signUpForm}
    <h1>-----------</h1>
    ${errors}

</form:form>