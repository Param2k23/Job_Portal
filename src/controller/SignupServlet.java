package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class SignupServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String susername = req.getParameter("susername");
		String spassword = req.getParameter("spassword");
		String scpassword = req.getParameter("scpassword");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String qualification = req.getParameter("qualification");
		String expertise = req.getParameter("expertise");
		int mobileno = Integer.parseInt(req.getParameter("mobileno"));
		int experience = Integer.parseInt(req.getParameter("experience"));
		String description = req.getParameter("description");
		
		if(spassword.equals(scpassword))
		{	
			out.println("Account Created Successfully");
			UserDao u = new UserDao();
			u.insertUser(susername, spassword,email,gender,qualification,expertise,mobileno,experience,description);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.include(req, resp);
		}
	}
}
