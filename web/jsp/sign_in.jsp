<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	<link rel="stylesheet" type="text/css" href="../css/sign_in.css">
	<meta charset="UTF-8">
	<title>Вход</title>
</head>
<body>
	<a href="../index.jsp" class="logo"></a>

	<main>
		<div class="flex-conteiner">
			<div class="sign_in_form">
				<div class="form">
					<h1 class="title_1">Вход</h1>

						<form action="/controller?command=sign_in" method="post">
							<fieldset class="signin_info">
								<label>
							Ваш Email Адрес
								<input type="email" name="email" placeholder="your@mail.com" required>
							</label>
							<label>
							Ваш пароль
								<input type="password" name="password" placeholder="5+ символов" required>
								${param.error}
							</label>
						</fieldset>
						<fieldset class="signin_action">
							<input class="btn_fill" type="submit" name="submit" value="Войти">
							<label class="container">Запомнить
							  <input type="checkbox" checked="checked">
							  <span class="checkmark"></span>
							</label>
						</fieldset>
					</form>
				</div>

			</div>

			<div class="signin_picture"></div>		
		</div>

		<div class="signin_footer">
			<p class="sign_title">Нет аккаунта? <a class="link" href="sign_up.jsp">Зарегистрируйтесь</a></p>
		</div>	

	</main>
</body>
</html>