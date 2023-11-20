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

	public ArrayList<Todo> selectAll(Integer userId) {

		try {
			
			Class.forName(DB_JDBC_DRIVER);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		String sql = "SELECT * FROM todos WHERE user_id = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, userId);
			
			ResultSet results = statement.executeQuery();

			ArrayList<Todo> todoList = new ArrayList<Todo>();

			while (results.next()) {

				int todoId = results.getInt("id");
				
				String title = results.getString("title");
				
				String dateTime = results.getString("dateTime");
				
				String content = results.getString("content");
				
				String priority = results.getString("priority");
				
				int user_id = results.getInt("user_id");

				todoList.add(new Todo(todoId, title, dateTime, priority, content, user_id));
			}

			return todoList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public Todo select(int todoId) {

		try {
			
			Class.forName(DB_JDBC_DRIVER);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		String sql = "SELECT * FROM todos WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, todoId);
			
			ResultSet result = statement.executeQuery();

			Todo todo = new Todo();

			while (result.next()) {

				todo.setTodoId(result.getInt("id"));
				
				todo.setTitle(result.getString("title"));
				
				todo.setDateTime(result.getString("dateTime"));
				
				todo.setPriority(result.getString("priority"));
				
				todo.setContent(result.getString("content"));
				
				todo.setUser_Id(result.getInt("user_id"));
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

		String sql = "INSERT INTO todos (title, dateTime, priority, content, user_id) VALUES(?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, todo.getTitle());
			
			statement.setString(2, todo.getDateTime());
			
			statement.setString(3, todo.getPriority());
			
			statement.setString(4, todo.getContent());
			
			statement.setInt(5, todo.getUser_Id());
			
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
			
			statement.setInt(5, todo.getTodoId());

			return statement.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public int delete(int todoId) {

		try {
			
			Class.forName(DB_JDBC_DRIVER);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		String sql = "DELETE FROM todos WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, todoId);
			
			return statement.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public ArrayList<Todo> orderByDateTime(int userId, String sort) {

		try {
			
			Class.forName(DB_JDBC_DRIVER);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		String sql = "SELECT * FROM todos WHERE user_id = ? ORDER BY dateTime " + sort;

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, userId);
			
			ResultSet results = statement.executeQuery();

			ArrayList<Todo> todoList = new ArrayList<Todo>();

			while (results.next()) {

				int todoId = results.getInt("id");
				
				String title = results.getString("title");
				
				String dateTime = results.getString("dateTime");
				
				String content = results.getString("content");
				
				String priority = results.getString("priority");
				
				int user_id = results.getInt("user_id");

				todoList.add(new Todo(todoId, title, dateTime, priority, content, user_id));
			}

			return todoList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public ArrayList<Todo> sortByPriority(int userId, String sort) {

		try {
			
			Class.forName(DB_JDBC_DRIVER);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		String sql = "SELECT * FROM todos WHERE user_id = ? AND priority = '" + sort + "'";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, userId);
			
			ResultSet results = statement.executeQuery();

			ArrayList<Todo> todoList = new ArrayList<Todo>();

			while (results.next()) {

				int todoId = results.getInt("id");
				
				String title = results.getString("title");
				
				String dateTime = results.getString("dateTime");
				
				String content = results.getString("content");
				
				String priority = results.getString("priority");
				
				int user_id = results.getInt("user_id");

				todoList.add(new Todo(todoId, title, dateTime, priority, content, user_id));
			}

			return todoList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

}
