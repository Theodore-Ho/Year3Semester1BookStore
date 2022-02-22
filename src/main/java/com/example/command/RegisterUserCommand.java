package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.service.UserService;

public class RegisterUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
			
		UserService userService = new UserService();
		String forwardToJsp = "";

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		
		HttpSession session = request.getSession();

		if (firstname.equals("") || lastname.equals("") || username.equals("") || password.equals("") || passwordRe.equals("") ){
			
			session.setAttribute("message","You should fill all the block if you want to register.");
			forwardToJsp = "/errorPage.jsp";
			
		}
		else {

			if (password.equals(passwordRe)){

				Boolean check = false;
				check = userService.register(firstname, lastname, username, password);

				if(check) {
					
					session.setAttribute("registerUsername", username);
					session.setAttribute("registerPassword", password);
					
					forwardToJsp = "/RegisterSuccess.jsp";
				}
				else {
					session.setAttribute("message","Register failure, this username has already used. Please use another username.");
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
