package dbexam;

import java.sql.*;

public class Ex1 {
  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String user = "root";
    String password = "aA!12345";
    String url = "jdbc:mysql://localhost:3306/madang";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      System.out.println("연결 성공!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
