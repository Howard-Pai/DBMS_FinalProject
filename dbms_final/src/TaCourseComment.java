import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseComment
 */
@WebServlet(name="/TaCourseComment",urlPatterns={"/TaCourseComment"})
public class TaCourseComment extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";
	
	public static PrintWriter out = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaCourseComment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------TaCourseComment--------");
		
		int taCourseID = Integer.parseInt(request.getParameter("taCourseID"));
		System.out.println("taCourseID:"+taCourseID);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
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
			try (ResultSet resultSet = st.executeQuery("SELECT tacourse.taCourseName,taName,Clarity,Understandability,Text FROM tcomment LEFT JOIN taCourse ON tcomment.taCourseID="+taCourseID+" where tcomment.taCourseID = taCourse.taCourseID")) {
				System.out.println("Select Success");
				float avgClarity = 0;
				float avgUnderstandability = 0;
				String comment = "";
				int i=0;
				while(resultSet.next()) {	
					if(i==0) {
						request.setAttribute("taCourseName",resultSet.getString(1));
						request.setAttribute("taName",resultSet.getString(2));
					}
					avgClarity = avgClarity + resultSet.getInt(3);
					avgUnderstandability = avgUnderstandability + resultSet.getInt(4);
					System.out.println("avgClarity:"+avgClarity+"/avgUndersandability:"+avgUnderstandability);
					comment= comment+resultSet.getString(5)+"</br>";
					i++;
				};
				avgClarity = (float)Math.round(100*(avgClarity/i))/100;
				avgUnderstandability = (float)Math.round(100*(avgUnderstandability/i))/100;
				request.setAttribute("clarity", avgClarity);
				request.setAttribute("understandability", avgUnderstandability);
				request.setAttribute("comment",comment);
				
				request.getRequestDispatcher("taCourseComment.jsp").forward(request,response);
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error!");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
