package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.TodoDao;

public class TodoModel {

	TodoDao todoDao = new TodoDao();

	private static String getNowDate() {
		
		Date nowDateTime = new Date();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		
		String formatNowDate = sdf2.format(nowDateTime);
		
		return formatNowDate;
		
	}

	public ArrayList<Todo> selectAll(Integer userId) {
		return todoDao.selectAll(userId);
	}

	public Todo select(int todoId) {
		return todoDao.select(todoId);
	}

	public int insert(String title, String priority, String content, int user_id) {

		String nowDateTime = getNowDate();
		
		Todo todo = new Todo(title, nowDateTime, priority, content, user_id);

		return todoDao.insert(todo);
		
	}

	public int update(int todoId, String title, String priority, String content) {

		Todo todo = todoDao.select(todoId);
		
		String nowDate = getNowDate();

		todo.setTitle(title);
		
		todo.setDateTime(nowDate);
		
		todo.setPriority(priority);
		
		todo.setContent(content);

		return todoDao.update(todo);
	}

	public int delete(int todoId) {
		return todoDao.delete(todoId);
	}

	public ArrayList<Todo> orderByDateTime(int userId, String sort) {
		return todoDao.orderByDateTime(userId, sort);
	}

	public ArrayList<Todo> sortByPriority(int userId, String sort) {
		return todoDao.sortByPriority(userId, sort);
	}

}
