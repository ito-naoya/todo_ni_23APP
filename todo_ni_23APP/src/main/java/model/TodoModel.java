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
		Todo todoRecord = new Todo(title, nowDateTime, priority, content);
		
		return todoDao.insert(todoRecord);
	}
	
	public int update(int id, String title, String priority, String content) {
		
		Todo todoRecord = todoDao.select(id);
		String nowDate = getNowDate();
		
		todoRecord.setTitle(title);
		todoRecord.setDateTime(nowDate);
		todoRecord.setPriority(priority);
		todoRecord.setContent(content);
		
		return todoDao.update(todoRecord);
		
	}

	public int delete(int id) {
		return todoDao.delete(id);
	}
	
	public ArrayList<Todo> sortAsc() {
		return todoDao.sortAsc();
	}

	public ArrayList<Todo> sortDesc() {
		return todoDao.sortDesc();
	}

	public ArrayList<Todo> sortHigh() {
		return todoDao.sortHigh();
	}

	public ArrayList<Todo> sortNormal() {
		return todoDao.sortNormal();
	}

	public ArrayList<Todo> sortLow() {
		return todoDao.sortLow();
	}

	public static String getNowDate() {
		Date nowDateTime = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		String formatNowDate = sdf2.format(nowDateTime);
		return formatNowDate;
	}


}
