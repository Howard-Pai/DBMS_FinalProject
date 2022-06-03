import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ReminderFunction {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/final_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "test";
	static final String PASS = "1234";
	
	
	public static void main(String[] args) {
		//搜尋日期處理
		System.out.println("請輸入要查詢的時間，Ex:108-09-2、108-11-15");
		Scanner in = new Scanner(System.in);
		String searchDate = in.next();
		
		/** 有空再做
		if(searchDate.contains("-")) {
			if( searchDate.substring(3, 4).equals("-") ){
				
			}
		}else if(searchDate.contains("/")) {
			
		}else if(searchDate.contains("")) {
			
		}
		*/
		
		/** 當需要做進階日期轉換時(0902、9/2、09-02
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date udt=null;
		DateFormat df = DateFormat.getDateInstance();
		try{
			udt = sdf.parse(searchDate);
		}catch(Exception e){
			e.printStackTrace();
		}
		java.sql.Date sdt = new java.sql.Date(udt.getTime());
		*/
		
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
			//之後要加上評分的資料庫 然後抓出來
			try (ResultSet resultSet = st.executeQuery("SELECT Date,Text FROM reminder WHERE Date=\""+searchDate+"\"")) {
				//resultSet.next();
				//String aa = resultSet.getString("Date");
				//System.out.println(aa.equals(searchDate));
				
				System.out.println("read data Success!");
				String[] columnNames = { "Date","Text"};
				/** 表頭 有空可以變成format形，暫時不知道這是幹嘛的
				for (int i=0;i<4;i++) {
					System.out.print(columnNames[i]+"          ");
				}
				System.out.println("");
				*/
				String[][] datas = new String[10][2]; //"[10][4] 以後可以設為 找到幾筆資料，欄位就放那個數字"
				int i = 0;
				while (resultSet.next()) {
					System.out.println(resultSet.getString("Date") + "    " + resultSet.getString("Text"));
					//System.out.println(i);
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
	}

}
