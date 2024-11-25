package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.Scanner;

public class SeventhProgram {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
//		ResultSet rs = null;	
		Scanner sc = new Scanner(System.in);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june?user=root&password=Tanuj@123");
			System.out.println("Connection Established");
			
			String sql1 = "UPDATE kodbank SET Balance = Balance - ? WHERE AccNo=?";
			String sql2 = "UPDATE kodbank SET Balance = Balance + ? WHERE AccNo=?";
			
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			
			System.out.println("Enter from account no and to account no and amount to be transferred");
			
			int facc = sc.nextInt();
			int tacc = sc.nextInt();
			int amt = sc.nextInt();
			
			pstmt1.setInt(1, amt);
			pstmt1.setInt(2, facc);
			pstmt2.setInt(1, amt);
			pstmt2.setInt(2, tacc);
			
			con.setAutoCommit(false);
			
			int res1=pstmt1.executeUpdate();
			int res2=pstmt2.executeUpdate();
			
			System.out.println(res1 + " " + res2);
			
			con.commit();
			
		}
		catch(Exception e) {
			try {
				System.out.println("Some issue occoured");
				con.rollback();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		finally {
			try {
				con.close();
				pstmt1.close();
				pstmt2.close();
				sc.close();
//				rs.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
