<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>${ question.title } | Forum | Medivise</title>
</head>
<body>
	<a href="..">Back to question list</a>
	<h1>${ question.title }</h1>

	<p>${ question.content }</p>

	<form action="delete/" method="post">
		<input type="submit" value="Delete this question">
	</form>
</body>
</html>
