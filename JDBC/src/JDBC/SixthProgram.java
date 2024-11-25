package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SixthProgram {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		Scanner sc = new Scanner(System.in);
		try {
//			Loading the drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
//			Established conneciton
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june?user=root&password=Tanuj@123");
			System.out.println("Connection Established");
			
			String sql = "update batches set nos=? where id=?";
			
//			Statement prepared
			pstmt=con.prepareStatement(sql);
			System.out.println("Enter new nos and batch id to update");
			int nos=sc.nextInt();
			int id=sc.nextInt();
			pstmt.setInt(1,nos);
			pstmt.setInt(2,id);
			boolean res = pstmt.execute();
			
			if(res==true) {
				rs=pstmt.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " "+rs.getInt(2));
				}
			}
			else {
				int nora = pstmt.getUpdateCount();
				System.out.println(nora + "Rows affected");
			}
			
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
