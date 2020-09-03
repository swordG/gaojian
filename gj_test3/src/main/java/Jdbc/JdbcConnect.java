package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnect {
	
	public static void main(String[] args) {
	    Connection connection;
	    ResultSet resultSet;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gj_num1?useUnicode=true&characterEncoding=utf-8&characterSetResults=UTF-8&serverTimezone=Asia/Shanghai&&useSSL=true","root","");

	        PreparedStatement statement = connection.prepareStatement("select * from user where username=?");
	        statement.setString(1,"ÀîËÄ");
	        resultSet = statement.executeQuery();
	        while(resultSet.next()) {
	            User user = new User();
	            user.setId(resultSet.getInt("id"));
	            user.setUsername(resultSet.getString("username"));
	            user.setSex(resultSet.getString("sex"));
	            user.setAddress(resultSet.getString("address"));
	            user.setBirthday(resultSet.getDate("birthday"));
	            System.out.println(user.toString());
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
