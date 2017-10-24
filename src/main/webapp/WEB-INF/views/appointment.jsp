<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/statics/styles.css" />">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Making an appointment</title>
</head>

<body>
<nav class="navbar navbar-dark bg-dark">
		<ul class="nav" style="margin-right: auto !important;">
			<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/">Medivise</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/questions/">Forum</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/map/">Map</a></li>
		</ul>
		<c:if test="${username != null}">
			<span class="navbar-text"> <a href="${pageContext.request.contextPath}/profile/">${username}</a> </span>
		</c:if>
		<c:if test="${username == null}">
			<span class="navbar-text"><a href="${pageContext.request.contextPath}/login/">login</a></span>
		</c:if>
	</nav>
	<h1>Doctor's Data</h1>
	
	<c:if test="${user != null}">
	

	<form action="add/" method="POST">

		<div class="form-group">
			<label>Category: <input class="form-control" type='text'
				name='category' /></label>
		</div>

		<div class="form-group">
			<label>Availability: <input class="form-control" type='text'
				name='availability' /></label>
		</div>

		<button class="btn btn-primary" name="submit" type="submit">
			Add</button>
	</form>
	</c:if>

	<table>
		<tr>
			<th>Doctor name</th>
			<th>Category</th>
			<th>Available Time</th>
		</tr>
		<c:forEach items="${ appointments }" var=" app">
			<tr>
				<td">${ app.user.username }</td>
				<td>${ app.category }</td>
				<td>${ app.availability }</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
