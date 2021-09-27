package dbexam2;

import java.sql.*;

class Ex1 {
  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/madang";
    String user = "root";
    String password = "aA!12345";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      System.out.println("연결 성공!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
