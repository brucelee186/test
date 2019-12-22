package com.neo.framework.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.neo.framework.bean.BeaSenDht11;

public class DaoSenDht11 {
	
	public static BeaSenDht11 getSenDht11() {
	//public static void main(String[] args) {
		Connection connection = null;
		BeaSenDht11 beaSenDht11 = new BeaSenDht11();
		try {
			// String sql0 = "drop table if exists jdbc";
			// String sql = "create table if not exists jdbc (id int, name varchar(12))";
			// String sql2 = "insert jdbc (id, name) value(1, \"neo\")";
			// String sql3 = "SELECT * FROM jdbc";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://192.168.1.200/home", "root", "root");
			Statement statement = connection.createStatement();
			connection.setAutoCommit(false);
			// jdbc支持事务的五种隔离级别TRANSACTION_NONE:没有这种隔离级别,实际上设置transactionIsolation为0就是没有事务隔离级别
			// TRANSACTION_READ_UNCOMMITTED = 1 : 允许读取没有提交的数据,但不允许实际上对应事务的脏读,这个不经常使用
			// TRANSACTION_READ_COMMITTED = 2 : 允许重复读取,但不允许读取未提交的数据
			// 设置为transaction_read_uncommitted - 可以读未提交的数据,那么在commit前可以查询没有提交的数据
			connection.setTransactionIsolation(1);
			//System.err.println(connection.getTransactionIsolation());
			ResultSet resultSet = statement.executeQuery("SELECT sd.* FROM senDht11 sd ORDER BY id DESC LIMIT 1");
			while (resultSet.next()) {
//				System.err.println("id = " + resultSet.getInt("id") + " temperature = " + resultSet.getString("temperature"));
				Long id = resultSet.getLong("id");
				String uid = resultSet.getString("uid");
				String codeRf = resultSet.getString("codeRf");
				Double temperature = resultSet.getDouble("temperature");
				Double humidity = resultSet.getDouble("humidity");
				Date date = resultSet.getTimestamp("date");
				beaSenDht11.setId(id);
				beaSenDht11.setUid(uid);
				beaSenDht11.setCodeRf(codeRf);
				beaSenDht11.setTemperature(temperature);
				beaSenDht11.setHumidity(humidity);
				beaSenDht11.setDate(date);
			}
			// statement.executeUpdate("INSERT INTO jdbc (id, name) VALUES(14,'god')");
			// boolean result0 = statement.execute(sql0);
			// boolean result = statement.execute(sql);
			// boolean result2 = statement.execute(sql2);
			// ResultSet resultSet2 = statement.executeQuery(sql); 
			connection.commit();
			
			/*
			 * 脏读: 一个事务访问数据库修改一条记录,但没有提交,另一个事务访问数据库读取了这样记录,此时的结果称为脏读
			 * 不可重复读: 一个事务对一条记录多次读取的过程中,另一个事务修改了这个记录,这时会产生错误逻辑,同样一条记录,两次读取的结果不一样,称为不可重复读
			 * 幻读: 用户一对表中所有数据做了一个更新操作,用户二往表中添加了一条数据,这时用户一会发现表中还有没有更新的记录,就像产生了幻觉一样,这是因为两个独立执行的事务造成的
			 */
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return beaSenDht11;
	}
}
