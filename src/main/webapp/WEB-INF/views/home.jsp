<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Medivise</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>

<body>
	<h1>Welcome to Medivise</h1>

	<c:if test="${username != null}">
		<p>hi ${username}</p>
	</c:if>
	<c:if test="${username == null}">
		<a href="login/">login</a>
	</c:if>


	<P>The time on the server is ${serverTime}.</P>
	<a class="btn btn-primary" href="questions/">Goto forum</a>
</body>
</html>
