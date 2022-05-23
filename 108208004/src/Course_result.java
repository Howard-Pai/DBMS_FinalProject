import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Course_result {
	// mysql
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/final_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER = "test";
	static final String PASS = "1234";
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Course ID: ");
		int courseID = scanner.nextInt();
		comments_result(courseID);
	
	}
	
	public static void comments_result(int courseID) {
	
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
			  
			   try (ResultSet resultSet = st.executeQuery("SELECT Overall,Sweetness,Loading,Difficulty,Ranking,Text FROM ccomment where CourseID ="+courseID )) {
				   System.out.println("Overall  Sweetness  Loading  Difficulty  Ranking  Text");
				   for (int i=0;resultSet.next();i++) {
			    	System.out.println(Integer.toString(resultSet.getInt(1))+"        "+
			    			Integer.toString(resultSet.getInt(2))+"          "+
			    			Integer.toString(resultSet.getInt(3))+"        "+
			    			Integer.toString(resultSet.getInt(4))+"           "+
			    			Integer.toString(resultSet.getInt(5))+"        "+
			    			resultSet.getString(6)
			    			);
			    }
			    ;
			   }
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	}
	
	
}