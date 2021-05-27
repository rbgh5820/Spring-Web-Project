package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	private static Connection conn;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		try {
			//본인 DB아이피 주소,DB이름,아이디,패스워드
			conn = DriverManager.getConnection("jdbc:mariadb://10.40.10.69:3306/test","root","12431243a");
			pstmt = conn.prepareStatement("insert into user values(?,?,?,?)");//prepareStatement문구로 쿼리를 수행
			pstmt.setInt(1, 3); // userid
			pstmt.setString(2, "estar"); // username
			pstmt.setString(3, "estar@gmail.com"); // email
			pstmt.setString(4, "010-3138-8899"); // phone
			pstmt.executeUpdate(); // SQL문 실행에 쓰이는데 사용하는 메소드
			
			System.out.println("입력이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
