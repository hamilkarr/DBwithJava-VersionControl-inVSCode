package dbexam;

import java.sql.*;

public class Ex4 {
  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/madang";
    String user = "root";
    String password = "aA!12345";
    String sql = "SELECT * FROM Book";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt = conn.prepareStatement(sql);) {
      // PreparedStatement
      // - setXxx(바인딩 순서(1....), 값)

      // System.out.println("연결 성공!!!!!");
      // pstmt.setString(1, "대한미디어");
      ResultSet rs = pstmt.executeQuery();
      // next() -> 다음 투플이 있는지 여부 체크. true/false
      while (rs.next()) {
        int bookid = rs.getInt("bookid");
        String bookname = rs.getString("bookname");
        String publisher = rs.getString("publisher");
        int price = rs.getInt("price");
        System.out
            .println("bookid= " + bookid + " bookname= " + bookname + " publisher= " + publisher + " price= " + price);
      }
      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
