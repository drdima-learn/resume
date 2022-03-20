<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<jsp:useBean id="profile" scope="request" type="net.devstudy.resume.entity.Profile"/>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-briefcase"></i> Practic Experience <a class="edit-block" href="/edit/practics">Edit</a>
        </h3>
    </div>
    <div class="panel-body">
        <c:forEach items="${profile.practics}" var="practic" varStatus="loop">
            <ul class="timeline">

                <li>
                    <div class="timeline-badge danger">
                        <i class="fa fa-briefcase"></i>
                    </div>
                    <div class="timeline-panel">
                        <div class="timeline-heading">
                            <h4 class="timeline-title">${practic.position}</h4>
                            <p>
                                <small class="dates"><i class="fa fa-calendar"></i> ${practic.beginDatePretty} -
                                    <c:choose>
                                        <c:when test="${practic.finishDate == null}">
                                            <strong class="label label-danger">Current</strong>
                                        </c:when>
                                        <c:otherwise>${practic.finishDatePretty}</c:otherwise>
                                    </c:choose>
                                </small>
                            </p>
                        </div>
                        <div class="timeline-body">
                            <p>
                                <strong>Responsibilities included:</strong> ${practic.responsibilities}
                            </p>
                            <p>
                                <strong>Demo: </strong><a href="${practic.demo}">${practic.demo}</a>
                            </p>
                            <p>
                                <strong>Source code: </strong><a
                                    href="${practic.src}">${practic.src}</a>
                            </p>
                        </div>
                    </div>
                </li>
            </ul>
        </c:forEach>
    </div>
</div>