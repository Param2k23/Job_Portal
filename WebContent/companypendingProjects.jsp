<%@page import="bean.ProjectBean"%>
<%@page import="dao.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>companypendingProjects</title>
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
      <li class="nav-item">
        <a class="nav-link " href="hire.jsp">Hire Freelancer</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link " href="companypendingProjects.jsp">List Pending Projects<span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="Signout.jsp">
      <button class="btn btn-outline-failure my-2 my-sm-0 bg-light" type="submit">Sign Out</button>
    </form>
  </div>
</nav>
<%
	int Company_id = (Integer)session.getAttribute("Company_id");
	UserDao user = new UserDao();
    ArrayList<ProjectBean> bids = user.getAllPendingCompanyBid(Company_id);
%>
<% if (bids.size()==0)
	{ %>
	<%="No Projects exits" %>
	<% 
	}
	
	else
	{
	%>
	<table class="table table-hover">
		<tr>
			<th scope="col">#</th> 
			<th scope="col">ProjectId</th>
			<th scope="col">Technology</th>
			<th scope="col">Amount</th>
		</tr>
		
		<%
			for (int i = 0; i < bids.size(); i++) {
		%>
		<tr>
			<th scope="row"><%= i+1 %></th>
			<td><%=bids.get(i).getProject_id()%></td>
			<td><%=bids.get(i).getTechnology()%></td>
			<td><%=bids.get(i).getAmount()%></td>	
		</tr>
		<%
			}}
		%>
	</table>
</body>
</html>