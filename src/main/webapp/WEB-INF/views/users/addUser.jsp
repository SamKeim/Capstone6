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
<title>Register || Task Manager</title>
</head>
<body>
	<%@ include file="../partials/header.jsp"%>
	<main>
		<section class="container-fluid">
			<h2 class="display-3">Register</h2>
		</section>
		<div class="card text-center">
			<div class="card-header">
				<h4>${message}</h4>
			</div>
			<div class="card-body">
				<h2>Register a new user.</h2>
				<form method="post">
					<p>
						<label>Username: </label> <input type="text" name="username"
							required>
					</p>
					<p>
						<label>Password: </label><input type="password" name="password"
							required>
					</p>
					<p>
						<label>Confirm: </label><input type="password"
							name="passwordConfirm" required>
					</p>
					<p>
						<button type="submit" class="btn btn-success">Register</button>
						<a href="/" class="btn btn-caution">Home</a>
					</p>
				</form>

			</div>
		</div>
	</main>
</body>
</html>
