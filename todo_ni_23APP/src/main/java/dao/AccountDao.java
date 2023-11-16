package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AccountDao{

	public static final String DB_URL = "jdbc:mysql://localhost/todo";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "";
	public static final String DB_JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public User login(String name, String password) {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM users WHERE userName = ? AND password = ?";

		User user = new User();

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, name);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {

				int id = result.getInt("id");
				String userName = result.getString("userName");
				
				user.setId(id);
				user.setUserName(userName);
			}
			
			return user;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

}
