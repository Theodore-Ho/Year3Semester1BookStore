package com.example.service;

import java.util.List;

import com.example.business.Book;
import com.example.business.User_Book;
import com.example.dao.BookDao;
import com.example.exceptions.DaoException;

public class BookService {

	BookDao dao = new BookDao();
	
	public List<Book> getAllBooks(String input) {
		List<Book> books = null;
		try {
			books = dao.getAllBooks(input);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public List<User_Book> getMyBooks(int input) {
		List<User_Book> books = null;
		try {
			books = dao.findBookByUser(input);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public Boolean saveBook(int userID, int bookID) {
		Boolean check = false;
		try {
			check = dao.saveBook(userID, bookID);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	public void removeBook(int user_bookID) {
		try {
			dao.removeBook(user_bookID);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean addOne(int user_bookID) {
		Boolean check = false;
		try {
			check = dao.addOne(user_bookID);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	public int minusOne(int user_bookID) {
		int check = 0;
		try {
			check = dao.minusOne(user_bookID);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	public void clearBasket(int userID) {
		try {
			dao.clearMyBasket(userID);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}