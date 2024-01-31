package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMainPro {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Scanner s1=new Scanner(System.in);
		while(true) {
			intro();
			System.out.println("=======================");
			System.out.println("choose the operation:");
			int o=s1.nextInt();
			switch(o) {
			case 1:
				System.out.println("***************************************");
				System.out.println("*   *      INSERT RECORD   *     *     ");
				System.out.println("***************************************");
				insert();
				System.out.println("----------------------------------------");
				break;
			case 2:
				System.out.println("***************************************");
				System.out.println("*   *       EDIT RECORD    *     *     ");
				System.out.println("***************************************");
				edit();
				System.out.println("----------------------------------------");
				break;
			case 3:
				System.out.println("***************************************");
				System.out.println("*   *       VIEW RECORD    *     *     ");
				System.out.println("***************************************");
				view();
				System.out.println("----------------------------------------");
				
				break;
			case 4:
				System.out.println("***************************************");
				System.out.println("*   *      DELETE RECORD   *     *     ");
				System.out.println("***************************************");
				delete();
				System.out.println("----------------------------------------");
				break;
			case 5:
				System.exit(o);
				break;
			default:
			System.out.println("invalid number");
			break;
			}
		}
		
	
	}
	
	public static void delete() throws SQLException {
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root", "Nishanth@.123");
		Scanner in=new Scanner(System.in);
		System.out.println("enter the id to DELETE");
		int i= in.nextInt();
		String query="DELETE FROM student_info WHERE id=?";
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setInt(1,i);
		
		
		ps.executeUpdate();
		System.out.println("Data delete sucessfully....");
		
	}
public static void edit() throws SQLException {
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url, "root", "Nishanth@.123");
	String query="UPDATE student_info SET Name= ?, Std =?, Fname=?,Mobile =? WHERE (id =?);";
			
	PreparedStatement ps=con.prepareStatement(query);
	Scanner s=new Scanner(System.in);
	System.out.println("enter your id:");
	int i=s.nextInt();
	System.out.println("Enter your name:");
	s.nextLine();
	String n=s.nextLine();
	System.out.println("Enter your Class:");
	String c=s.nextLine();
	System.out.println("Enter your father name:");
	String f=s.nextLine();
	System.out.println("Enter your Mobile no:");
	String m=s.nextLine();
	
	ps.setInt(5,i);
	ps.setString(1,n);
	ps.setString(2,c);
	ps.setString(3,f);
	ps.setString(4,m);
	
	
	ps.executeUpdate();
	System.out.println("Data updated sucessfully....");
	
}
	public static void view() throws SQLException {
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url, "root", "Nishanth@.123");
		Statement st=con.createStatement();
		//step4:
		ResultSet rs=st.executeQuery("select * from student_info ");
		System.out.println("ID | NAME | CLASS | FATHER | MOBILE");
		System.out.println("***********************************");
		while(rs.next()) {
			System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5));
		}
	}
	public static void insert() throws SQLException {
		Scanner s=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url, "root", "Nishanth@.123");
		System.out.println("Enter your name:");
		String n=s.nextLine();
		System.out.println("Enter your Class:");
		String c=s.nextLine();
		System.out.println("Enter your father name:");
		String f=s.nextLine();
		System.out.println("Enter your Mobile no:");
		String m=s.nextLine();
		
		String query="insert into student_info (Name,Std,Fname,Mobile)"+"value(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,n);
		ps.setString(2,c);
		ps.setString(3,f);
		ps.setString(4,m);
		ps.executeUpdate();
		System.out.println("data inserted sucessfully....");
		
	}
	
public static void intro() {
	System.out.println("*****************************");
	System.out.println("**     STUDENTS MODULE     **");
	System.out.println("*****************************");
	System.out.println("\n1.insert");
	System.out.println("2. Edit");
	System.out.println("3.View");
	System.out.println("4.delete");		
}
		
}

