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
				<a href="/controller?command=sign_up_page" class="btn_fill">Зарегистрироваться</a>
				<a href="/controller?command=sign_in_page" class="btn_border">Войти</a>
				<div>
					<hr>
					<a href="/controller?command=subjects_catalog">Subjects</a>
					<hr/>
					<a href="/controller?command=themes_catalog">Themes</a>
					<hr>
					<form action="controller">
						<input type="text" name="command" value="themes_catalog">
						<input type="text" name="subject" value="SQL">
						<input type="submit" value="THEMES by SQL">
					</form>
					<hr>
					<a href="/controller?command=admin_page">Admin Page</a>
				</div>
			</div>
		</div>
	</main>
</body>
</html>