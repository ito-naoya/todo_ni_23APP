package model;

public class User {

	private Integer userId;
	private String userName;
	private String password;

	public User() {
	};

	public User(String userName, String hashedPassword) {
		this.userName = userName;
		this.password = hashedPassword;
	}
	
	public User(String userName, int userId) {
		this.userName = userName;
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
