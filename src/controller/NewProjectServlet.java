package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CompanyInfoBean;
import bean.ProjectBean;
import dao.ProjectDao;
import dao.UserDao;

public class NewProjectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		int Company_id = (Integer)session.getAttribute("Company_id");
		int amount = Integer.parseInt(req.getParameter("amount"));
		String technology = req.getParameter("technology");
		String projecturl = req.getParameter("projecturl");
		String ratetype = req.getParameter("ratetype");
		String about = req.getParameter("about");
		System.out.println("Company id is : "+Company_id);
		ProjectDao p = new ProjectDao();
		p.insertProject(Company_id,amount, technology,projecturl,ratetype,about);
		
		RequestDispatcher rd = req.getRequestDispatcher("chome.jsp");
		rd.forward(req, resp);
	}
}
