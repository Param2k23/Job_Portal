package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

public class BidServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int Project_id = Integer.parseInt(req.getParameter("Project_id"));
		HttpSession session = req.getSession(false);
		int User_id = (Integer)session.getAttribute("User_id");
		System.out.println(User_id+" "+Project_id);
		UserDao p = new UserDao();
		p.PlaceBid(User_id ,Project_id,amount);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
