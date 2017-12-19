<%--
  User: Martin Sevcik <422365>
  Date: 18.12.2017
  Time: 13:15
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${user != null}">
    <my:pagetemplate>
        <jsp:attribute name="title">
            <fmt:message key="user.view.title"/> <c:out value="${user.name} ${user.surname}" />
        </jsp:attribute>
        <jsp:attribute name="body">
            <div class="row">
                <div class="col-md-6 col-lg-9">
                    <table class="table">
                        <caption><c:out value="${user.name} ${user.surname}"/></caption>
                        <thead>
                            <tr>
                                <th><fmt:message key="id"/></th>
                                <th><fmt:message key="name"/></th>
                                <th><fmt:message key="surname"/></th>
                                <th><fmt:message key="user.view.phoneNumber"/></th>
                                <th><fmt:message key="idCard"/></th>
                                <th><fmt:message key="emailSimple"/></th>
                                <th><fmt:message key="user.view.birthDate"/></th>
                                <th><fmt:message key="edit"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <c:out value="${user.id}"/>
                                </td>
                                <td>
                                    <c:out value="${user.name}"/>
                                </td>
                                <td>
                                    <c:out value="${user.surname}"/>
                                </td>
                                <td>
                                    <c:out value="${user.phoneNumber}"/>
                                </td>
                                <td>
                                    <c:out value="${user.idCardNumber}"/>
                                </td>
                                <td>
                                    <c:out value="${user.email}"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${user.birthDate}" pattern="dd.MM.yyyy" />
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/user/edit/${user.id}" class="btn btn-primary"><fmt:message key="edit"/></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                </div>

            <div class="row">
                <h2><fmt:message key="reservations" /></h2>
                <div class="col-md-6 col-lg-9">
                    <table class="table">
                        <thead>
                            <tr>
                                <th><fmt:message key="id" /></th>
                                <th><fmt:message key="trip.name" /></th>
                                <th><fmt:message key="user.list.detail"/></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="reservation" items="${user.reservations}">
                            <tr>
                                <td><c:out value="${reservation.id}" /></td>
                                <td><c:out value="${reservation.trip.name}" /></td>
                                <td><a href="${pageContext.request.contextPath}/reservation/detail/${reservation.id}"><fmt:message key="view"/></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </jsp:attribute>
    </my:pagetemplate>
</c:if>

<c:if test="${user == null}">
    <my:pagetemplate>
        <jsp:attribute name="title">
            <fmt:message key="noFound"/>
        </jsp:attribute>
        <jsp:attribute name="body">

        </jsp:attribute>
    </my:pagetemplate>
</c:if>