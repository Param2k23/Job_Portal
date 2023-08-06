package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bean.BidBean;
import bean.ProjectBean;
import util.DbConnection;

public class ProjectDao {
	public static ArrayList<ProjectBean> getAllProjects(String field) {

		ArrayList<ProjectBean> users = new ArrayList<ProjectBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from PROJECT where TECHNOLOGY like '%"+ field +"%' AND Project_status='placed'");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				ProjectBean user = new ProjectBean();
				user.setUser_id(rs.getInt("user_Id"));
				user.setCompany_id(rs.getInt("company_Id"));
				user.setProject_id(rs.getInt("project_Id"));
				user.setProject_url(rs.getString("project_url"));
				user.setProject_status(rs.getString("project_status"));
				user.setAmount(rs.getInt("Amount"));
				user.setrate_type(rs.getString("rate_type"));
				user.setTechnology(rs.getString("Technology"));
				user.setAbout(rs.getString("about"));
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("Exception in UserDao::getAllUsers()");
			e.printStackTrace();
		}
		return users;

	}
	
	public void insertProject(int Company_id,int Amount , String Technology, String ProjectUrl,String RateType, String About)
	{
		try{
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into Project values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, null);
			ps.setInt(2, Company_id);
			ps.setInt(3, 0);
			ps.setString(4, "placed");
			ps.setInt(5,Amount);
			ps.setString(6, Technology);
			ps.setString(7, ProjectUrl);
			ps.setString(8, RateType);
			ps.setString(9, null);
			ps.setString(10, null);
			ps.setString(11,About);
			ps.executeUpdate();
			System.out.println("Project inserted successfully");
		}catch (Exception e) {
			System.out.println("Exception in UserDao::insertUser()");
			e.printStackTrace();
		}
	}
	
	public static ArrayList<ProjectBean> getSelectedProjects(int Company_id) {

		ArrayList<ProjectBean> users = new ArrayList<ProjectBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from project where COMPANY_ID = "+ Company_id +" AND Project_status='placed'");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				ProjectBean user = new ProjectBean();
				user.setUser_id(rs.getInt("user_Id"));
				user.setCompany_id(rs.getInt("company_Id"));
				user.setProject_id(rs.getInt("project_Id"));
				user.setProject_url(rs.getString("project_url"));
				user.setProject_status(rs.getString("project_status"));
				user.setrate_type(rs.getString("rate_type"));
				user.setAmount(rs.getInt("Amount"));
				user.setTechnology(rs.getString("Technology"));
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("Exception in UserDao::getAllUsers()");
			e.printStackTrace();
		}
		return users;
	}
	
		public static ArrayList<BidBean> getBid(int Project_id) {

			ArrayList<BidBean> users = new ArrayList<BidBean>();

			try {
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from bid where PROJECT_ID = "+ Project_id +" AND accepted=0");
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) { 
					BidBean user = new BidBean();
					user.setUser_id(rs.getInt("user_Id"));
					user.setBid_id(rs.getInt("bid_Id"));
					user.setProject_id(rs.getInt("project_Id"));
					user.setaccepted(rs.getInt("accepted"));
					user.setAmount(rs.getInt("Amount"));
					user.setescrow_indicator(rs.getInt("escrow_indicator"));
					users.add(user);
				}

			} catch (Exception e) {
				System.out.println("Exception in UserDao::getSelectedbid()");
				e.printStackTrace();
			}
			return users;
		}
		
		public static ArrayList<BidBean> SelectBid(int Bid_id) {

			ArrayList<BidBean> users = new ArrayList<BidBean>();

			try {
				Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update bid set accepted = 1 where bid_id = "+Bid_id);
			} catch (Exception e) {
				System.out.println("Exception in UserDao::Selectbid()");
				e.printStackTrace();
			}
			return users;
		}
		public static ArrayList<BidBean> DeSelectBid(int Project_id,int Bid_id) {

			ArrayList<BidBean> users = new ArrayList<BidBean>();

			try {
				Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update bid set accepted = 2 where project_id = " + Project_id+" and bid_id != "+Bid_id);
			} catch (Exception e) {
				System.out.println("Exception in UserDao::Selectbid()");
				e.printStackTrace();
			}
			return users;
		}
		
		public static void SelectProject(int Project_id, int User_id) {
			try {
				Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update project set user_id = "+User_id+" where Project_id = "+Project_id);
			} catch (Exception e) {
				System.out.println("Exception in UserDao::SelectProject()");
				e.printStackTrace();
			}
		}
		
		public static void UpdateStatus(int Project_id, int Bid_id) {
			try {
				Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update project set project_status = 'approved' where Project_id = "+Project_id);
			} catch (Exception e) {
				System.out.println("Exception in UserDao::SelectProject()");
				e.printStackTrace();
			}
		}
		
		public static void AddSolution(int Project_id, String Solution) {
			try {
				Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update project set solution_url = '"+Solution+"' where Project_id = "+Project_id);
			} catch (Exception e) {
				System.out.println("Exception in UserDao::SelectProject()");
				e.printStackTrace();
			}
		}
		
		public static void UpdateStatusComplete(int Project_id) {
			try {
				Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update project set project_status = 'completed' where Project_id = "+Project_id);
			} catch (Exception e) {
				System.out.println("Exception in UserDao::SelectProject()");
				e.printStackTrace();
			}
		}
}
