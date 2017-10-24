<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Medivise</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/statics/styles.css" />">
</head>

<body>
	<nav class="navbar navbar-dark bg-dark">
		<ul class="nav" style="margin-right: auto !important;">
			<li class="nav-item"><a class="nav-link active" href="/">Medivise</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="questions/">Forum</a></li>
			<li class="nav-item"><a class="nav-link" href="map/">Map</a></li>
		</ul>
		<c:if test="${username != null}">
			<span class="navbar-text"> hi ${username} </span>
		</c:if>
		<c:if test="${username == null}">
			<span class="navbar-text"><a href="login/">login</a></span>

		</c:if>
	</nav>
	<div class="container lg-container">
		<h1>Welcome to Medivise</h1>



		<P>The time on the server is ${serverTime}.</P>
		<a class="btn btn-primary" href="questions/">Goto forum</a>
	</div>
</body>
</html>
