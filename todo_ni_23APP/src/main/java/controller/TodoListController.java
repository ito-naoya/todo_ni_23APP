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

@WebServlet("/todoList")
public class TodoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoListController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

		HttpSession session = req.getSession();

		Integer userId = (Integer) session.getAttribute("userId");
		String userName = (String)session.getAttribute("userName");
		
		req.setAttribute("userId", userId);
		req.setAttribute("userName", userName);

		String sort = req.getParameter("sort");

		TodoModel todoModel = new TodoModel();

		if (userId == null) {

			String view = "/WEB-INF/views/todoListView.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, res);

		} else {

			if (sort == null) {

				req.setAttribute("todoList", todoModel.selectAll(userId));

			} else if (sort != null && sort.equals("asc") || sort.equals("desc")) {

				req.setAttribute("todoList", todoModel.orderByDateTime(userId, sort));

			} else if (sort != null && sort.equals("high") || sort.equals("normal") || sort.equals("low")) {

				req.setAttribute("todoList", todoModel.sortByPriority(userId, sort));

			} else {

				req.setAttribute("todoList", todoModel.selectAll(userId));
				
			}

			String view = "/WEB-INF/views/todoListView.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, res);

		}

	}

}
