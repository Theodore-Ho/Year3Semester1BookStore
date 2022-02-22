package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputBookTitleCommand implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "/search.jsp";
		
		return forwardToJsp;
	}
}