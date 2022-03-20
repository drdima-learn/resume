<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Edit skills</h3>

<select name="category" class="form-control">
    <c:forEach items="${skillCategoryList}" var="skill" varStatus="loop">
        <option value="${skill.id}">${skill.category}</option>
    </c:forEach>
</select>



