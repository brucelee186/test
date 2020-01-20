package framework.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		Connection con = null;
		try {
			//String sql = "create table t_jdbc (id int)";
			String sql = "SELECT * FROM t_jdbc";
			// 1 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2 获得连接
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","root");
			// 3 建立语句对象
			Statement statement = con.createStatement();
			// 4 执行SQL,获得结果集
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.err.println(resultSet.getInt("ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 5 关闭连接
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
