<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<jsp:useBean id="profile" scope="request" type="net.devstudy.resume.entity.Profile"/>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-graduation-cap"></i> Education <a class="edit-block" href="/edit/education">Edit</a>
        </h3>
    </div>
    <div class="panel-body">
        <c:forEach items="${profile.educations}" var="education" varStatus="loop">
            <ul class="timeline">
                <li>
                    <div class="timeline-badge warning">
                        <i class="fa fa-graduation-cap"></i>
                    </div>
                    <div class="timeline-panel">
                        <div class="timeline-heading">
                            <h4 class="timeline-title">${education.summary}</h4>
                            <p>
                                <small class="dates"><i class="fa fa-calendar"></i>
                                        ${education.beginYear} -
                                    <c:choose>
                                        <c:when test="${education.finishYear == null}">
                                            <strong class="label label-danger">Current</strong>
                                        </c:when>
                                        <c:otherwise>${education.finishYear}</c:otherwise>
                                    </c:choose>
                                </small>
                            </p>
                        </div>
                        <div class="timeline-body">
                            <p>${education.faculty}, ${education.university}</p>
                        </div>
                    </div>
                </li>
            </ul>
        </c:forEach>
    </div>
</div>