package com.example.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.business.User_Book;
import com.example.service.BookService;

public class MinusOneCommand implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){

		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		int user_bookID = Integer.parseInt(request.getParameter("bookid"));
		
		BookService bookService = new BookService();
		int check = bookService.minusOne(user_bookID);
		
		if(check == 1) {
			User user = (User) session.getAttribute("user");
			int userID = user.getId();
			List<User_Book> books = bookService.getMyBooks(userID);
			
			if(books == null || books.isEmpty()) {
				session.setAttribute("message","Your basket is empty");
				forwardToJsp = "/errorPage.jsp";
			}
			else {
				int price;
				int quantity;
				int total_price = 0;
				for(int i = 0; i < books.size(); i++) {
					price = books.get(i).getPrice();
					quantity = books.get(i).getQuantity();
					total_price += price * quantity;
				}
				String total_price_with_format = String.format("%,d", total_price);
				session.setAttribute("totalPrice", total_price_with_format);
				session.setAttribute("books", books);
				forwardToJsp = "/MyBooks.jsp";
			}
			
		} else if(check == 2) {
			session.setAttribute("user_bookID", user_bookID);
			forwardToJsp = "/AskRemove.jsp";
		} else {
			session.setAttribute("message","Some Error happened, contact admin.");
			forwardToJsp = "/errorPage.jsp";
		}
		
		return forwardToJsp;
	}
}