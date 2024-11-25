package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class EightProgram {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;	
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june?user=root&password=Tanuj@123");
			System.out.println("Connection Established");
			
			String sql="call new_procedure(?)";
			cstmt = con.prepareCall(sql);
			
			System.out.println("Enter Accno");
			int accno = sc.nextInt();
			cstmt.setInt(1,accno);
			boolean res = cstmt.execute();
			
			if(res==true) {
				rs=cstmt.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
				}
			}
			else {
				int uc=cstmt.getUpdateCount();
				System.out.println(uc + "Rows Affected");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
