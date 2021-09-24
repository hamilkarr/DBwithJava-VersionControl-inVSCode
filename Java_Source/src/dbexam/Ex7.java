package dbexam;

import java.sql.*;
import java.util.Properties;

// lounch.json  <- args 11 입력함.

public class Ex7 {

	public static void main(String[] args) throws ClassNotFoundException {
		if (args.length == 0) {
			System.err.println("사용방법 확인 요망!");
			System.exit(0);
		}

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/madang";
		Properties props = new Properties();
		props.put("user", "root");
		props.put("password", "aA!12345");

		String sql = "DELETE FROM Book WHERE bookid = ?";

		try (Connection conn = DriverManager.getConnection(url, props);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Integer.parseInt(args[0]));
			int rs = pstmt.executeUpdate();
			System.out.println("affected rows:" + rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
