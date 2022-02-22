package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.BookService;

public class SaveBookCommand implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){

		String forwardToJsp = "";
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userID = user.getId();
		
		int bookID = Integer.parseInt(request.getParameter("bookid"));
		
		BookService bookService = new BookService();
		Boolean check = bookService.saveBook(userID, bookID);
		
		if(check) {
			forwardToJsp = "/SaveSuccess.jsp";
		} else {
			session.setAttribute("message","This book is already in your basket");
			forwardToJsp = "/errorPage.jsp";
		}
		
		return forwardToJsp;
	}
}
