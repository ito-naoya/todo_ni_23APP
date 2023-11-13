package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.dao.TodoDao;
import model.dto.TodoRecord;

public class TodoModel {

	TodoDao todoDao = new TodoDao();

	public ArrayList<TodoRecord> findAll() {
		return todoDao.findAll();
	}

	public ArrayList<TodoRecord> sortAsc() {
		return todoDao.sortAsc();
	}

	public ArrayList<TodoRecord> sortDesc() {
		return todoDao.sortDesc();
	}

	public ArrayList<TodoRecord> sortHigh() {
		return todoDao.sortHigh();
	}

	public ArrayList<TodoRecord> sortNormal() {
		return todoDao.sortNormal();
	}

	public ArrayList<TodoRecord> sortLow() {
		return todoDao.sortLow();
	}

	public TodoRecord find(int targetId) {
		return todoDao.find(targetId);
	}

	public int delete(int id) {
		return todoDao.delete(id);
	}

	public static String getNowDate() {
		Date nowDate = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		String formatNowDate = sdf2.format(nowDate);
		return formatNowDate;
	}

	public int insert(String title, String priority, String content) {

		TodoRecord todoRecord = new TodoRecord();
		String nowDate = getNowDate();

		todoRecord.setTitle(title);
		todoRecord.setDateTime(nowDate);
		todoRecord.setPriority(priority);
		todoRecord.setContent(content);

		return todoDao.insert(todoRecord);
	}

	public int update(int todoId, String title, String priority, String content) {

		TodoRecord todoRecord = todoDao.find(todoId);
		String nowDate = getNowDate();

		todoRecord.setTitle(title);
		todoRecord.setDateTime(nowDate);
		todoRecord.setPriority(priority);
		todoRecord.setContent(content);

		return todoDao.update(todoRecord);

	}

}
