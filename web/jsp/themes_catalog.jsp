<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	<link rel="stylesheet" type="text/css" href="../css/catalog.css">
	<meta charset="UTF-8">
	<title>Каталог тестов</title>
</head>
<body>
    <jsp:include page="header.jsp" flush="true"></jsp:include>
	<main>
		
		<div class="catalog_section">
			<h2 class="title_test"><a href="/controller?command=subjects_catalog">${param.subject}</a></h2>
			<div class="flex-catalog">

                <c:forEach items="${list}" var="item">
                    <div class="card_catalog">
                        <p class="card_title"><c:out value="${item.getName()}" /></p>
                        <div class="triangle"></div>
                        <a href ="/controller?command=themes_catalog&subject=${item.getName()}" class="btn_card">Пройти тест</a>
                    </div>
                </c:forEach>

				<%--<div class="card_catalog">--%>
						<%--<p class="card_title">Африка</p>--%>
						<%--<a href ="#" class="btn_card">Пройти тест</a>--%>
				<%--</div>--%>

				<%--<div class="card_catalog">--%>
						<%--<p class="card_title">Тасмания</p>--%>
						<%--<a href ="#" class="btn_card">Пройти тест</a>--%>
				<%--</div>--%>

				<%--<div class="card_catalog">--%>
						<%--<p class="card_title">Гималаи</p>--%>
						<%--<a href ="#" class="btn_card">Пройти тест</a>--%>
				<%--</div>--%>

				<%--<div class="card_catalog">--%>
						<%--<p class="card_title">Западная европа</p>--%>
						<%--<a href ="#" class="btn_card">Пройти тест</a>--%>

				<%--</div>--%>

				<%--<div class="card_catalog">--%>
						<%--<p class="card_title">Карибский архипелаг</p>--%>
						<%--<a href ="#" class="btn_card">Пройти тест</a>--%>
				<%--</div>--%>

                <p>subject: ${param.subject}</p><br>
                <p>command: ${param.command}</p>


			</div>
		</div>
		
	</main>
	
</body>
</html>