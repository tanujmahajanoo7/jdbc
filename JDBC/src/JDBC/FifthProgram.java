package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class FifthProgram {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement st= null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver loaded");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/JUNE?user=root&password=Tanuj@123");
				System.out.println("establish conection");
				String sql ="update batches set name=? where id=?";
				st=con.prepareStatement(sql);
				System.out.println("statement prepared");
				// System.out.println("enter name ,id");
				System.out.println("eneter id ");
				int id=sc.nextInt();
				System.out.println("Enter name to upadate");
				String name=sc.next();
				st.setString(1, name);
				
				st.setInt(2, id);
				 int nora= st.executeUpdate();
				 System.out.println("qury excuted");
				 System.out.println(nora+" rows upadted");	
			}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				sc.close();
				con.close();
				st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
