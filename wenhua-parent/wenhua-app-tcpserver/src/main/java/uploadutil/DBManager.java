package uploadutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	 private static Connection conn=null;
     private static ResultSet rs=null;
     private static PreparedStatement pstmt=null;
     public static final String url = "jdbc:mysql://localhost/qcms";  
     public static final String name = "com.mysql.jdbc.Driver";  
     public static final String user = "root";  
     public static final String password = "111111";  
     public  static Connection getConnection(){
  	   try {
			Class.forName(name);
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
  	   
		return conn;
  	   
		
  	   
  	   
     }
     public static void closeResource(ResultSet rs,PreparedStatement pstmt,Connection conn){
  	   if(rs!=null){
  		   try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	   }
  	   if(pstmt!=null){
  		   try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	   }
  	   if(conn!=null){
  		   try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	   }
  	   
  	   
     }

}
