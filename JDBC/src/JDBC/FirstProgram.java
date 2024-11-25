package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstProgram {

	public static void main(String[] args) {
		try {
//			Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
//			Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june","root","Tanuj@123");
			System.out.println("Connection Established");
			
//			Creating the statement medium
			Statement stmt = con.createStatement();
			System.out.println("Statement medium is created");
			
//			Query
			String sql = "SELECT * FROM batches";
			ResultSet rs =stmt.executeQuery(sql);
			
			System.out.println("Query executed and got the result set");
			
//			Display the result
			while(rs.next()==true) {
				System.out.println(rs.getInt(1) + "|" +rs.getString(2)+ " | " + rs.getInt(3));				
			}
			
//			Close the resources
			con.close();
			stmt.close();
			rs.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

