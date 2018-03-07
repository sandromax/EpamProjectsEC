<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 07.02.18
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration</title>
</head>
<body>
Bonjour, monsier!
<form action="/controller?<command=get_tests_from_file" method="post" enctype="multipart/form-data">
    <p>Укажите файл с тестами</p>
    <input type="file" name="fileName" accept="text/plain">
    <input type="submit" value="Обработать">
</form>
Second form
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>
</body>
</html>
