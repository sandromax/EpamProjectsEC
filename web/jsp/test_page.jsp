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
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/catalog.css">
    <link rel="stylesheet" type="text/css" href="../css/test.css">
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<main>
    <div class="content">
        <div>
            <p class="numberIO">2/18</p>
            <p class="estimate">0:48</p>
        </div>
        <div class="question">
            <form action="/controller?command=next_question">
                <p>Вопрос</p>
                <div>
                    <input type="checkbox" id="answer1" name="subscribe" value="answerOne">
                    <label for="answer1">Ответ 1</label>
                </div>
                <div>
                    <input type="checkbox" id="answer2" name="subscribe" value="answerSecond">
                    <label for="answer1">Ответ 2</label>
                </div><div>
                <input type="checkbox" id="answer3" name="subscribe" value="answerThird">
                <label for="answer1">Ответ 3</label>
            </div><div>
                <input type="checkbox" id="answer4" name="subscribe" value="answerFourth">
                <label for="answer1">Ответ 4</label>
            </div>
                <input type="submit" value="Далее">
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
