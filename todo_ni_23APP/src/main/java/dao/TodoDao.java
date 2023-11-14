package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Todo;

public class TodoDao {

	public static final String url = "jdbc:mysql://localhost/todo";
	public static final String user = "root";
	public static final String password = "";
	public static final String jdbcDriver = "com.mysql.jdbc.Driver";

	public ArrayList<Todo> selectAll() {

		try {
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<Todo> todoRecordList = new ArrayList<Todo>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new Todo(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public Todo select(int id) {

		try {
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(url, user, password);
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
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "INSERT INTO todos (title, dateTime, priority, content) VALUES(?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, user, password);
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
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "UPDATE todos SET title = ?, dateTime = ?, priority = ?, content = ? WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(url, user, password);
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
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "DELETE FROM todos WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, id);
			return statement.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public ArrayList<Todo> orderByDateTime(String sort) {

		try {
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos ORDER BY dateTime " + sort;

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();) {

			ArrayList<Todo> todoRecordList = new ArrayList<Todo>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new Todo(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public ArrayList<Todo> sortPriority(String sort) {

		try {
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE priority = '" + sort + "'";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();) {

			ArrayList<Todo> todoRecordList = new ArrayList<Todo>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new Todo(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

}
