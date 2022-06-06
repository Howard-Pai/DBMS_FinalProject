

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
@WebServlet("/AddTAComment")
public class AddTAComment extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTAComment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------AddTAComment--------");
		int taCourseID = 0;
		int studentID = 0;
		taCourseID = Integer.parseInt(request.getParameter("taCourseID"));
		studentID = Integer.parseInt(request.getParameter("studentID"));
		
		System.out.println("AddComment:courseID:"+taCourseID);
		System.out.println("AddComment:studentID:"+studentID);
		
		int overall = Integer.parseInt(request.getParameter("overall"));
		int clarity = Integer.parseInt(request.getParameter("clarity"));
		int understandability = Integer.parseInt(request.getParameter("understandability"));
		String textComment = request.getParameter("text_comment");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("AddTAComment:Driver loaded!");
		}catch (ClassNotFoundException e) {
			System.out.println("AddTAComment:Can't find driver!");
			e.printStackTrace();
		}
		try {
			Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("AddTAComment:mysql Connection Success");
			Statement st= conn.createStatement();
			try{
				ResultSet resultSet= st.executeQuery("Select max(TCommentID) from tcomment");
				resultSet.next();
				int newTID = resultSet.getInt("max(TCommentID)")+1;
				
				System.out.println("newTID:"+newTID+"taCourseID:"+taCourseID+"studentID:"+studentID);
				
				st.executeUpdate("INSERT INTO tcomment VALUES("+newTID+","+studentID+","+taCourseID+","+overall+","+clarity+","+understandability+",\""+textComment+"\")");
				//INSERT INTO tcomment VALUES(6,11,127,1,1,1,'hii')
				
				System.out.print("AddTAComment:comment Successful");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("studentID", studentID);
		request.getRequestDispatcher("loginWeb.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
