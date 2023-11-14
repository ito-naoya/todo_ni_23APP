package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.TodoDao;

public class TodoModel {

	TodoDao todoDao = new TodoDao();

	public ArrayList<Todo> selectAll() {
		return todoDao.selectAll();
	}

	public Todo select(int id) {
		return todoDao.select(id);
	}

	public int insert(String title, String priority, String content) {

		String nowDateTime = getNowDate();
		Todo todo = new Todo(title, nowDateTime, priority, content);

		return todoDao.insert(todo);
	}

	public int update(int id, String title, String priority, String content) {

		Todo todo = todoDao.select(id);
		String nowDate = getNowDate();

		todo.setTitle(title);
		todo.setDateTime(nowDate);
		todo.setPriority(priority);
		todo.setContent(content);

		return todoDao.update(todo);

	}

	public int delete(int id) {
		return todoDao.delete(id);
	}

	public ArrayList<Todo> orderByDateTime(String sort) {
		return todoDao.orderByDateTime(sort);
	}

	public ArrayList<Todo> sortPriority(String sort) {
		return todoDao.sortPriority(sort);
	}

	public static String getNowDate() {
		Date nowDateTime = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		String formatNowDate = sdf2.format(nowDateTime);
		return formatNowDate;
	}

}
