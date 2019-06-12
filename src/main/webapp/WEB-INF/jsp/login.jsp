<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Artifacts</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Artifacts</h1>
            <p>Add artifacts</p>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Log in</h3>
                </div>
                <div class="panel-body">
                    <%--an JSTL marker that checks if model's attribute named 'error' has any value--%>
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">
                            <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
                        </div>
                    </c:if>
                        <%--Spring Security module expects j_username nd j_password fields to authenticate user, the form is send to SSecurity methos available under provided url address--%>
                    <form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="User name" name='j_username' type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name='j_password'  type="password" value="">
                            </div>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Log in">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
