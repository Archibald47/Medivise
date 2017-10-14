<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>New question | Forum | Medivise</title>
</head>
<body>
	<h1>Post a new questions</h1>

	<form method="post">
		<label>Title: <input name="title"></label> <br> Content:
		<br>
		<textarea name="content"></textarea>
		<br> <input type="submit" value="Post">
	</form>

</body>
</html>
