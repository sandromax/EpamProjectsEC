<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 29.01.18
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/catalog.css">
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<header>
    <div class="head">
        <div class="flex-head">
            <a href="/controller?command=main_page" class="logo"></a>
            <p class="head_title">${title}</p>
            <div class="dropdown">
                <button class="dropbtn">${user_name}</button>
                <div class="triangle-right"></div>
                <div class="dropdown-content">
                    <a href="/controller?command=sign_out">Выйти</a>
                </div>
            </div>
        </div>

    </div>
</header>
</body>
</html>
