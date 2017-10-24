<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Docotor Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/statics/styles.css" />">
</head>

<body>
	<nav class="navbar navbar-dark bg-dark">
		<ul class="nav" style="margin-right: auto !important;">
			<li class="nav-item"><a class="nav-link active"
				href="${pageContext.request.contextPath}/">Medivise</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/questions/">Forum</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/map/">Map</a></li>
		</ul>
		<span class="navbar-text"> <a
			href="${pageContext.request.contextPath}/logout/">Logout</a>
		</span>

	</nav>


	<div class="container lg-container">
		<h1>My Questions</h1>
		<c:forEach items="${ questions }" var="q">
			<hr>
			<div>
				<h3>
					<a href="../questions/${ q.id }/">${ q.title}</a>
				</h3>
				<p>${q.content}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>
