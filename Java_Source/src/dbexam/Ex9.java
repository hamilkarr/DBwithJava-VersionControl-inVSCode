package dbexam;

import java.sql.*;

public class Ex9 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/madang";
		String user = "root";
		String password = "aA!12345";
		// 리소스 -> 닫기(conn.close())
		String sql = "SELECT * FROM Book WHERE publisher = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "이상미디어");
			ResultSet rs = pstmt.executeQuery();
			
			/*
			 rs.next() -> 다음 투플이 있는지 체크하고(true, false) -> 다음 투플로 이동
			*/
			while(rs.next()) {
				/**
				 *  getXxx("속성의 순서 번호 - 1");
				 *  getXxx("속성명")
				 */
				int bookid = rs.getInt("bookid");
				String bookname = rs.getString("bookname");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				
				System.out.println("bookid = " + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price);
			}
			
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
