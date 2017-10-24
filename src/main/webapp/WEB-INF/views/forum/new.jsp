<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>New question | Forum | Medivise</title>
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
	<h1>Post a new questions</h1>

	<form method="post">
		<label>Title: <input name="title"></label> <br> Content:
		<br>
		<textarea name="content"></textarea>
		<br> <input type="submit" value="Post">
	</form>

</body>
</html>
