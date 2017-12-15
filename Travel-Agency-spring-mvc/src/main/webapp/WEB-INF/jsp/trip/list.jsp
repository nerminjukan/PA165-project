<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Trips">
<jsp:attribute name="body">

    <my:a href="/trip/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        New trip
    </my:a>

    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>from</th>
            <th>to</th>
            <th>destination</th>
            <th>spots</th>
            <th>price</th>
            <th>excursions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${trips}" var="trip">
            <tr>
                <td>${trip.id}</td>
                <td><c:out value="${product.name}"/></td>
                <td><fmt:formatDate value="${trip.dateFrom}" pattern="yyyy-MM-dd"/></td>
                <td><fmt:formatDate value="${trip.dateTo}" pattern="yyyy-MM-dd"/></td>
                <td><c:out value="${product.destination}"/></td>
                <td><c:out value="${product.spots}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.excursions.size}"/></td>
                <td>
                    <my:a href="/trip/view/${trip.id}" class="btn btn-primary">View</my:a>
                </td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/trip/delete/${trip.id}">
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</jsp:attribute>
</my:pagetemplate>