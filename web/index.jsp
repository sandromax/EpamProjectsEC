<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<meta charset="UTF-8">
	<title>fastest</title>
</head>
<body>
	<header>
		<a href="index.jsp" class="logo"></a>
	</header>

	<main>
		<div class="flex-container">
			<div class="text_btn">
				<h1 class="title_1">Система <span class="or_text">быстрого тестирования</span> студентов</h1>
				<h2 class="title_2">Только тестирование, никакой рекламы</h2>
				<a href="jsp/sign_up.jsp" class="btn_fill">Зарегистрироваться</a>
				<a href="jsp/sign_in.jsp" class="btn_border">Войти</a>
				<div>
					<a href="trash/catalog.jsp">CATALOG</a>
					<h2>Good morning! This is fastest.</h2>
					<p><a href="trash/admin_reg.jsp">Admin Registration</a></p><br/>
					<p><a href="jsp/subjects_catalog.jsp">SUBJECTS</a></p>
					<p><a href="second.jsp">Second Page</a></p>

					<form action="controller">
						<input type="text" name="command" value="subjects_catalog">
						<input type="submit" value="RUN">
					</form>
<%----%>
					<a href="jsp/header.jsp">Header</a>
                    <button value="subjects_catalog" action="controller">btnSubjects</button>
                    <input type="button" name="<command>" value="subjects_command" onclick="controller">

                    <form action="controller">
                        <input type="text" name="command" value="main_page">
                        <input type="submit" value="Go">
                    </form>
					<form action="controller">
						<input type="submit" name="command" value="subjects_catalog"/>
					</form>

					<a href="/controller?command=subjects_catalog">Subjects</a>
				</div>
			</div>
		</div>

		<div>

			<jsp:useBean id="firstObject" class="org.sandromax.fastest.beans.FirstBean"/>
			<jsp:setProperty name="firstObject" property="textVar" value="Bonjour"></jsp:setProperty>
			<p>${firstObject.getTextVar()}</p>
			<jsp:getProperty name="firstObject" property="textVar"></jsp:getProperty>
		</div>
		
	</main>
</body>
</html>