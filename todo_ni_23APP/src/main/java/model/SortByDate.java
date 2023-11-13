package model;

import java.util.Comparator;

import model.dto.TodoRecord;

public class SortByDate implements Comparator<TodoRecord> {
	@Override
	public int compare(TodoRecord a, TodoRecord b) {
		return a.getDateTime().compareTo(b.getDateTime());
	};

}