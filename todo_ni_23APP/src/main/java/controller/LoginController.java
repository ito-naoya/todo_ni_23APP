package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.UserModel;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.sendRedirect("todoList");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		HttpSession invalidateSession = req.getSession();

		invalidateSession.invalidate();

		String userName = req.getParameter("userName");

		String password = req.getParameter("password");

		UserModel userModel = new UserModel();

		userModel.login(req, userName, password);

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		if (user != null) {

			res.sendRedirect("todoList");

		} else {

			res.sendRedirect("register");

		}

	}

}
