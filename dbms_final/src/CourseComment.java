

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
@WebServlet(name="/CourseComment",urlPatterns={"/CourseComment"})
public class CourseComment extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";
	
	public static PrintWriter out = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------CourseComment--------");
		
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		System.out.println("courseID:"+courseID);
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
			try (ResultSet resultSet = st.executeQuery("SELECT ccomment.CourseID,Professor,Sweetness,Loading,Difficulty,Text FROM ccomment LEFT JOIN course ON ccomment.CourseID="+courseID+" where ccomment.CourseID = course.CourseID")) {
				System.out.println("Select Success");
				float avgSweetness = 0;
				float avgLoading = 0;
				float avgDifficulty = 0;
				//ArrayList<String> comment = new ArrayList<String>();
				String comment = "";
				int i=0;
				while(resultSet.next()) {	
					if(i==0) {
						request.setAttribute("courseName",resultSet.getString(1));
						request.setAttribute("professor",resultSet.getString(2));
					}
					avgSweetness = avgSweetness + resultSet.getInt(3);
					avgLoading = avgLoading + resultSet.getInt(4);
					avgDifficulty = avgDifficulty + resultSet.getInt(5);
					System.out.println("avgSweetness:"+avgSweetness+"/avgLoading:"+avgLoading+"/avgDifficulty:"+avgDifficulty);
					//comment.add(resultSet.getString(6));
					comment= comment+resultSet.getString(6)+"</br>";
					i++;
				};
				avgSweetness = (float)Math.round(100*(avgSweetness/i))/100;
				avgLoading = (float)Math.round(100*(avgLoading/i))/100;
				avgDifficulty = (float)Math.round(100*(avgDifficulty/i))/100;
				request.setAttribute("sweetness", avgSweetness);
				request.setAttribute("loading", avgLoading);
				request.setAttribute("difficulty", avgDifficulty);
				request.setAttribute("comment",comment);
				
				request.getRequestDispatcher("courseComment.jsp").forward(request,response);
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
