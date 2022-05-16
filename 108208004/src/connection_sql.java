import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection_sql {
	// mysql
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/final_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER = "test";
	static final String PASS = "1234";

	// sql server

	static final String ms_sql_conn_string = "jdbc:sqlserver://DESKTOP-MC7678P;";
	static final String ms_sql_db = "database=" + "Final_Project;";
	static final String ms_sql_user = "user=" + "sa";
	static final String ms_sql_pass = "password=" + "1234";

	public static void main(String[] args) throws ClassNotFoundException {

		// run mysql
		connection_mysql();

		// run sqlserver
		//connection_sqlserver();
	}
	public static void connection_mysql() {
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

			   // Select city table
			   try (ResultSet resultSet = st.executeQuery("SELECT * FROM Course  limit 10")) {
			    while (resultSet.next()) {
			     System.out.println(resultSet.getString("CourseID") + "    " + resultSet.getString(
			      "CourseName") + "   " + resultSet.getString("Credit"));
			    }
			   }
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	}
	

	public static void connection_sqlserver() throws ClassNotFoundException {
		//sql server authentication
		String connectionUrl =
				ms_sql_conn_string
				+ms_sql_db
				+"authenticationScheme=JavaKerberos;"
				+ms_sql_user
				+ms_sql_pass
				+ "encrypt=true;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;"
                +"integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
		//windows authentication
		//String connectionUrl ="jdbc:sqlserver://localhost;databaseName=COMPANY;integratedSecurity=true;";

		
		try  {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver loaded!");
			Connection connection = DriverManager.getConnection(connectionUrl);
			System.out.println("MSSQL Connection Success");
			Statement statement = connection.createStatement();
			String selectSql = "SELECT top 10 * FROM dbo.Course";
			
			
			
			ResultSet  resultSet = statement.executeQuery(selectSql);
			//System.out.println(resultSet.next());
			while(resultSet.next()) {
			System.out.println(resultSet.getString("Fname"));
			}
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
