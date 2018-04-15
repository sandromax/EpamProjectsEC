<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:500,600" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	<link rel="stylesheet" type="text/css" href="../css/catalog.css">
	<meta charset="UTF-8">
	<title>${title}</title>
</head>
<body>
    <jsp:include page="header.jsp" flush="true"></jsp:include>
	<main>
		<div class="catalog_section">
			<h2 class="card_title"><a href="/controller?command=subjects_catalog">&#11013; к предметам</a></h2>
			<div class="flex-catalog">

                <c:forEach items="${list}" var="item">
                    <div class="card_catalog">
                        <p class="card_title return"><c:out value="${item.getName()}" /></p>
                        <div class="triangle"></div>
                        <a href ="/controller?command=test_page&theme=${item.getName()}&title=Тест: ${subject} ${item.getName()}&subject=${subject}" class="btn_card">Пройти тест</a>
                    </div>
                </c:forEach>

                <p>Subject: ${subject}.</p>

                <p>&nbsp;param.command: ${param.command}.</p>
			</div>
		</div>
	</main>
</body>
</html>