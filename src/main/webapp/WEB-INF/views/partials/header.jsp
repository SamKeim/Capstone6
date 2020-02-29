<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand">Task List</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor02">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/">Home</a>
      </li>
	  <c:if test="${user.username ne null}">
	        <li class="nav-item">
        <a class="nav-link" href="/tasks/">Task List</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/tasks/add">Add Task</a>
      </li>
	  
	  </c:if>
      </ul>
      <c:if test="${user.username eq null}">
      <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="/login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/register">Register</a>
      </li>
      </ul>
      </c:if>
      <c:if test="${user.username ne null}">
      <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="/logout">Logout</a>
      </li>
      </ul>
      </c:if>
    
    <!-- 
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
     -->
  </div>
</nav>