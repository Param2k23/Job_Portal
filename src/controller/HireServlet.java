package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BidBean;
import bean.ProjectBean;
import dao.ProjectDao;

public class HireServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int Project_id = Integer.parseInt(req.getParameter("project_id"));
		ProjectDao projectDao = new ProjectDao();
		ArrayList<BidBean> projects = ProjectDao.getBid(Project_id);
		req.setAttribute("projects", projects);

		RequestDispatcher rd = req.getRequestDispatcher("hire_list.jsp");
		rd.forward(req, resp);
	}
}
