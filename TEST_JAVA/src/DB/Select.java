package DB;

import java.sql.*;

public class Select {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public Select() {
		try {
			String driver = "org.mariadb.jdbc.Driver"; // DB드라이버
			String url="jdbc:mariadb://10.40.10.69:3306/test"; 
			String user ="root"; // DB계정
			String password = "12431243a"; // DB 패스워드
			
			con = DriverManager.getConnection(url,user,password); // DB 연결
			System.out.println("연결 성공");
			
			stmt = con.createStatement(); // DB객체 생성
			System.out.println("객체 생성 성공");
			
			rs = stmt.executeQuery("select * from user"); //조회한 결과를 rs에 저장한다.
			
			while(rs.next()) { // rs.next()로 다음행이 없을때까지 while문으로 루프를 돌린다
				//getInt(1)은 1열의 값은 정수형으로 getString(2)는 2열의 값은 문자열로 가져온다.
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t");
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e) { //SQL문 예외값이 나올경우 오류 메세지를 남긴다.
			System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
			System.out.print("사유 : " + e.getMessage());
		}
	}
	
	public static void main(String[] args)  {
		new Select();
	}
}
