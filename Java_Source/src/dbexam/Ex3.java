package dbexam;

import java.sql.*;

public class Ex3 {
  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/madang";
    String user = "root";
    String password = "aA!12345";
    String sql = "SELECT * FROM Book WHERE publisher = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt = conn.prepareStatement(sql);) {

      pstmt.setString(1, "대한미디어");

      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) { // 다음 투플이 있는경우 true, 없으면 false
        int bookid = rs.getInt("bookid");
        String bookname = rs.getString("bookname");
        String publisher = rs.getString("publisher");
        int price = rs.getInt("price");

        System.out
            .println("bookid = " + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price);
      }
      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
