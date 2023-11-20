package model;

import java.security.NoSuchAlgorithmException;

import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserModel {

	UserDao accountDao = new UserDao();

	public void login(HttpServletRequest req, String userName, String password) {
		
		String hashedPassword ="";
		
		try {
			
			hashedPassword = HashGenerator.generateHash(password);
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			
		}
		
		if(hashedPassword != "" && hashedPassword != password) {
			
			User user = accountDao.login(userName, hashedPassword);
			
			if (user != null) {
				
				HttpSession session = req.getSession();
				
				session.setAttribute("user", user);
			
				
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
