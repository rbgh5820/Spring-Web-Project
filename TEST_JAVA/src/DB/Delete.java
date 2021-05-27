package DB;

import java.sql.*;

public class Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 String driver = "org.mariadb.jdbc.Driver";
	 String url = "jdbc:mariadb://10.40.10.69:3306/test";
	 String user = "root";
	 String pw = "12431243a";
	 
	 Connection con = DriverManager.getConnection(url,user,pw);
	 System.out.println("연결 성공");
	 
	 Statement stmt = con.createStatement();
	 
	 String sql = "delete from user where userid='3'";
	 
	 int result = stmt.executeUpdate(sql);
	 System.out.println(result+"데이터 삭제됨");
	 stmt.close();
	 con.close();
	}
}