<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Edit skills

<c:forEach items="${skillCategoryList}" var="skill" varStatus="loop">
${skill.id} ${skill.category}<br>
</c:forEach>