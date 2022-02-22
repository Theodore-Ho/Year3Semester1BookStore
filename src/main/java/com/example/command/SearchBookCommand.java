package com.example.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Book;
import com.example.service.BookService;

public class SearchBookCommand implements Command {
		
	public String execute(HttpServletRequest request, HttpServletResponse repsonse) {
		
		String forwardToJsp = null;
		BookService bookService = new BookService();
		String input = request.getParameter("search_input");
		List<Book> books = bookService.getAllBooks(input);
		HttpSession session = request.getSession();
		if(books == null || books.isEmpty()) {
			session.setAttribute("message","Can't find this book");
			forwardToJsp = "/errorPage.jsp";
		}
		else {
			session.setAttribute("books", books);
			forwardToJsp = "/ListBooks.jsp";
		}
		return forwardToJsp;
	}
}
