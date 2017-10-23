<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>${ question.title } | Forum | Medivise</title>
</head>
<body>
	<a href="..">Back to question list</a>
	<h1>${ question.title }</h1>

	<p>Description: ${ question.content }</p>
	<p>Created: ${question.created}</p>

	<form action="delete/" method="post">
		<input type="submit" value="Delete this question">
	</form>
	
	<h2>Comments</h2>
	<c:forEach items="${ comment }" var="c">
		<c:if test= "${c.questionId==question.id}">
		<hr>
		<div>
			<!-- 
			<h3>
				<a href="${ c.id }/">${ c.content }</a>
			</h3>
			
			 -->
			<p>Answer: ${c.content}</p>
			<p>Provided by: ${c.author}</p>
			<p>Created: ${c.created}</p>
		</div>
		</c:if>
	</c:forEach>
	<hr>
	
	<h2>Post a new comment</h2>

	<form action="comment/" method="post">
		
		<textarea name="content"></textarea>
		<br> <input type="submit" value="Comment">
	</form>
	
	
	
	<!-- 
	<a href="comment/">Post a new comment</a>
	 -->
</body>
</html>
