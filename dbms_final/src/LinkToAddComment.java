

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddComment
 */
@WebServlet(name="/LinkToAddComment",urlPatterns={"/LinkToAddComment"})
public class LinkToAddComment extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";
	
	public static PrintWriter out = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinkToAddComment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------LinkToAddComment--------");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		int courseID = 0;
		int taCourseID = 0;
		int studentID = 0;
	
		if(request.getParameter("studentID")==null) {
			response.sendRedirect("login.jsp");
		}else {
			studentID = Integer.parseInt(request.getParameter("studentID"));
			if (request.getParameter("CourseID")!=null) {
				courseID = Integer.parseInt(request.getParameter("courseID"));
				System.out.println("courseID:"+courseID);
				System.out.println("studentID:"+studentID);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Driver loaded!");
				}catch (ClassNotFoundException e) {
					System.out.println("Can't find driver!");
					e.printStackTrace();
				}
				try {
					Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("mysql Connection Success");
					Statement st= conn.createStatement();
					try{
						ResultSet resultSet= st.executeQuery("Select CourseName,Semester from course where CourseID="+courseID);
						resultSet.next();
						String courseName = resultSet.getString(1);
						String semester = resultSet.getString(2);
						request.setAttribute("courseName", courseName);
						request.setAttribute("semester", semester);
						request.setAttribute("courseID", courseID);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("studentID",studentID);
				request.getRequestDispatcher("addComment.jsp").forward(request, response);
			}else if(request.getParameter("taCourseID")!=null){
				taCourseID = Integer.parseInt(request.getParameter("taCourseID"));
				System.out.println("taCourseID:"+courseID);
				System.out.println("studentID:"+studentID);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Driver loaded!");
				}catch (ClassNotFoundException e) {
					System.out.println("Can't find driver!");
					e.printStackTrace();
				}
				try {
					Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("mysql Connection Success");
					Statement st= conn.createStatement();
					try{
						ResultSet resultSet= st.executeQuery("Select taCourseName from tacourse where taCourseID="+taCourseID);
						resultSet.next();
						String taCourseName = resultSet.getString(1);
						request.setAttribute("taCourseName", taCourseName);
						request.setAttribute("taCourseID", taCourseID);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("studentID",studentID);
				request.getRequestDispatcher("addTAComment.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
