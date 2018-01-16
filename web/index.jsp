<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 08.01.18
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fastest</title>
    <link rel="stylesheet" href="jsp/css/reset.css">
    <link rel="stylesheet" href="jsp/css/common.css">
</head>
<body>
<h2>Good morning! This is fastest.</h2>
<p><a href="jsp/admin_reg.jsp">Admin Registration</a></p><br/>
<p><a href="jsp/admin_login.jsp">Admin Log In</a></p><br/>
<p><a href="jsp/student_login.jsp">Student Log In</a></p>
<p><a href="second.jsp">Second Page</a></p>
<form action="controller">
    <input type="text" name="punct">
    <input type="submit" value="RUN">
</form>
</body>
</html>
