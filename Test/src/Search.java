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
@WebServlet("/Search")
public class Search extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";
	
	public static PrintWriter out = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");  
		
		out =  response.getWriter();
		String keyword =  request.getParameter("keyword");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!</br>");
		}catch (ClassNotFoundException e) {
			System.out.println("Can't find driver</br>");
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("mysql Connection Success ");
			out.println("mysql Connection Success ");
			Statement st = conn.createStatement();
	
			try (ResultSet resultSet = st.executeQuery("SELECT course.CourseID,CourseName,Professor,Semester,avg(overall) FROM course left join ccomment on course.CourseID = ccomment.CourseID WHERE CourseName LIKE '%"+keyword+"%' OR Professor Like '%"+keyword+"%' GROUP BY CourseName,Professor,Semester,Department")) {
				System.out.println("read data Success!");
				out.println("read data Success!</br>");
				
				ArrayList<Integer> courseId = new ArrayList<Integer>();//用來存取CourseID
				
				String[][] datas = new String[10][3];
				int i = 0;
				
				while (resultSet.next()) {
					courseId.add(resultSet.getInt("CourseID"));
					
					request.setAttribute("addComment"+i,"我要評論");
					request.setAttribute("courseID"+i,courseId.get(i));
					request.setAttribute("courseName"+i, resultSet.getString("courseName"));
					request.setAttribute("professorName"+i, resultSet.getString("Professor"));
					request.setAttribute("semester"+i, resultSet.getString("Semester"));
					request.setAttribute("score"+i, resultSet.getInt("AVG(overall)"));
					
					i++;
					//System.out.println(i);
					
				}
				System.out.println("共有幾筆資料:"+i);
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}
			catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Error!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
