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

public class SearchProjectServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String field = req.getParameter("field");
		ProjectDao projectDao = new ProjectDao();
		ArrayList<ProjectBean> projects = ProjectDao.getAllProjects(field);

		req.setAttribute("projects", projects);

		RequestDispatcher rd = req.getRequestDispatcher("project_list.jsp");
		rd.forward(req, resp);
	}
}
