<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<jsp:useBean id="profile" scope="request" type="net.devstudy.resume.entity.jpa.Profile"/>

<div class="panel panel-primary certificates">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-certificate"></i> Certificates <a class="edit-block" href="/edit/certificates">Edit</a>
        </h3>
    </div>
    <div class="panel-body">
        <c:forEach items="${profile.certificates}" var="certificate" varStatus="loop">
            <a data-url="${certificate.largeUrl}" data-title="Jee certificate"
               href="${certificate.largeUrl}" class="thumbnail certificate-link">
                <img alt="Jee certificate" src="${certificate.smallUrl}"
                     class="img-responsive"> <span>Jee certificate</span>
            </a>
        </c:forEach>
    </div>
</div>