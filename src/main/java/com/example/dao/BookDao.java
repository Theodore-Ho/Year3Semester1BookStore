package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.Book;
import com.example.business.User_Book;
import com.example.exceptions.DaoException;

public class BookDao extends Dao {
	
	public List<Book> getAllBooks(String input) throws DaoException {
    	
    	List<Book> books = new ArrayList<Book>();
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = this.getConnection();
            String base = "SELECT * FROM books where title like '%";
            String query = base + input + "%'";
            
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            while(rs.next()){
            	int bookId = rs.getInt("bookID");
                String author = rs.getString("author");
                String title = rs.getString("title");
                String location = rs.getString("location");
                String publisher = rs.getString("publisher");
                String year = rs.getString("year");
                String isbn = rs.getString("code");
                int price = rs.getInt("price");
                Book b = new Book(bookId, author, title, location, publisher, year, isbn, price);
                books.add(b);
            }
        } catch (SQLException e) {
            throw new DaoException("getAllBooks " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("getAllBooks" + e.getMessage());
            }
        }
        return books;
    }
	
	public List<User_Book> findBookByUser(int userID) throws DaoException {
		
		List<User_Book> books = new ArrayList<User_Book>();
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = this.getConnection();
            String base = "SELECT user_books.user_bookID, user_books.userID, books.title, books.price, user_books.quantity FROM books join user_books using(bookID) where userID = ";
            String query = base + userID;
            
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            while(rs.next()){
            	int user_bookId = rs.getInt("user_bookID");
                int user_ID = rs.getInt("userID");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                User_Book b = new User_Book(user_bookId, user_ID, title, price, quantity);
                books.add(b);
            }
        } catch (SQLException e) {
            throw new DaoException("findBookByUser " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findBookByUser" + e.getMessage());
            }
        }
        return books;
    }
	
	public Boolean saveBook(int userID, int bookID) throws DaoException {
		
    	Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        int checkUser = 0;
        int checkBook = 0;
        Boolean saveSuccess = false;
        try {
            con = this.getConnection();
            
            String query1 = "SELECT * FROM user_books where userID = ? and bookID = ?";
            ps = con.prepareStatement(query1);
            ps.setInt(1, userID);
            ps.setInt(2, bookID);
            rs = ps.executeQuery();
            
            if (rs.next()) {
            	checkUser = rs.getInt("userID");
            	checkBook = rs.getInt("bookID");
            }
            
            if(checkUser == 0 && checkBook == 0) {				// check duplicate save
            	
            	String query2 = "INSERT INTO user_books (userID, bookID, quantity) VALUES (?, ?, 1);";
                
            	ps2 = con.prepareStatement(query2);
            	ps2.setInt(1, userID);
            	ps2.setInt(2, bookID);
                
            	ps2.executeUpdate();
            	
            	saveSuccess = true;
                
            } else {
            	saveSuccess = false;
            }
            
        } catch (SQLException e) {
            throw new DaoException("saveBook " + e.getMessage());
        } finally {
            try {
            	if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("saveBook" + e.getMessage());
            }
        }
        return saveSuccess;
	}
	
	public void removeBook(int user_bookID) throws DaoException {
		
    	Connection con = null;
        PreparedStatement ps = null;
        try {
        	
            con = this.getConnection();
            
            String query = "DELETE FROM user_books WHERE user_bookID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, user_bookID);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new DaoException("saveBook " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("saveBook" + e.getMessage());
            }
        }
	}

	public Boolean addOne(int user_bookID) throws DaoException {
		
		Connection con = null;
	    PreparedStatement ps = null;
	    PreparedStatement ps2 = null;
	    ResultSet rs = null;
	    int checkUserBookID = 0;
	    Boolean addSuccess = false;
	    try {
	        con = this.getConnection();
	        
	        String query1 = "SELECT * FROM user_books where user_bookID = ?";
	        ps = con.prepareStatement(query1);
	        ps.setInt(1, user_bookID);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	        	checkUserBookID = rs.getInt("user_bookID");
	        }
	        
	        if(checkUserBookID != 0) {		// check the user stored book exist
	        	
	        	String query2 = "UPDATE user_books SET quantity = quantity + 1 WHERE user_bookID = ?";
	            
	        	ps2 = con.prepareStatement(query2);
	        	ps2.setInt(1, user_bookID);
	            
	        	ps2.executeUpdate();
	        	
	        	addSuccess = true;
	            
	        } else {
	        	addSuccess = false;
	        }
	        
	    } catch (SQLException e) {
	        throw new DaoException("saveBook " + e.getMessage());
	    } finally {
	        try {
	        	if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (ps2 != null) {
	                ps2.close();
	            }
	            if (con != null) {
	                freeConnection(con);
	            }
	        } catch (SQLException e) {
	            throw new DaoException("saveBook" + e.getMessage());
	        }
	    }
	    return addSuccess;
	}
	
public int minusOne(int user_bookID) throws DaoException {
		
		Connection con = null;
	    PreparedStatement ps = null;
	    PreparedStatement ps2 = null;
	    ResultSet rs = null;
	    int quantity = 0;
	    int check = 0;	// default status, if check = 0 at the end, some unexpected error happened.
	    try {
	        con = this.getConnection();
	        
	        String query1 = "SELECT * FROM user_books where user_bookID = ?";
	        ps = con.prepareStatement(query1);
	        ps.setInt(1, user_bookID);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	        	quantity = rs.getInt("quantity");
	        }
	        
	        if(quantity != 1) {
	        	
	        	String query2 = "UPDATE user_books SET quantity = quantity - 1 WHERE user_bookID = ?";
	            
	        	ps2 = con.prepareStatement(query2);
	        	ps2.setInt(1, user_bookID);
	            
	        	ps2.executeUpdate();
	        	
	        	check = 1;		// this status means book has more than 1 quantity, command.java display minus success (quantity - 1)
	            
	        } else {
	        	check = 2;		// this status means book has only 1 quantity, command.java should ask user to confirm remove
	        }
	        
	    } catch (SQLException e) {
	        throw new DaoException("saveBook " + e.getMessage());
	    } finally {
	        try {
	        	if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (ps2 != null) {
	                ps2.close();
	            }
	            if (con != null) {
	                freeConnection(con);
	            }
	        } catch (SQLException e) {
	            throw new DaoException("saveBook" + e.getMessage());
	        }
	    }
	    return check;
	}

public void clearMyBasket(int userID) throws DaoException {
	
	Connection con = null;
    PreparedStatement ps = null;
    try {
    	
        con = this.getConnection();
        
        String query = "DELETE FROM user_books WHERE userID = ?";
        ps = con.prepareStatement(query);
        ps.setInt(1, userID);
        ps.executeUpdate();
        
    } catch (SQLException e) {
        throw new DaoException("clearMyBasket " + e.getMessage());
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                freeConnection(con);
            }
        } catch (SQLException e) {
            throw new DaoException("clearMyBasket" + e.getMessage());
        }
    }
}

}
