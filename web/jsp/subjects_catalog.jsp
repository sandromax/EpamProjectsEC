<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 29.01.18
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/catalog.css">
    <title>Subjects</title>
</head>
<body>
    <jsp:include page="header.jsp" flush="true"></jsp:include>
    <main>
        <div class="catalog_section">
            <h2 class="title_catalog"><%--<span class="numbers">01.</span> Мировая история</h2>--%>
            <div class="flex-catalog">
                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Java</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <c:forEach items="${list}" var="item">
                    <div class="card_catalog">
                        <div class="card_text">
                            <p class="card_title"><c:out value="${item.getName()}" /></p>
                            <p>(<c:out value="${item.getLang()}" />)</p>
                        </div>
                    </div>
                </c:forEach>


                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">SQL</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Історія</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Географія</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Крестьянская война в германии</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
            </div>
        </div>


        <%--<div class="catalog_section">--%>
            <%--<h2 class="title_catalog"><span class="numbers">02.</span> География</h2>--%>
            <%--<div class="flex-catalog">--%>
                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Африка</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Тасмания</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Гималаи</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Западная европа</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card_catalog">--%>
                    <%--<div class="card_text">--%>
                        <%--<p class="card_title">Карибский архипелаг</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</main>--%>
</body>
</html>
