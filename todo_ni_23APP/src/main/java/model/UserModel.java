package model;

import java.security.NoSuchAlgorithmException;

import dao.AccountDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserModel {

	AccountDao accountDao = new AccountDao();

	public void login(HttpServletRequest req, String userName, String password) {
		
		String hashedPassword ="";
		try {
			hashedPassword = HashGenerator.generateHash(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		if(hashedPassword != "" && hashedPassword != password) {
			
			User user = accountDao.login(userName, hashedPassword);
			
			if (user != null) {
				
				HttpSession session = req.getSession();
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("userId", user.getUserId());
				
			}
		}

	}

	
	public int insert(String userName, String password) {
		
		String hashedPassword = "";
		try {
			hashedPassword = HashGenerator.generateHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		User user = new User();
		if(hashedPassword != "" && hashedPassword != password) {			
			user.setUserName(userName);
			user.setPassword(hashedPassword);
		}
		
		return accountDao.insert(user);
	}
}
