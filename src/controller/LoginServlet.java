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
import bean.InfoBean;
import dao.UserDao;

public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String user_type1 = req.getParameter("user_type1");
		String Username = req.getParameter("lusername");
		String Password = req.getParameter("lpassword");
		if(user_type1.equals("freelancer"))
		{
		UserDao u = new UserDao();
		ArrayList<InfoBean> user = u.getAllUsers();
		Boolean flag = false;
	    for(int i=0;i<user.size();i++)
	    {
	    	if(Username.equals(user.get(i).getUsername()) && Password.equals(user.get(i).getPassword()))
	    	{
	    		flag = true;
	    		HttpSession mysession = req.getSession();
	    		mysession.setAttribute("User_id", user.get(i).getUser_id());
	    		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
	    		rd.forward(req, resp);
	    		break;
	    	}
	    }
	    if(flag==false)
	    {
	    	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
    		rd.forward(req, resp);
	    }
		}
		else
		{
			UserDao u = new UserDao();
			ArrayList<CompanyInfoBean> user1 = u.getAllUserscompany();
			Boolean flag = false;
		    for(int i=0;i<user1.size();i++)
		    {
		    	if(Username.equals(user1.get(i).getUsername()) && Password.equals(user1.get(i).getPassword()))
		    	{
		    		flag = true;
		    		HttpSession mysession = req.getSession();
		    		mysession.setAttribute("Company_id", user1.get(i).getCompany_id());
		    		RequestDispatcher rd = req.getRequestDispatcher("chome.jsp");
		    		rd.forward(req, resp);
		    		break;
		    	}
		    }
		    if(flag==false)
		    {
		    	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
	    		rd.forward(req, resp);
		    }
		}
	}
}
