import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Action_test
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
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
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		try {
			out =  response.getWriter();
			int account = Integer.parseInt(request.getParameter("account"));
			String password = request.getParameter("password");
			login(account,password,request,response);
			
		}catch(Exception e){
			out.println("Error:"+e.getStackTrace());
		}
	}
	
	public static Map<Integer,String> account_data() {
		Map<Integer, String> map= new HashMap<>();
		//String[][] data = new String[1000][1]; 
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
	
	public static void login(int account,String password,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Map<Integer, String> map= new HashMap<>();
		map=account_data();
		if(map.containsKey(account)) {
			if(map.get(account).equals(password)) {
				System.out.println("login successful");
				request.setAttribute("username", account);
				System.out.println(request.getAttribute("username"));
				request.getRequestDispatcher("loginWeb.jsp").forward(request,response);
				System.out.println("forward");
				//response.sendRedirect("loginWeb.jsp");
			}else {
				out.println("login failed - Incorrect Password</br>");
			}
		}else {
			out.println("login failed - No such an account</br>");
		}
	}
}
