<%--
  User: Martin Sevcik <422365>
  Date: 18.12.2017
  Time: 12:40
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate>
<jsp:attribute name="title"><fmt:message key="login.title"/></jsp:attribute>
<jsp:attribute name="body">


    <form method="POST" action="${pageContext.request.contextPath}/auth/login">
        <h4><fmt:message key="login.sentence" /></h4>

        <label for="email"><fmt:message key="email"/></label>
        <input id="email" type="text" name="email" placeholder="example: user@gmail.com" required class="form-control"/>

        <label for="password"><fmt:message key="login.password"/></label>
        <input id="password" type="password" name="password" placeholder="Password" required class="form-control"/>

        <button class="btn btn-lg btn-primary" type="submit" ><fmt:message key="login.button"/></button>
    </form>
<br>
<br>
<hr>
<b>For evaluation:</b>
<table class="table">
<thead>
    <tr>
        <th></th>
        <th>E-mail:</th>
        <th>Password</th>
    </tr>
    </thead>
    <tr>
    <td>USER:</td>
    <td>mark@user.com</td>
    <td>001001001</td>
    </tr>
    <tr>
    <td>ADMIN:</td>
    <td>eva@user.com</td>   
    <td>100100100</td>
    </tr>
</table>

</jsp:attribute>
</my:pagetemplate>