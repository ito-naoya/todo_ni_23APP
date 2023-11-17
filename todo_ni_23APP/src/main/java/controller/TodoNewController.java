package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todoNew")
public class TodoNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoNewController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

		String view = "/WEB-INF/views/todoNewView.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);

	}

}
