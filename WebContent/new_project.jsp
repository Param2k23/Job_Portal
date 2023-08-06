<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Project</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
    <li class="nav-item">
        <a class="nav-link" href="chome.jsp">Home</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="new_project.jsp">New Project<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="hire.jsp">Hire Freelancer</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="companypendingProjects.jsp">List Pending Projects</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="Signout.jsp">
      <button class="btn btn-outline-failure my-2 my-sm-0 bg-light" type="submit">Sign Out</button>
    </form>
  </div>
</nav>
<h1>Enter the details of new project</h1>
<form class="form-outline ml-2" action="NewProjectServlet" method="post">
	Amount : <input type="number" name="amount"/><br><br>
	Technology : <input type="text" name="technology"><br><br>
	Project Url : <input type="file" name="projecturl"><br><br>
	Rate Type : <input type="text" name="ratetype"><br><br>
	About : <input type="text" name="about"><br><br>
<input type="submit" value="submit">
</form>
<br><br>
</body>