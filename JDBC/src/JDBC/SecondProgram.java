package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SecondProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
//			Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
//			Established Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june?user=root&password=Tanuj@123");
			System.out.println("Connection Established");
			
			String sql = "select * from batches where id = ?";
			
//			Creating the preparedStatement medium
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter id of the batch");
			int id = sc.nextInt();
			ps.setInt(1, id);
			System.out.println("Prepared Statement Created");
			
//			Query
			ResultSet rs = ps.executeQuery();
			System.out.println("Query Executed");
			
//			Display result
			while(rs.next()==true) {
				System.out.println(rs.getInt(1)+ " "+rs.getString(2));
			}
			
			con.close();
			ps.close();
			rs.close();
			sc.close();
			System.out.println("Resources closed");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
