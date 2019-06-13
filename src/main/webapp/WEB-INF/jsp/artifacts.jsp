<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Artifacts</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Artifacts</h1>
            <p>Artifacts available in QuestStore</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${artifacts}" var="artifact">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <img src="<c:url value="/resource/images/${artifact.name}.jpg"></c:url> " alt="image" style="width: 100%"/>
                        <h3>${artifact.name}</h3>
                        <p>${artifact.description}</p>
                        <p>${artifact.price} Codecool Coins</p>
                        <P>${artifact.category}</P>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
