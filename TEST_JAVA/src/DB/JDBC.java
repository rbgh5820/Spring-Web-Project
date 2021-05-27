package DB;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
 

public class JDBC {
	String driver = "org.mariadb.jdbc.Driver";
    Connection conn;
    public void DBconn() {
          //드라이버 :// ip : 포트번호 / 데이터베이스 이름 (ip는 자신의 ip)
          String url = "jdbc:mariadb://10.40.10.69:3306/test";
          //계정명 : root
          String user = "root";
          //마리아DB 본인 패스워드
          String password = "12431243a";
          //sql 쿼리
          
          try {
                Class.forName(driver);
          } catch (ClassNotFoundException e) {
                System.out.println("드라이버 로드 실패");
                e.printStackTrace();
          }
          try {
                conn = DriverManager.getConnection(url, user, password);
                if (conn != null) {
                      System.out.println("DB접속 성공");
                }
          } catch (SQLException e) {
                System.out.println("DB접속 실패");
                e.printStackTrace();
          }
    }
    public static void main(String[] args) {
          JDBC dbconn = new JDBC();
          dbconn.DBconn();
    }
}
