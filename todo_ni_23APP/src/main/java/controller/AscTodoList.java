package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;

@WebServlet("/ascTodoList")
public class AscTodoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AscTodoList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			TodoModel todoModel = new TodoModel();

			request.setAttribute("todoRecordList", todoModel.sortAsc());

		} catch (Exception e) {

			request.setAttribute("message", "Exception:" + e.getMessage());
		}

		String view = "/WEB-INF/views/list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}



}
