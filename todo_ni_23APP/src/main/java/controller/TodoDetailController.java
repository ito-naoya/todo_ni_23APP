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
import model.User;

@WebServlet("/todoDetail")
public class TodoDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user == null) {
			
			res.sendRedirect("login");
			
		}else {
			
			int todoId = Integer.parseInt(req.getParameter("id"));
			
			TodoModel todoModel = new TodoModel();
			
			req.setAttribute("todo", todoModel.select(todoId));
			
			String view = "/WEB-INF/views/todoDetailView.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, res);
			
		}
		
	}

}
