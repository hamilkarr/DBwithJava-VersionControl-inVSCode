package dbexam;

import java.sql.*;
import java.util.Arrays;

public class Ex5 {
  public static void main(String[] args) throws ClassNotFoundException {
    if (args.length == 0) {
      System.out.println("사용법 확인 요망");
      System.exit(0);
    }

    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql//localhost:3306/madang";
    String user = "root";
    String password = "aA!12345";
    String sql = "INSERT INTO Book VALUES(?,?,?,?)";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt = conn.prepareStatement(sql);) {
      pstmt.setInt(1, Integer.parseInt(args[0]));
      pstmt.setString(2, args[1]);
      pstmt.setString(3, args[2]);
      pstmt.setInt(4, Integer.parseInt(args[3]));

      int rs = pstmt.executeUpdate();
      System.out.println("affected rows : " + rs);

    } catch (SQLException e) {

      e.printStackTrace();
    }
  }
}
