package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Todo;

public class TodoDao {

	public static final String DB_URL = "jdbc:mysql://localhost/todo";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "";
	public static final String DB_JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public ArrayList<Todo> selectAll() {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<Todo> todoList = new ArrayList<Todo>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoList.add(new Todo(id, title, dateTime, priority, content));
			}

			return todoList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public Todo select(int id) {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			Todo todo = new Todo();

			while (result.next()) {

				todo.setId(result.getInt("id"));
				todo.setTitle(result.getString("title"));
				todo.setDateTime(result.getString("dateTime"));
				todo.setPriority(result.getString("priority"));
				todo.setContent(result.getString("content"));
			}

			return todo;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public int insert(Todo todo) {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "INSERT INTO todos (title, dateTime, priority, content) VALUES(?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getDateTime());
			statement.setString(3, todo.getPriority());
			statement.setString(4, todo.getContent());

			return statement.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public int update(Todo todo) {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "UPDATE todos SET title = ?, dateTime = ?, priority = ?, content = ? WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getDateTime());
			statement.setString(3, todo.getPriority());
			statement.setString(4, todo.getContent());
			statement.setInt(5, todo.getId());

			return statement.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public int delete(int id) {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "DELETE FROM todos WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, id);
			return statement.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public ArrayList<Todo> orderByDateTime(String sort) {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos ORDER BY dateTime " + sort;

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();) {

			ArrayList<Todo> todoList = new ArrayList<Todo>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoList.add(new Todo(id, title, dateTime, priority, content));
			}

			return todoList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public ArrayList<Todo> sortByPriority(String sort) {

		try {
			Class.forName(DB_JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE priority = '" + sort + "'";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();) {

			ArrayList<Todo> todoList = new ArrayList<Todo>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoList.add(new Todo(id, title, dateTime, priority, content));
			}

			return todoList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

}
