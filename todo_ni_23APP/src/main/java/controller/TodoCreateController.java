package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;

@WebServlet("/todoCreate")
public class TodoCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoCreateController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String priority = request.getParameter("priority");

		TodoModel todoModel = new TodoModel();

		int createNum = todoModel.insert(title, priority, content);

		request.setAttribute("createMessage", createNum + "件のデータを追加しました。");

		String view = "/WEB-INF/views/todoCreateView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
