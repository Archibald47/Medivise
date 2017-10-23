<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>
	<h1>Create new account</h1>
	<form action="../createaccount/" method='POST'>
		<div class="form-group">
			<label>User: <input class="form-control" type='text'
				name='username' /></label>
		</div>

		<div class="form-group">
			<label>Password: <input class="form-control" type='password'
				name='password' /></label>
		</div>

		<div class="form-group">
			<label>Confirm password: <input class="form-control"
				type='password' name='password2' /></label>
		</div>

		<button class="btn btn-primary" name="submit" type="submit">
			Submit</button>
	</form>
</body>
</html>