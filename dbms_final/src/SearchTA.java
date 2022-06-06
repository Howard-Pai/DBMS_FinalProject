import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/SearchTA")
public class SearchTA extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTA() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------SearchTA--------");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");  
		String keyword =  request.getParameter("keyword");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!");
		}catch (ClassNotFoundException e) {
			System.out.println("Can't find driver");
			e.printStackTrace();
		}		
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("mysql Connection Success ");
			Statement st = conn.createStatement();
	
			try (ResultSet resultSet = st.executeQuery("SELECT tacourse.TaCourseID,TaCourseName,TaName,avg(overall) FROM tacourse left join tcomment on tacourse.taCourseID = tcomment.taCourseID WHERE taCourseName LIKE '%"+keyword+"%' OR taName Like '%"+keyword+"%' GROUP BY taCourseName,taName")) {
				System.out.println("read data Success!");
				
				ArrayList<Integer> taCourseID = new ArrayList<Integer>();
				int i = 0;
				while (resultSet.next()) {
					taCourseID.add(resultSet.getInt("TaCourseID"));
					
					request.setAttribute("addComment"+i,"我要評論");
					request.setAttribute("taCourseID"+i,taCourseID.get(i));
					request.setAttribute("taCourseName"+i, resultSet.getString("TaCourseName"));
					request.setAttribute("taName"+i, resultSet.getString("TaName"));
					request.setAttribute("score"+i, resultSet.getInt("avg(overall)"));
					i++;
				}
				System.out.println("共有幾筆資料:"+i);
			}
			catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Error!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error!");
		}
		if(request.getParameter("studentID")==null) {
			System.out.println("studentID==null");
			request.getRequestDispatcher("searchTA.jsp").forward(request, response);
		}else {
			System.out.println("studentID!=null");
			request.setAttribute("studentID", request.getParameter("studentID"));
			request.getRequestDispatcher("loginSearchTA.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
