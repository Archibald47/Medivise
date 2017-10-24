<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/statics/styles.css" />">

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
	<div class="container sm-container" style="padding-top: 40px">
		<h1>Login</h1>
		<form action="../perform_login/" method='POST'>
			<c:if test="${param.error != null}">
				<div class="alert alert-danger" role="alert" id="error">Incorrect
					login credentials. Please try again.</div>
			</c:if>

			<div class="form-group">
				<label style="display: block;">User name: <input class="form-control" type='text'
					name='j_username' style="display: block;" /></label>
			</div>
			
			<div class="form-group">
				<label style="display: block;">Password: <input class="form-control" type='password'
					name='j_password' style="display: block;" /></label>
			</div>
			<a href="${pageContext.request.contextPath}/register/">Register an account</a>
			<button class="btn btn-primary btn-lg btn-block" name="submit" type="submit">
				Submit</button>
		</form>
	</div>
</body>
</html>