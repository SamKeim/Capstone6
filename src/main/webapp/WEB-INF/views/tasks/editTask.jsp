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
<title>${CRUD} Task || Task Manager</title>
</head>
<body>
	<%@ include file="../partials/header.jsp"%>
	<main>
		<section class="container-fluid">
			<h3 class="display-3 text-center">${CRUD} Task</h3>
		</section>
		<div class="card text-center">
			<div class="container-fluid">
				<h4>${message}</h4>
			</div>
			<div class="card-body">
				<form method="post" action="/tasks/post/${CRUD}">
					<p>
						<label class="col-form-label">Title: </label> <input type="text"
							name="name" required value="${task.name}">
					</p>
					<p>
						<label class="col-form-label">Description: </label><input
							type="text" name="description" required
							value="${task.description}">
					</p>
					<p>
						<label class="col-form-label">Due Date: </label><input type="date"
							name="dueDate" required value="${task.dueDate}"> <input
							type="hidden" name="user" value="${user.id}">
							<input type="hidden" name="id" value="${task.id}">

					</p>
					<c:if test="${CRUD eq 'Edit'}">
						<p>
							<c:if test="${task.complete eq false}">
								<input type="radio" name="complete" value="True">
								<label>Complete</label>
								<input type="radio" name="complete" value="False" checked>
								<label>Incomplete</label>
							</c:if>
							<c:if test="${task.complete eq true}">
								<input type="radio" name="complete" value="True" checked>
								<label>Complete</label>
								</label>
								<input type="radio" name="complete" value="False">
								<label>Incomplete</label>
							</c:if>
						</p>
					</c:if>
					<c:if test="${CRUD ne 'Edit' }">
						<input type="hidden" name="complete" value="False">
					</c:if>
					<p>
						<button type="submit" class="btn btn-success">Commit</button>
						<c:if test="${CRUD eq 'Edit' }">
							<a href="/tasks/${task.id}/delete" class="btn btn-danger">Delete</a>
						</c:if>
						
						<a href="/tasks/" class="btn btn-warning">Back</a>
					</p>
				</form>

			</div>
		</div>
	</main>
</body>
</html>
