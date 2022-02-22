package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;

public class SaveUserProfileCommand implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		UserService userService = new UserService();
		String forwardToJsp = "";
		
		HttpSession session = request.getSession();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");

		User user = (User) session.getAttribute("user");
		int userID = user.getId();
		
		if (firstname.equals("") || lastname.equals("") || username.equals("") || password.equals("") || rePassword.equals("") ){
			
			session.setAttribute("message","You should fill all the block if you want to update your user profile.");
			forwardToJsp = "/errorPage.jsp";
			
		}
		else {

			if (password.equals(rePassword)){
				Boolean check = false;
				check = userService.updateProfile(userID, firstname, lastname, username, password);
	
				if(check) {
					User userLoggingIn = userService.login(username, password);
	
					String clientSessionId = session.getId();
					session.setAttribute("loggedSessionId", clientSessionId);
					session.setAttribute("user", userLoggingIn);
	
					forwardToJsp = "/UserProfile.jsp";	
				} else {
					session.setAttribute("message","Update failure, this username has already used. Please use another username.");
					forwardToJsp = "/errorPage.jsp";
				}
			}
			else{
				session.setAttribute("message","Your repeat password is different with password.");
				forwardToJsp = "/errorPage.jsp";
			}
			
		}
		return forwardToJsp;
	}
}
