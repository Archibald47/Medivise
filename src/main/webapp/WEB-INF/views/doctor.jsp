<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor Booking </title>
</head>
<body>
<h1>Doctor's Data</h1>

<form:form action="doctor/doctor.do" method="POST" commandName="doctor">
	<table>
	<tr>
		<td>ID</td>
		<td><form:input path= "id"/></td>
	</tr> 
	<tr>
		<td>category</td>
		<td><form:input path= "category"/></td>
	</tr> 
	<tr>
		<td>available_time</td>
		<td><form:input path= "available_time"/></td>
	</tr> 
	<tr>
		<td colspan="2">
		<!-- relates to DoctorController -->
			<input type="submit" name="action" value="Add"/>
			<input type="submit" name="action" value="Edit"/>
			<input type="submit" name="action" value="Delete"/>
			<input type="submit" name="action" value="Search"/>
		</td>
	</tr>
	</table>
</form:form>
<br>
	<table border="1">
	<tr>
		<th>ID</th>
		<th>Category</th>
		<th>Available Time</th>
	</tr>
		<!-- relates to controller -->
		<c:forEach items="${doctorList}" var=" doctor">
			<tr> 
				<td>${doctor.id}</td>
				<td>${doctor.category}</td>
				<td>${doctor.available_time}</td>
			</tr>
		</c:forEach>
		
	</table>
<br>
</body>
</html> 