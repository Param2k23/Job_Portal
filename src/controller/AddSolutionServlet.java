package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDao;

public class AddSolutionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String Solution = req.getParameter("Solution");
		int Project_id = Integer.parseInt(req.getParameter("Project_id"));
		ProjectDao p = new ProjectDao();
		p.AddSolution(Project_id, Solution);
		p.UpdateStatusComplete(Project_id);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
