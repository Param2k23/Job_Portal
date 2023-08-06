<%@page import="bean.ProjectBean"%>
<%@page import="dao.ProjectDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hire</title>
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
      <li class="nav-item">
        <a class="nav-link" href="new_project.jsp">New Project</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link " href="hire.jsp">Hire Freelancer<span class="sr-only">(current)</span></a>
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
<form class="form-outline" action="HireServlet" method="post">
	Enter the project id of the project you want to select from the list of your projects given below <br>
	<input type="number" name="project_id"><br><br>
	<input type="submit" value="submit"> 
</form>
<%
	int company_id = (Integer)session.getAttribute("Company_id");
    ArrayList<ProjectBean> projects = ProjectDao.getSelectedProjects(company_id);
%>
	<table class="table table-hover">
		<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">ProjectId</th>
			<th scope="col">Project Status</th>
			<th scope="col">Amount</th>
			<th scope="col">Technology</th>
		</tr>
		</thead>
		<%
			for (int i = 0; i < projects.size(); i++) {
		%>
		<tbody>
		<tr>
			<th scope="row"><%= i+1 %></th>
			<td><%=projects.get(i).getProject_id()%></td>
			<td><%=projects.get(i).getProject_status()%></td>
			<td><%=projects.get(i).getAmount()%></td>
			<td><%=projects.get(i).getTechnology()%></td>	
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	<br><br>
</body>
</html>