package model;

public class Todo {

	private int id;
	private String title;
	private String dateTime;
	private String priority;
	private String content;

	public Todo() {
	};

	public Todo(int id, String title, String dateTime, String priority, String content) {
		this.id = id;
		this.title = title;
		this.dateTime = dateTime;
		this.priority = priority;
		this.content = content;
	}

	public Todo(String title, String dateTime, String priority, String content) {
		this.title = title;
		this.dateTime = dateTime;
		this.priority = priority;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
