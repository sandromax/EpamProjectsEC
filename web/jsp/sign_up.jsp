<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	<link rel="stylesheet" type="text/css" href="../css/sign_up.css">
	<meta charset="UTF-8">
	<title>Регистрация</title>
</head>
<body>
	<a href="../index.jsp" class="logo"></a>

	<main>
		<div class="flex-conteiner">
			<div class="sign_up_form">
				<div class="form">
					<h1 class="title_1">Регистрация</h1>

						<form>
							<fieldset class="signup_info">
								<label>
							Ваш Email Адрес
								<input type="email" name="email-address" placeholder="your@mail.com" required>
							</label>
							<label>
							Ваше полное имя
								<input type="text" name="username" placeholder="Александр Сокур" required>
							</label>
							<label>
							Ваш пароль
								<input type="password" name="password" placeholder="5+ символов" required>
							</label>
						</fieldset>
						<fieldset class="signup_action">
							<input class="btn_fill" type="submit" name="submit" value="Зарегистрироваться">
						</fieldset>
					</form>
				</div>

			</div>

			<div class="signup_picture"></div>		
		</div>

		<div class="signup_footer">
			<p class="sign_title">Если у вас уже есть аккаунт, <a class="link" href="sign_in.jsp">Войдите</a></p>
		</div>	

	</main>
</body>
</html>