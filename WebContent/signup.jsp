<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>
.gradient-custom {
/* fallback for old browsers */
background: #6a11cb;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
}
</style>
</head>
<body>
<section class="vh-100 gradient-custom">
<div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
<form action="SignupServlet" method="post">
	Username : <input type="text" name="susername"></br><br>
	Set Password : <input type="password" name="spassword"></br><br>
	Confirm Password : <input type="password" name="scpassword"></br><br> 
	Email : <input type="text" name="email"></br><br>
	Gender : <input type="text" name="gender"></br><br>
	Qualification : <input type="text" name="qualification"><br></br>
	Expertise : <input type="text" name="expertise"></br><br>
	Mobile No. : <input type="text" name="mobileno"></br><br>
	Experience : <input type="number" name="experience"></br><br>
	Description(Past Project) : <input type="text" name="description"><br></br>
	<button class="btn btn-outline-light btn-lg px-5" type="submit">Submit</button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>