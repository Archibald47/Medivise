<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Forum | Medivise</title>
</head>
<body>
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
