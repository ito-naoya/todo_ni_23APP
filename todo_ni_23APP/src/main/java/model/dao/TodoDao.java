package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.TodoRecord;

public class TodoDao {
	private String url = "jdbc:mysql://localhost/todo";
	private String user = "root";
	private String password = "";

	public ArrayList<TodoRecord> findAll() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<TodoRecord> todoRecordList = new ArrayList<TodoRecord>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new TodoRecord(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

	public ArrayList<TodoRecord> sortAsc() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos ORDER BY dateTime ASC";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<TodoRecord> todoRecordList = new ArrayList<TodoRecord>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new TodoRecord(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

	public ArrayList<TodoRecord> sortDesc() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos ORDER BY dateTime DESC";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<TodoRecord> todoRecordList = new ArrayList<TodoRecord>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new TodoRecord(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

	public ArrayList<TodoRecord> sortHigh() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE priority = 'high'";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<TodoRecord> todoRecordList = new ArrayList<TodoRecord>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new TodoRecord(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

	public ArrayList<TodoRecord> sortNormal() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE priority = 'normal'";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<TodoRecord> todoRecordList = new ArrayList<TodoRecord>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new TodoRecord(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}

	}

	public ArrayList<TodoRecord> sortLow() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE priority = 'low'";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()) {

			ArrayList<TodoRecord> todoRecordList = new ArrayList<TodoRecord>();

			while (results.next()) {

				int id = results.getInt("id");
				String title = results.getString("title");
				String dateTime = results.getString("dateTime");
				String content = results.getString("content");
				String priority = results.getString("priority");

				todoRecordList.add(new TodoRecord(id, title, dateTime, priority, content));
			}

			return todoRecordList;

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}

	}

	public TodoRecord find(int id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todos WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			TodoRecord record = new TodoRecord();

			while (result.next()) {

				record.setId(result.getInt("id"));
				record.setTitle(result.getString("title"));
				record.setDateTime(result.getString("dateTime"));
				record.setPriority(result.getString("priority"));
				record.setContent(result.getString("content"));

			}

			return record;

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

	public int delete(int id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
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

	public int insert(TodoRecord todoRecord) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "INSERT INTO todos (title, dateTime, priority, content) VALUES(?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, todoRecord.getTitle());
			statement.setString(2, todoRecord.getDateTime());
			statement.setString(3, todoRecord.getPriority());
			statement.setString(4, todoRecord.getContent());

			// SQL実行
			return statement.executeUpdate();

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

	public int update(TodoRecord todoRecord) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "UPDATE todos SET title = ?, dateTime = ?, priority = ?, content = ? WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, todoRecord.getTitle());
			statement.setString(2, todoRecord.getDateTime());
			statement.setString(3, todoRecord.getPriority());
			statement.setString(4, todoRecord.getContent());
			statement.setInt(5, todoRecord.getId());

			// SQL実行
			return statement.executeUpdate();

		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}
}
