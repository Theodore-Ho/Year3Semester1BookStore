package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserProfileCommand implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "/UpdateUserProfile.jsp";
		
		return forwardToJsp;
	}
}
