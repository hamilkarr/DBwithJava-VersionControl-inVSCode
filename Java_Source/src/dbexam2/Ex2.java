package dbexam2;

import java.sql.*;
import java.util.Properties;

public class Ex2 {
  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Properties props = new Properties();
    props.put("user", "root");
    props.put("password", "aA!12345");

    String url = "jdbc:mysql://localhost:3306/madang";

    try (Connection conn = DriverManager.getConnection(url, props); Statement stmt = conn.createStatement();) {
      System.out.println("연결 성공");

      String sql = "Select * from Book";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {

        int bookid = rs.getInt("bookid");
        String bookname = rs.getString("bookname");
        String publisher = rs.getString("publisher");
        int price = rs.getInt("price");

        System.out
            .println("bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price);
      }
      rs.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
