package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;

@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sort = request.getParameter("sort");

		TodoModel todoModel = new TodoModel();

		if (sort == null) {
			request.setAttribute("todoList", todoModel.selectAll());

		} else if (sort != null && sort.equals("asc") || sort.equals("desc")) {
			request.setAttribute("todoList", todoModel.orderByDateTime(sort));

		} else if (sort != null && sort.equals("high") || sort.equals("normal") || sort.equals("low")) {
			request.setAttribute("todoList", todoModel.sortByPriority(sort));

		} else {
			request.setAttribute("todoList", todoModel.selectAll());
		}

		String view = "/WEB-INF/views/listView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
