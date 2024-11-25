package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class FourthProgram {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		try {
//			Loading the drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
//			Established conneciton
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june?user=root&password=Tanuj@123");
			System.out.println("Connection Established");
			
			String sql = "delete from batches where id = ?";
			
//			Statement prepared
			pstmt=con.prepareStatement(sql);
			System.out.println("Statement prepared");
			System.out.println("Enter Batch Id");
			int id =sc.nextInt();
			pstmt.setInt(1,id);
			
//			Querying
			int nora = pstmt.executeUpdate();
			System.out.println("Query executed");
			System.out.println(nora + " Row deleted");
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				pstmt.close();
				sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
 	}
}
