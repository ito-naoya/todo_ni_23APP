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

		String sortParam = request.getParameter("sortParam");

		TodoModel todoModel = new TodoModel();

		if (sortParam == null) {
			request.setAttribute("todoList", todoModel.selectAll());
		} else if (sortParam != null) {
			switch (sortParam) {
			case "asc":
				request.setAttribute("todoList", todoModel.sortAsc());
				break;
			case "desc":
				request.setAttribute("todoList", todoModel.sortDesc());
				break;
			case "high":
				request.setAttribute("todoList", todoModel.sortHigh());
				break;
			case "normal":
				request.setAttribute("todoList", todoModel.sortNormal());
				break;
			case "low":
				request.setAttribute("todoList", todoModel.sortLow());
				break;
			case "all":
				request.setAttribute("todoList", todoModel.selectAll());
				break;
			}
		}

		String view = "/WEB-INF/views/listView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
