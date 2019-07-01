<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Add artifacts</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="addArtifact.header.artifacts.label" /></h1>
            <p><spring:message code="addArtifact.header.addNewArtifact.label" /></p>
            <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Log out</a>
            <div class="pull-right" style="padding-right: 50px">
                <a href="?language=en">
                    <spring:message code="common.language.EN.label" />
                </a> | <a href="?language=pl">
                <spring:message code="common.language.PL.label" />
            </a>
            </div>
        </div>
    </div>
</section>
<section class="container">
    <form:form  modelAttribute="newArtifact" class="form-horizontal" enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div" />
        <fieldset>
            <legend><spring:message code="addArtifact.header.addNewArtifact.label" /> </legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="artifactId">
                    <spring:message code="addArtifact.form.artifactId.label"/>
                </label>
                <div class="col-lg-10" class="form-group">
                    <form:input id="artifactId" path="artifactId" type="text" class="form:input-large"/>
                    <form:errors path="artifactId" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="name">
                    <spring:message code="addArtifact.form.name.label"/>
                </label>
                <div class="col-lg-10" >
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="price">
                    <spring:message code="addArtifact.form.price.label"/>
                </label>
                <div class="col-lg-10">
                    <div class="form:input-prepend">
                        <form:input id="unitPrice" path="price" type="text" class="form:input-large"/>
                        <form:errors path="price" cssClass="text-danger"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="addArtifact.form.description.label" />
                </label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows = "2"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="category">
                    <spring:message code="addArtifact.form.category.label"/>
                </label>
                <div class="col-lg-10">
                    <form:radiobutton path="category" value="individual"/>
                    <spring:message code="addArtifact.form.category.individual.label"/>
                    <form:radiobutton path="category" value="group"/>
                    <spring:message code="addArtifact.form.category.group.label"/>
                    <form:errors path="category" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="artifactImage">
                    <spring:message code="addArtifact.form.artifactImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="artifactImage" path="artifactImage" type="file" class="form:input large" />
                    <form:errors path="artifactImage" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value = <spring:message code="buttons.addButton.label"/> />
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>
