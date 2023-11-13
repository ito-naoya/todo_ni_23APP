package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;

@WebServlet("/todoDetail")
public class TodoDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		TodoModel todoModel = new TodoModel();

		request.setAttribute("record", todoModel.find(id));

		String view = "/WEB-INF/views/detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
