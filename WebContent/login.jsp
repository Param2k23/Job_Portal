<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
              <p class="text-white-50 mb-5">Please enter your login and password!</p>

              <form action="LoginServlet" method="post">
		<input type="radio" id="company" name="user_type1" value="company">
		<label for="company">Company</label><nbsp><nbsp><nbsp>
		<input type="radio" id="freelancer" name="user_type1" value="freelancer">
		<label for="freelancer">Freelancer</label><br>
                <input type="text" id="typeEmailX" class="form-control form-control-lg" name="lusername" />
                <label class="form-label" for="typeEmailX">UserName</label>
              

              <div class="form-outline form-white mb-2">
                <input type="password" id="typePasswordX" class="form-control form-control-lg" name="lpassword"/>
                <label class="form-label" for="typePasswordX">Password</label>
              </div>
              
             </form>
              <p class="small mb-0 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>
			<a href="controller.LoginServlet.java">
              <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
			</a>

            </div>

            <div>
              <p class="mb-0">Don't have an account? <a href="Option.jsp" class="text-white-50 fw-bold">Sign Up</a>
              </p>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>