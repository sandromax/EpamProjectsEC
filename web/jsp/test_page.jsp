<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 07.02.18
  Time: 12:49
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
    <link rel="stylesheet" type="text/css" href="../css/test.css">
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<main>
    <div class="content">
        <div>
            <p class="numberIO">${current_issue_number}/${number_of_issue}</p>
            <p class="estimate">0:48</p>
        </div>
        <div class="question">
            <form action="/controller?command=NEXT_QUESTION" method="post">
                <%--<p>Вопрос:</p>--%>
                <p>${question}</p>
                <c:forEach items="${answers}" var="item">
                    <div>
                        <input type="checkbox" id="answer_id" name="answer" value="<c:out value="${item}" />">
                        <label for="answer_id"><c:out value="${item}"/></label><%--  --%>
                            <%--<div class="card_catalog">--%>
                            <%--<p class="card_title return"><c:out value="${item.getName()}" /></p>--%>
                            <%--<div class="triangle"></div>--%>
                            <%--<a href ="/controller?command=test_page&theme=${item.getName()}&title=Тест: ${subject} ${item.getName()}&subject=${subject}" class="btn_card">Пройти тест</a>--%>
                            <%--</div>--%>
                    </div>
                </c:forEach>

                <%--<div>--%>
                <%--<input type="checkbox" idInDb="answer1" name="subscribe" value="answerOne">--%>
                <%--<label for="answer1">Ответ 1</label>--%>
                <%--</div>--%>
                <%--<div>--%>
                <%--<input type="checkbox" idInDb="answer2" name="subscribe" value="answerSecond">--%>
                <%--<label for="answer1">Ответ 2</label>--%>
                <%--</div><div>--%>
                <%--<input type="checkbox" idInDb="answer3" name="subscribe" value="answerThird">--%>
                <%--<label for="answer1">Ответ 3</label>--%>
                <%--</div><div>--%>
                <%--<input type="checkbox" idInDb="answer4" name="subscribe" value="answerFourth">--%>
                <%--<label for="answer1">Ответ 4</label>--%>
                <%--</div>--%>
                <a href="/controller?command=NEXT_QUESTION">Далее</a>
                <input type="submit" value="Далее">
                <input class="btn_fill" type="submit" name="submit" value="Войти">
            </form>
        </div>
        <div>
            <p>в тесте могут быть так себе ответы</p>
            <a href="/controller?command=end_test">Завершить тест</a>
        </div>
    </div>
</main>
</body>
</html>
