package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;

@WebServlet("/todoDelete")
public class TodoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		TodoModel todoModel = new TodoModel();

		int deleteNum = todoModel.delete(id);

		request.setAttribute("deleteMessage", deleteNum + "件のデータを削除しました。");

		String view = "/WEB-INF/views/delete.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
