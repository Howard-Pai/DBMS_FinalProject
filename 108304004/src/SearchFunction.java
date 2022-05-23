import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class SearchFunction {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/finalProject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaa111ccc";
	
	public static void main(String[] args) {
		System.out.println("請輸入要查詢的課程名稱或教授名稱:");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		System.out.println("輸入1或2選擇正課或TA課 : 1.正課 2.TA課");
		int choices = in.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!");
		}catch (ClassNotFoundException e) {
			System.out.println("Can't find driver");
			e.printStackTrace();
		}
		
		//正課的搜尋結果
		if (choices==1) {
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("mysql Connection Success ");
				Statement st = conn.createStatement();
				//之後要加上評分的資料庫 然後抓出來
				try (ResultSet resultSet = st.executeQuery("SELECT CourseID,CourseName,Professor,Semester FROM course WHERE CourseName LIKE '%"+input+"%' OR Professor Like '%"+input+"%'GROUP BY CourseName,Professor,Semester,Department")) {
					System.out.println("read data Success!");
					String[] columnNames = { "CourseName","Professor","Semester","Score"};
					/** 表頭 有空可以變成format形，暫時不知道這是幹嘛的
					for (int i=0;i<4;i++) {
						System.out.print(columnNames[i]+"          ");
					}
					System.out.println("");
					*/
					
					ArrayList<Integer> courseId = new ArrayList<Integer>();//用來存取CourseID
					
					String[][] datas = new String[10][3]; //"[10][4] 以後可以設為 找到幾筆資料，欄位就放那個數字"
					int i = 0;
					
					while (resultSet.next()) {
						courseId.add(resultSet.getInt("CourseID"));
						System.out.println(resultSet.getString("CourseName") + "    " + resultSet.getString("Professor") + "    "
								+ resultSet.getString("Semester") + "    Score");
						//System.out.println();
						String[] tempdata = new String[3];
						/** 跑出一堆null的東西 還沒看是幹嘛
						for (int ii = 2; ii < 6; ii++) {
							System.out.println(resultSet.getString(ii));
							tempdata[ii-2] = resultSet.getString(ii);
						}
						*/
						//還沒用到 笑死 datas[i]=tempdata;
						i++;
						//System.out.println();
					}
					//測試CourseID
					for(Integer id : courseId) {
						int ID = id.intValue();
						System.out.println("CourseID: "+ID);
					}
					/**
					for(int j=0;j<datas.length;j++) {
						for(int k=0;k<datas[0].length;k++) {
							System.out.println(datas[j][k]);
						}
					}
					*/
				}
				catch (SQLException e) {
							e.printStackTrace();
							System.out.println("Error!");
				}
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error");
			}
		}else if(choices==2){ //TA課搜尋結果
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("mysql Connection Success ");
				Statement st = conn.createStatement();
				//之後要加上評分的資料庫 然後抓出來
				try (ResultSet resultSet = st.executeQuery("SELECT TaCourseID,TaCourseName,TaName FROM TaCourse WHERE TaCourseName LIKE '%"+input+"%' OR TaName LIKE '%"+input+"%' GROUP BY TaCourseName,TaName")) {
					System.out.println("read data Success!");
					String[] columnNames = { "CourseName","TaName","Score"};
					/** 表頭 有空可以變成format形，暫時不知道這是幹嘛的
					for (int i=0;i<4;i++) {
						System.out.print(columnNames[i]+"          ");
					}
					System.out.println("");
					*/
					ArrayList<Integer> taCourseId = new ArrayList<Integer>();
					String[][] datas = new String[10][3]; //"[10][4] 以後可以設為 找到幾筆資料，欄位就放那個數字"
					int i = 0;
					while (resultSet.next()) {
						taCourseId.add(resultSet.getInt("TaCourseID"));
						System.out.println(resultSet.getString("TaCourseName") + "    " + resultSet.getString("TaName") + "    "
								+ "    Score");
						//System.out.println();
						String[] tempdata = new String[3];
						/** 跑出一堆null的東西 還沒看是幹嘛
						for (int ii = 2; ii < 6; ii++) {
							System.out.println(resultSet.getString(ii));
							tempdata[ii-2] = resultSet.getString(ii);
						}
						*/
						//還沒用到 笑死 datas[i]=tempdata;
						i++;
						//System.out.println();
					}
					for(Integer id : taCourseId) {
						int ID = id.intValue();
						System.out.println("TaCourseID: "+ID);
					}
					/**
					for(int j=0;j<datas.length;j++) {
						for(int k=0;k<datas[0].length;k++) {
							System.out.println(datas[j][k]);
						}
					}
					*/
				}
				catch (SQLException e) {
							e.printStackTrace();
							System.out.println("Error!");
				}
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error");
			}
		}else {
			System.out.println("請輸入1或2來測試!");
		}
		
		
	}
}