package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackLoginCommand implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "/login.jsp";
		
		return forwardToJsp;
	}
}
