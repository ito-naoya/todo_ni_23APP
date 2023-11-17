package model;

public class Todo {

	private int todoId;
	private String title;
	private String dateTime;
	private String priority;
	private String content;
	private int user_Id;

	public Todo() {
	};

	public Todo(int todoId, String title, String dateTime, String priority, String content, int user_id) {
		this.todoId = todoId;
		this.title = title;
		this.dateTime = dateTime;
		this.priority = priority;
		this.content = content;
		this.user_Id = user_id;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public Todo(String title, String dateTime, String priority, String content, int user_id) {
		this.title = title;
		this.dateTime = dateTime;
		this.priority = priority;
		this.content = content;
		this.user_Id = user_id;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
