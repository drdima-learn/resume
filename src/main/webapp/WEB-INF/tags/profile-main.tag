<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<jsp:useBean id="profile" scope="request" type="net.devstudy.resume.entity.Profile"/>

<div class="panel panel-primary">
    <a href="/edit"><img class="img-responsive photo" src="${profile.largePhoto}" alt="photo"></a>
    <h1 class="text-center">
        <a style="color: black;" href="/edit">${profile.fullName}</a>
    </h1>
    <h6 class="text-center">
        <strong>${profile.country}, ${profile.city}</strong>
    </h6>
    <h6 class="text-center">
        <strong>Age:</strong> ${profile.age}, <strong>Birthday: </strong> ${profile.birthDateFormatted}
    </h6>
    <div class="list-group contacts">
        <a class="list-group-item" href="tel:${profile.phone}"><i class="fa fa-phone"></i> ${profile.phone}</a>
        <a class="list-group-item" href="mailto:${profile.email}"><i class="fa fa-envelope"></i> ${profile.email}</a>
        <c:if test="${profile.contacts.skype != null }">
            <a class="list-group-item" href="javascript:void(0);">
                <i class="fa fa-skype"></i>${profile.contacts.skype}
            </a>
        </c:if>

        <c:if test="${profile.contacts.vkontakte != null }">
            <a target="_blank" class="list-group-item" href="${profile.contacts.vkontakte}">
                <i class="fa fa-vk"></i>
                    ${profile.contacts.vkontaktes}
            </a>
        </c:if>

        <c:if test="${profile.contacts.facebook != null }">
            <a target="_blank" class="list-group-item" href="${profile.contacts.facebook}">
                <i class="fa fa-facebook"></i>
                    ${profile.contacts.facebook}
            </a>
        </c:if>

        <c:if test="${profile.contacts.linkedin != null }">
            <a target="_blank" class="list-group-item" href="${profile.contacts.linkedin}">
                <i class="fa fa-linkedin"></i>
                    ${profile.contacts.linkedin}
            </a>
        </c:if>

        <c:if test="${profile.contacts.github != null }">
            <a target="_blank" class="list-group-item" href="${profile.contacts.github}">
                <i class="fa fa-github"></i>
                    ${profile.contacts.github}
            </a>
        </c:if>

        <c:if test="${profile.contacts.stackoverflow != null }">
            <a target="_blank" class="list-group-item" href="${profile.contacts.stackoverflow}">
                <i class="fa fa-stack-overflow"></i>
                    ${profile.contacts.stackoverflow}
            </a>
        </c:if>
    </div>
</div>