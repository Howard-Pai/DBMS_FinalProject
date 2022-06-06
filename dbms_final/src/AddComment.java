

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
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------AddComment--------");
		int taCourseID = Integer.parseInt(request.getParameter("taCourseID"));
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		int studentID=0;
		if (request.getParameter("studentID")==null) {
			
		}else {
			studentID = Integer.parseInt(request.getParameter("studentID"));
		}
		
		System.out.println("AddComment:courseID:"+courseID);
		System.out.println("AddComment:studentID:"+studentID);
		
		int overall = Integer.parseInt(request.getParameter("overall"));
		int sweetness = Integer.parseInt(request.getParameter("sweetness"));
		int loading = Integer.parseInt(request.getParameter("loading"));
		int difficulty = Integer.parseInt(request.getParameter("difficulty"));
		int rank = Integer.parseInt(request.getParameter("rank"));
		String textComment = request.getParameter("text_comment");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("AddComment:Driver loaded!");
		}catch (ClassNotFoundException e) {
			System.out.println("AddComment:Can't find driver!");
			e.printStackTrace();
		}
		try {
			Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("AddComment:mysql Connection Success");
			Statement st= conn.createStatement();
			try{
				ResultSet resultSet= st.executeQuery("Select max(CCommentID) from ccomment");
				resultSet.next();
				int newCID = resultSet.getInt("max(CCommentID)")+1;
				st.executeUpdate("INSERT INTO ccomment VALUES(" + newCID+ "," +courseID + "," + studentID+ "," + overall+ "," + sweetness +"," + loading +"," + difficulty +"," + rank+",\""+textComment+"\")");
				System.out.print("AddComment:comment Successful");
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
