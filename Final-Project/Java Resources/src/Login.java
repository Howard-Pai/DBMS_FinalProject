package src;

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

public class Login {
	// mysql
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/final_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER = "test";
	static final String PASS = "1234";
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Login or Register: ");
		String choice = scanner.next();
		if(choice.equalsIgnoreCase("login")) {
			System.out.println("Account(StudentID): ");
			int account = Integer.parseInt(scanner.next());
			System.out.println("Password: ");
			String password = scanner.next();
			login(account,password);
		}	
		else if(choice.equalsIgnoreCase("register")){
			System.out.println("Account(StudentID): ");
			int account = Integer.parseInt(scanner.next());
			System.out.println("Name: ");
			String name = scanner.next();
			System.out.println("Password: ");
			String password = scanner.next();
			System.out.println("Major: ");
			String major = scanner.next();
			System.out.println("Mail: ");
			String mail = scanner.next();
			register(account,name,password,major,mail);
		}
	
	}
	
	public static Map<Integer,String> account_data() {
		Map<Integer, String> map= new HashMap<>();
		//String[][] data = new String[1000][1]; 
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
			  
			   try (ResultSet resultSet = st.executeQuery("SELECT StudentID, Password FROM STUDENT")) {
			    for (int i=0;resultSet.next();i++) {
			    	//data[i][0] = resultSet.getString("StudentID");
			    	//data[i][1] = resultSet.getString("StudentName");
			    	map.put(resultSet.getInt("StudentID"), resultSet.getString("Password"));
			    }
			   }
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
		return map;
	}
	
	public static void login(int account,String password) {
		Map<Integer, String> map= new HashMap<>();
		map=account_data();
		if(map.containsKey(account)) {
			if(map.get(account).equals(password)) {
				System.out.println("login successful");
			}else {
				System.out.println("login failed - Incorrect Password");
			}
		}else {
			System.out.println("login failed - No such an account");
		}
	}
	
	public static void register(int account,String name,String password,String major,String mail) {
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
				   st.executeUpdate("INSERT INTO STUDENT VALUES(" + account+ "," + name+ "," + password+ "," + major+ "," + mail +")");
				   System.out.print("Registration Successful");
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
	}
}