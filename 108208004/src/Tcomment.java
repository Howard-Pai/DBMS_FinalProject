import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tcomment {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/final_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER = "test";
	static final String PASS = "1234";
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("TACourseID(123): ");
		int tacourseid = scanner.nextInt();
		System.out.println("StudentID(108208001): ");
		int studentid = scanner.nextInt();
		System.out.println("Overall(1~5): ");
		int overall = scanner.nextInt();
		System.out.println("Clarity(1~5): ");
		int clarity = scanner.nextInt();
		System.out.println("Understandablity(1~5): ");
		int understandability = scanner.nextInt();
		System.out.println("Text: ");
		String text = scanner.next();
		
		comment(tacourseid,studentid,overall,clarity,understandability,text);
		
	
	}
	
	
	public static void comment(int tacourseid,int studentid,int overall,int clarity,int understandability,String text) {
		try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find driver");
			e.printStackTrace();
		}
		
		  try {
			  Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
			  System.out.println("mysql Connection Success");
			  Statement st= conn.createStatement();
			  
			   try{
				   ResultSet resultSet= st.executeQuery("Select max(TCommentID) from tcomment");
				   resultSet.next();
				   int newCID = resultSet.getInt("max(TCommentID)")+1;
				   st.executeUpdate("INSERT INTO tcomment VALUES(" + newCID+ "," +studentid + "," +tacourseid + "," + overall+ "," + clarity +"," + understandability+",\""+text+"\")");
				   System.out.print("comment Successful");
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
	}
}