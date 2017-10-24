<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/statics/styles.css" />">
<title>Forum | Medivise</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<ul class="nav" style="margin-right: auto !important;">
			<li class="nav-item"><a class="nav-link active" href="/medivise/">Medivise</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/medivise/questions/">Forum</a></li>
			<li class="nav-item"><a class="nav-link" href="/medivise/map/">Map</a></li>
		</ul>
		<c:if test="${username != null}">
			<span class="navbar-text"> <a href="/medivise/profile/">${username}</a> </span>
		</c:if>
		<c:if test="${username == null}">
			<span class="navbar-text"><a href="/medivise/login/">login</a></span>

		</c:if>
	</nav>
	<h1>Questions</h1>
	<c:forEach items="${ questions }" var="q">
		<hr>
		<div>
			<h3>
				<a href="${ q.id }/">${ q.title }</a>
			</h3>
			<p>${q.content}</p>
		</div>
	</c:forEach>
	<hr>
	<a href="new/">Post a new question</a>

</body>
</html>
