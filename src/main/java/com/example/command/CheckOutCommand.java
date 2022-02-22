package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.BookService;

public class CheckOutCommand implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){

		String forwardToJsp = "";
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userID = user.getId();
		
		BookService bookService = new BookService();
		bookService.clearBasket(userID);
		
		forwardToJsp = "/loginSuccess.jsp";
		
		return forwardToJsp;
	}
}
