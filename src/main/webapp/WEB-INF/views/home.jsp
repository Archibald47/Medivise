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

<body background="http://images.missyuan.com/attachments/day_110915/20110915_a607f4905631c594223aRQxAI5Y68sr8.gif">
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
	<br>
	<div class="container md-container">
		<h1>Welcome to Medivise</h1>
		<p>
			Medivise is an online information platform that provides expert advice to patients before they reach out to doctors by allowing patients make appointments in advance. Furthermore, it connects patients and doctors by through question and answering forums, map guiding, and appointment booking.
		</p>
		<a class="btn btn-primary" href="questions/">Goto forum</a>
		<br>
		<br>
		<a class="btn btn-primary" href="appointment/">view doctor's availability</a>
	</div>
</body>
</html>
