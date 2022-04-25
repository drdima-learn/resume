<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<jsp:useBean id="profile" scope="request" type="net.devstudy.resume.entity.jpa.Profile"/>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-language"></i> Foreign languages <a class="edit-block" href="/edit/languages">Edit</a>
        </h3>
    </div>
    <c:forEach items="${profile.languages}" var="lang" varStatus="loop">
    <div class="panel-body">
        <strong>${lang.name}:</strong> ${lang.level.prettyFormat}<br>
    </div>
    </c:forEach>
</div>
