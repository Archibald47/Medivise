<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Docotor Listing</title>
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
		<c:if test="${username != null}">
			<span class="navbar-text"> <a
				href="${pageContext.request.contextPath}/profile/">${username}</a>
			</span>
		</c:if>
		<c:if test="${username == null}">
			<span class="navbar-text"><a
				href="${pageContext.request.contextPath}/login/">login</a></span>
		</c:if>
	</nav>


	<div class="container lg-container">
		<h1>Registered doctors</h1>
		<c:forEach items="${ doctors }" var="d">
			<div>
				<p>${p.username}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>
