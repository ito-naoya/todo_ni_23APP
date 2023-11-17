package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;

@WebServlet("/todoUpdate")
public class TodoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoUpdateController() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String priority = req.getParameter("priority");
		String content = req.getParameter("content");
		
		TodoModel todoModel = new TodoModel();
		
		int updateNum = todoModel.update(id, title, priority, content);

		req.setAttribute("updateMessage", updateNum + "件のデータを更新しました。");

		String view = "/WEB-INF/views/todoUpdateView.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);
	}

}
