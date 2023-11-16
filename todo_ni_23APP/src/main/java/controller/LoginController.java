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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = "/WEB-INF/views/loginView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserModel userModel = new UserModel();
		TodoModel todoModel = new TodoModel();

		userModel.login(request, userName, password);
		
		HttpSession session = request.getSession();
		String usrName = (String)session.getAttribute("userName");
		Integer userId = (Integer)session.getAttribute("userId");
		
		if(usrName != null) {			
			request.setAttribute("todoList", todoModel.selectAll(userId));
			
			String view = "/WEB-INF/views/todoListView.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect("register");
		}


	}

}
