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

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	//mysql
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";
	
	public static PrintWriter out = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------Register--------");
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		String studentName = request.getParameter("studentName");
		String major = request.getParameter("major");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		System.out.println("studentID:"+studentID);
		System.out.println("studentName:"+studentName);
		System.out.println("password:"+password);
		System.out.println("major:"+major);
		System.out.println("mail:"+mail);
		
		register(studentID,studentName,password,major,mail,request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static Map<Integer,String> account_data() {
		Map<Integer, String> map= new HashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch(ClassNotFoundException e) {
			System.out.println("Can't find driver");
			e.printStackTrace();
		}
		try {
			Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("mysql Connection Success");
			Statement st= conn.createStatement();
			try (ResultSet resultSet = st.executeQuery("SELECT StudentID, Password FROM STUDENT")) {
				for (int i=0;resultSet.next();i++) {
					map.put(resultSet.getInt("StudentID"), resultSet.getString("Password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	public static void register(int studentID,String studentName,String password,String major,String mail,HttpServletRequest request, HttpServletResponse response) {
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
				
				st.executeUpdate( "INSERT INTO STUDENT VALUES("+studentID+",'"+studentName+"','"+password+"','"+major+"','"+mail+"')" );
				System.out.println("Registration Successful");
				request.setAttribute("studentID", studentID);
				request.getRequestDispatcher("loginWeb.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
