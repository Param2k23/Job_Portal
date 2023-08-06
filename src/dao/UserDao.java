package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.BidBean;
import bean.CompanyInfoBean;
import bean.InfoBean;
import bean.ProjectBean;
import util.DbConnection;

public class UserDao {
	public void insertUser(String Username , String Password , String EmailId, String Gender, String Qualification, String Expertise, int Mobile_No,int Experience,String Description)
	{
		try{
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into info values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, Username);
			ps.setString(2, Password);
			ps.setInt(3, 0);
			ps.setString(4, EmailId);
			ps.setString(5, Gender);
			ps.setString(6, Qualification);
			ps.setString(7, Expertise);
			ps.setInt(8, Mobile_No);
			ps.setInt(9, Experience);
			ps.setString(10, Description);
			
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println("Exception in UserDao::insertUser()");
			e.printStackTrace();
		}
	}
	
	public void insertcompanyUser(String Username , String Password, int Establishyear, String About,String Email)
	{
		try{
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into companyinfo values(?,?,?,?,?,?)");
			ps.setString(1, Username);
			ps.setString(2, Password);
			ps.setInt(3, 0);
			ps.setInt(4, Establishyear);
			ps.setString(5, About);
			ps.setString(6, Email);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println("Exception in UserDao::insertcompanyUser()");
			e.printStackTrace();
		}
	}
	
	public ArrayList<InfoBean> getAllUsers() {

		ArrayList<InfoBean> users = new ArrayList<InfoBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from info");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				InfoBean user = new InfoBean();
				user.setUser_id(rs.getInt("User_id"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email_Id"));
				user.setGender(rs.getString("Gender"));
				user.setQualification(rs.getString("Qualification"));
				user.setExpertise(rs.getString("Expertise"));
				user.setMobile_No(rs.getInt("Mobile_No"));
				user.setExperience(rs.getInt("Experience"));
				user.setDescription(rs.getString("Description"));
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("Exception in UserDao::getAllUsers()");
			e.printStackTrace();
		}
		return users;

	}
	
	public ArrayList<CompanyInfoBean> getAllUserscompany() {

		ArrayList<CompanyInfoBean> users = new ArrayList<CompanyInfoBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from companyinfo");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				CompanyInfoBean user = new CompanyInfoBean();
				user.setUser_id(rs.getInt("Company_id"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email"));
				user.setEstablishyear(rs.getInt("Establishyear"));
				user.setAbout(rs.getString("About"));
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("Exception in UserDao::getAllUsers()");
			e.printStackTrace();
		}
		return users;

	}
	
	public void PlaceBid(int User_id ,int Project_id, int amount)
	{
		try{
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into Bid values(?,?,?,?,?,?)");
			ps.setInt(1, User_id);
			ps.setInt(2, Project_id);
			ps.setInt(3, 0);
			ps.setInt(4, amount);
			ps.setInt(5, 0);
			ps.setInt(6, 0);
			ps.executeUpdate();
			System.out.println("Bid placed");
		}catch (Exception e) {
			System.out.println("Exception in UserDao::insertUser()");
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<BidBean> getAllPendingUsersBid(int User_id) {

		ArrayList<BidBean> users = new ArrayList<BidBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from bid where USER_ID = "+User_id +" AND accepted=0");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				BidBean user = new BidBean();
				user.setUser_id(rs.getInt("user_Id"));
				user.setBid_id(rs.getInt("bid_Id"));
				user.setProject_id(rs.getInt("project_Id"));
				user.setAmount(rs.getInt("Amount"));
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("Exception in UserDao::getAllPendingUsersBid()");
			e.printStackTrace();
		}
		return users;

	}
	
	public ArrayList<BidBean> getAllAcceptedUsersBid(int User_id) {

		ArrayList<BidBean> users = new ArrayList<BidBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from bid where USER_ID = "+User_id +" AND accepted=1");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				BidBean user = new BidBean();
				user.setUser_id(rs.getInt("user_Id"));
				user.setBid_id(rs.getInt("bid_Id"));
				user.setProject_id(rs.getInt("project_Id"));
				user.setAmount(rs.getInt("Amount"));
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("Exception in UserDao::getAllPendingUsersBid()");
			e.printStackTrace();
		}
		return users;

	}
	
	public ArrayList<ProjectBean> getAllPendingCompanyBid(int Company_id) {

		ArrayList<ProjectBean> users = new ArrayList<ProjectBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from project where Company_ID = "+Company_id +" AND user_id is NULL");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				ProjectBean user = new ProjectBean();
				user.setProject_id(rs.getInt("project_Id"));
				user.setAmount(rs.getInt("Amount"));
				user.setTechnology(rs.getString("Technology"));
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("Exception in UserDao::getAllPendingUsersBid()");
			e.printStackTrace();
		}
		return users;

	}

}


