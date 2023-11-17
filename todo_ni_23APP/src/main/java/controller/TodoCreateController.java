package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TodoModel;

@WebServlet("/todoCreate")
public class TodoCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoCreateController() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int user_id = (int)session.getAttribute("userId");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String priority = req.getParameter("priority");

		TodoModel todoModel = new TodoModel();

		int createNum = todoModel.insert(title, priority, content, user_id);

		req.setAttribute("createMessage", createNum + "件のデータを追加しました。");

		String view = "/WEB-INF/views/todoCreateView.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);

	}

}
