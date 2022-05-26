import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TaCourse_result {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/final_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER = "test";
	static final String PASS = "1234";
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("TA Course ID: ");
		int taCourseID = scanner.nextInt();
		comments_result(taCourseID);
		scanner.close();
	}
	
	public static void comments_result(int taCourseID) {
	
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
			  
			   try (ResultSet resultSet = st.executeQuery("SELECT Overall,Clarity,Understandability,Text FROM tcomment where TACourseID ="+taCourseID )) {
				   System.out.println("Overall  Clarity  Understandability  Text");
				   while (resultSet.next())  {
			    	System.out.println(Integer.toString(resultSet.getInt(1))+"        "+
			    			Integer.toString(resultSet.getInt(2))+"        "+
			    			Integer.toString(resultSet.getInt(3))+"                  "+
			    			resultSet.getString(4)
			    			);
			    }
			    ;
			   }
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	}
}