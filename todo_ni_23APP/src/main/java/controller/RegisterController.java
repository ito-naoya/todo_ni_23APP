package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String view = "/WEB-INF/views/registerView.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		UserModel userModel = new UserModel();
		int registerNum = userModel.insert(userName, password);
		
		req.setAttribute("registerMessage", registerNum + "件のアカウントを新規登録しました。");
		
		String view = "/WEB-INF/views/newRegisterView.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);
		
	}


}
