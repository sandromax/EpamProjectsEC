<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 07.02.18
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/catalog.css">
    <link rel="stylesheet" type="text/css" href="../css/test_result.css">
    <meta charset="UTF-8">
    <title>${title_page}</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<div class="content">
    <%--Result of testing: ${test_rate}--%>
    <div class="result_answers">
        <c:forEach items="${issue_dones}" var="item">
            <div>
                <p>${item.getIssue().getQuestion()}</p>
                <br>
                <p>${item.getIssue().getVariantAnswers().get(0)}</p>
                <p>${item.getIssue().getVariantAnswers().get(1)}</p>
                <p>${item.getIssue().getVariantAnswers().get(2)}</p>
                <p>${item.getIssue().getVariantAnswers().get(3)}</p>
                <br>

                <%--<input type="checkbox" id="answer_id" name="answer" value="<c:out value="${item}" />">--%>
                <%--<label for="answer_id"><c:out value="${item}"/></label>&lt;%&ndash;  &ndash;%&gt;--%>

                    <%--<div class="card_catalog">--%>
                    <%--<p class="card_title return"><c:out value="${item.getName()}" /></p>--%>
                    <%--<div class="triangle"></div>--%>
                    <%--<a href ="/controller?command=test_page&theme=${item.getName()}&title=Тест: ${subject} ${item.getName()}&subject=${subject}" class="btn_card">Пройти тест</a>--%>
                    <%--</div>--%>
            </div>
        </c:forEach>
    </div>
    <div class="result_statistic">
        <div>
            <h3>${title}</h3>
        </div>
        <div>
            <p>Вірних відповідей: <span>${rights}</span></p>
            <p>Невірних відповідей: <span>${wrongs}</span></p>
            <%--<br>--%>
            <p>Результат тесту: <span>${rate} / 100.0</span></p>
            <%--<br>--%>
        </div>
        <div>
            <a href="/controller?command=subjects_catalog" class="btn_fill">Каталог тестів</a>
        </div>

    </div>
</div>
</body>
</html>
