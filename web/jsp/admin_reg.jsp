<%--
  Created by IntelliJ IDEA.
  User: sandro
  Date: 08.01.18
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator Registration</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/admin_reg.css">
</head>
<body>
    <div id="content">
        <div id="logo">
            <a href="#"><img src="img/logo.svg" alt=""></a>
        </div>
            <div id="reg_form">
                <form action="">
                    <div class="form_header">
                        <p>РЕГИСТРАЦИЯ</p>
                        <p>для администраторов</p>
                    </div>
                    <div class="form_email">
                        <p>ваш email адрес</p>
                        <input type="text" name="email" placeholder="your@mail.com">
                    </div>
                    <div class="form_name">
                        <p>полное имя администратора</p>
                        <input type="text" name="name" placeholder="Александр Сокур">
                    </div>
                    <div class="form_pass">
                        <p>ваш пароль</p>
                        <input type="text" name="pass" placeholder="5+ символов">
                    </div>
                    <div class="form_button">
                        <input type="submit" value="зарегистрироваться">
                        <p>Если у вас уже есть аккаунт. <a href="admin_login.jsp"><span class="orange_letters">Войдите</span></a></p>
                    </div>
                </form>
            </div>
        <div>
            <a href="admin_login.jsp">Log In</a>
        </div>
    </div>
    <div id="right_image"></div>
</body>
</html>
