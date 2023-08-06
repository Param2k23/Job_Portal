package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class CSignupServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String susername = req.getParameter("susername");
		String spassword = req.getParameter("spassword");
		String scpassword = req.getParameter("scpassword");
		String email = req.getParameter("email");
		int establishyear = Integer.parseInt(req.getParameter("Establishyear"));
		String about = req.getParameter("about");
		
		if(spassword.equals(scpassword))
		{	
			out.println("Account Created Successfully");
			UserDao u = new UserDao();
			System.out.println(susername+spassword+establishyear+about+email);
			u.insertcompanyUser(susername, spassword,establishyear,about,email);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("csignup.jsp");
			rd.include(req, resp);
		}
	}
}
