package dbTest;

import java.sql.*;

public class Member2 {
  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/madang";
    String user = "root";
    String password = "aA!12345";

    String sql = "CALL InsertMember(?,?,?)";
    String sql2 = "DELETE FROM member WHERE memNo = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
        CallableStatement cstmt = conn.prepareCall(sql);
        CallableStatement cstmt2 = conn.prepareCall(sql2);) {
      System.out.println("로그인 성공!!");

      // 회원 추가: argument값을 회원아이디, 비밀번호, 회원이름 "3가지" 모두 입력할 경우
      if (args.length == 3) {
        cstmt.setString(1, args[0]);
        cstmt.setString(2, args[1]);
        cstmt.setString(3, args[2]);
        int rs = cstmt.executeUpdate();
        System.out.println("추가한 회원 수는: " + rs + "명 입니다.");
      }

      // 회원 삭제: argument 값을 회원 번호 "하나만" 입력할 경우
      else if (args.length == 1) {
        cstmt2.setInt(1, Integer.parseInt(args[0]));
        int rs2 = cstmt2.executeUpdate();
        System.out.println("삭제한 회원 수는: " + rs2 + "명 입니다.");
      }

      // 입력 오류: argument 값을 양식에 맞지 않게 입력할 경우
      else {
        System.out.println("사용법을 확인하세요.");
        System.exit(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
