<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Artifacts</h1>
            <p>Add new artifact</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form  modelAttribute="newArtifact" class="form-horizontal">
        <fieldset>
            <legend>Add new artifact</legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="artifactId">Id artefaktu</label>
                <div class="col-lg-10">
                    <form:input id="artifactId" path="artifactId" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="price">Price</label>
                <div class="col-lg-10">
                    <div class="form:input-prepend">
                        <form:input id="unitPrice" path="price" type="text" class="form:input-large"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="description">Description</label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows = "2"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="category">Category</label>
                <div class="col-lg-10">
                    <form:radiobutton path="category" value="Individual"/> Individual
                    <form:radiobutton path="category" value="Group"/> Group
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>
