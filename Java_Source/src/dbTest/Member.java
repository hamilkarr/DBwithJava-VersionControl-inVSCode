package dbTest;

import java.sql.*;

public class Member {
  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/madang";
    String user = "root";
    String password = "aA!12345";

    String sql = "CALL InsertMember(?,?,?,?)";
    // String sql2 = "Select * From Member";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        CallableStatement cstmt = conn.prepareCall(sql);) {
      System.out.println("로그인 성공!!");
      if (args.length != 4) {
        System.out.println("사용법 확인 요망");
        System.exit(1);
      }
      cstmt.setInt(1, Integer.parseInt(args[0]));
      cstmt.setString(2, args[1]);
      cstmt.setString(3, args[2]);
      cstmt.setString(4, args[3]);
      int rs = cstmt.executeUpdate();
      System.out.println("affected rows: " + rs);

      String sql2 = "DELETE FROM member WHERE memNo = ?";
      // ResultSet rs3 = cstmt.executeQuery();

      // ResultSet rs2 = pstmt.executeQuery();
      // while (rs2.next()) {
      // int bookid = rs2.getInt("bookid");
      // String bookname = rs2.getString("bookname");
      // String publisher = rs2.getString("publisher");
      // int price = rs2.getInt("price");

      // System.out.println(
      // "bookid: " + bookid + ", bookname: " + bookname + ", publisher: " + publisher
      // + ", price: " + price);
      // }
      // rs2.close();
    } catch (SQLException e) {
      System.out.println("로그인 실패....");
      e.printStackTrace();
    }
  }
}
