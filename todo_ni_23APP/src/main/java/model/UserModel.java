package model;

import dao.AccountDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserModel {

	AccountDao accountDao = new AccountDao();

	public User login(HttpServletRequest req, String userName, String password) {

		User user = accountDao.login(userName, password);

		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userId", user.getId());
		}
		
		return user;
	}

}
