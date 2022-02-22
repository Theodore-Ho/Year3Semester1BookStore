package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.business.User;
import com.example.exceptions.DaoException;


public class UserDao extends Dao {

    public User findUserByUsernamePassword(String uname, String pword) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	int userId = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                u = new User(userId, firstname, lastname, username, password);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword " + e.getMessage());
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
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return u;     // u may be null 
    }

	public Boolean registerUser(String firstname, String lastname, String username, String password) throws DaoException {
		
    	Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        Boolean registerSuccess = false;
        try {
            con = this.getConnection();
            
            String query1 = "SELECT * FROM USER where USERNAME = ?";
            ps = con.prepareStatement(query1);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next() == false) {			// check exists username
            	String query2 = "INSERT INTO user (ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES (NULL, ?, ?, ?, ?);";
            	
            	ps2 = con.prepareStatement(query2);
            	ps2.setString(1, firstname);
            	ps2.setString(2, lastname);
            	ps2.setString(3, username);
            	ps2.setString(4, password);
            	
            	ps2.executeUpdate();
            	
            	registerSuccess = true;
            } else {
            	registerSuccess = false;
            }
            
        } catch (SQLException e) {
            throw new DaoException("registerUser " + e.getMessage());
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
                throw new DaoException("registerUser" + e.getMessage());
            }
        }
		return registerSuccess;
	}
	
	public Boolean updateUser(int userID, String firstname, String lastname, String username, String password) throws DaoException {
		
    	Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        Boolean updateSuccess = false;
        try {
            con = this.getConnection();
            
            String query1 = "SELECT * FROM USER where USERNAME = ?";
            ps = con.prepareStatement(query1);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {			// check exists username
            	int DBuserId = rs.getInt("ID");
            	if(DBuserId == userID) {		// check userID, if same, then update; if not, update false
            		String query2 = "UPDATE user SET FIRST_NAME = ?, LAST_NAME = ?, USERNAME = ?, PASSWORD = ? WHERE user.ID = ?";
            	
	            	ps2 = con.prepareStatement(query2);
	            	ps2.setString(1, firstname);
	            	ps2.setString(2, lastname);
	            	ps2.setString(3, username);
	            	ps2.setString(4, password);
	            	ps2.setInt(5, userID);
	            	
	            	ps2.executeUpdate();
	            	
	            	updateSuccess = true;
            	} else {
            		updateSuccess = false;
            	}
            } else {
            	String query2 = "UPDATE user SET FIRST_NAME = ?, LAST_NAME = ?, USERNAME = ?, PASSWORD = ? WHERE user.ID = ?";
            	
            	ps2 = con.prepareStatement(query2);
            	ps2.setString(1, firstname);
            	ps2.setString(2, lastname);
            	ps2.setString(3, username);
            	ps2.setString(4, password);
            	ps2.setInt(5, userID);
            	
            	ps2.executeUpdate();
            	
            	updateSuccess = true;
            }
            
        } catch (SQLException e) {
            throw new DaoException("registerUser " + e.getMessage());
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
                throw new DaoException("registerUser" + e.getMessage());
            }
        }
		return updateSuccess;
	}
}
