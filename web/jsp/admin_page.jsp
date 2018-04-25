<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 07.02.18
  Time: 12:53
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
    <%--<link rel="stylesheet" type="text/css" href="../css/test.css">--%>
    <link rel="stylesheet" type="text/css" href="../css/admin.css">
    <meta charset="UTF-8">
    <%--<title>${title}</title>--%>
    <title>Administration</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>
Bonjour, monsier!
<div class="content">
    <%--<div class="download_file">--%>
    <%--<p>Загрузка файла с тестом</p>--%>

    <%--</div>--%>
    <div class="students">
        <div class="list">

        </div>
        <div class="download">
            <form action="upload" method="post" enctype="multipart/form-data">
                <p>Завантажити файл з питаннями</p>
                <input type="text" name="description"/>
                <input type="file" name="file"/>
                <input type="submit"/>
            </form>
        </div>
    </div>
    <div class="success">

    </div>
</div>

</body>
</html>
