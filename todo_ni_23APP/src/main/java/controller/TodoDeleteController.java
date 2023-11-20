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

@WebServlet("/todoDelete")
public class TodoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		Integer userId = (Integer) session.getAttribute("userId");

		if (userId == null) {
			
			res.sendRedirect("login");
			
		} else {
			
			int todoId = Integer.parseInt(req.getParameter("id"));

			TodoModel todoModel = new TodoModel();

			int deleteNum = todoModel.delete(todoId);

			req.setAttribute("deleteMessage", deleteNum + "件のデータを削除しました。");

			String view = "/WEB-INF/views/todoDeleteView.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, res);
			
		}

	}

}
