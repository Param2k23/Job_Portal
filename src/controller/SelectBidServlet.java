package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProjectBean;
import dao.ProjectDao;

public class SelectBidServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int Bid_id = Integer.parseInt(req.getParameter("Bid_id"));
		int Project_id = Integer.parseInt(req.getParameter("Project_id"));
		int User_id = Integer.parseInt(req.getParameter("User_id"));
		ProjectDao.SelectBid(Bid_id);
		ProjectDao.DeSelectBid(Project_id, Bid_id);
		ProjectDao.SelectProject(Project_id, User_id);
		ProjectDao.UpdateStatus(Project_id,Bid_id);
		RequestDispatcher rd = req.getRequestDispatcher("chome.jsp");
		rd.forward(req, resp);
	}
}
