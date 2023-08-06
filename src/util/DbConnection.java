package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getConnection()
	{    
		String dbUrl="jdbc:mysql://localhost:3306/job_portal";
		String driver="com.mysql.cj.jdbc.Driver";
		String username="root";
		String password="param123";
		Connection con=null;
		  
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(dbUrl,username,password);
				if(con!=null)
				{
					System.out.println("DbConnected.....");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		DbConnection db = new DbConnection();
		db.getConnection();
	}

}
