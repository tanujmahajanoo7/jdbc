package disadvantages;

import java.sql.*;
import java.util.Scanner;

public class StudentPersist {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id,name,age,marks,gender");
		Student stu = new Student(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.next());
		try {
//			Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
//			Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june","root","Tanuj@123");
			System.out.println("Connection Established");
			
			String sql ="insert into student values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu.id);
			pstmt.setString(2, stu.name);
			pstmt.setInt(3, stu.age);
			pstmt.setInt(4, stu.marks);
			pstmt.setString(5, stu.gender);
			
			int nora = pstmt.executeUpdate();
			
			System.out.println(nora);
			
			con.close();
			pstmt.close();
			sc.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
