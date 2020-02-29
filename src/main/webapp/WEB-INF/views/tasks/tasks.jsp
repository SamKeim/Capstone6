<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/sandstone/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ABdnjefqVzESm+f9z9hcqx2cvwvDNjfrwfW5Le9138qHCMGlNmWawyn/tt4jR4ba"
	crossorigin="anonymous">
<title>View Tasks || Task Manager</title>
</head>
<body>
	<%@ include file="../partials/header.jsp"%>

	<div class="container">
	<div class="container-fluid">
	<h4>${message}</h4>
	</div>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Due Date</th>
				<th>Status</th>
				<th>Edit</th>
			</tr>
			<c:forEach var="task" items="${tasks}">
				<tr>
					<td>${task.name}</td>
					<td>${task.description}</td>
					<td>${task.dueDate}</td>
					<td>
					<c:if test="${task.complete eq 'True'}">
					Completed
					</c:if>
					</td>
					<td><a href="/tasks/edit/${task.id}" class="btn btn-primary">Edit
							Task</a></td>
				</tr>
			</c:forEach>
		</table>


	</div>
</body>
</html>