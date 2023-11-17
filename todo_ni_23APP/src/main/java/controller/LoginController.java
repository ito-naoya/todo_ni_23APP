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
import model.UserModel;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String view = "/WEB-INF/views/loginView.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		UserModel userModel = new UserModel();
		TodoModel todoModel = new TodoModel();

		userModel.login(req, userName, password);
		
		HttpSession session = req.getSession();
		String usrName = (String)session.getAttribute("userName");
		Integer userId = (Integer)session.getAttribute("userId");
		
		if(usrName != null) {
			
			req.setAttribute("todoList", todoModel.selectAll(userId));
			
			String view = "/WEB-INF/views/todoListView.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, res);
			
		}else {
			
			res.sendRedirect("register");
			
		}


	}

}
