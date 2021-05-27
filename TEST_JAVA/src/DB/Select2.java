package DB;

import java.sql.*;

public class Select2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			//test = DB이름,root=DB계정
			con = DriverManager.getConnection("jdbc:mariadb://10.40.10.69:3306/test","root","12431243a");
			
			//userid가 1또는 3인 쿼리를 조회하는것
			String query = "select * from user where userid=? or userid=?";
			//기본 select 쿼리문 String query = "select * from user";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,1); // 특정 개수의 쿼리를 읽어올때 사용한다.
			pstmt.setInt(2,3); 
			
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t이름\t이메일\t\t\t전화번호");
			
			while(rs.next()) {
				int userid = rs.getInt("userid");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				System.out.println(userid+"\t"+username+"\t"+email+"\t"+phone+"\t");
				
			}
		} 
		catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
		catch (SQLException e) {
            e.printStackTrace();
		} 
		finally{
			if (pstmt != null)
			try {
				pstmt.close();
			} 
			catch (SQLException e) {
			}
		}
			
			
		if (rs != null) {
			try {
				rs.close();
			} 
			catch (SQLException e) {
			}
		}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}

	}
}
