<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 29.01.18
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/catalog.css">
    <title>Subjects</title>
</head>
<body>
    <jsp:include page="header.jsp" flush="true"></jsp:include>
    <main>
        <div class="catalog_section">
            <h2 class="title_catalog"><%--<span class="numbers">01.</span> Мировая история</h2>--%>
            <div class="flex-catalog">

                <c:forEach items="${list}" var="item">
                        <div class="card_catalog">
                            <p class="card_title"><c:out value="${item.getName()}" /></p>
                            <div class="triangle"></div>
                            <a href ="/controller?command=themes_catalog&subject=${item.getName()}" class="btn_card">Перейти</a>
                            <%--${item.getName()}--%>
                            <%--Математика--%>
                        </div>
                </c:forEach>
            </div>
        </div>
    </main>
</body>
</html>
