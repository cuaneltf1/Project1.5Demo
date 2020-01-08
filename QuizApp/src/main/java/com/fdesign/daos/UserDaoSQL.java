package com.fdesign.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdesign.models.User;
import com.fdesign.models.UserSecure;
import com.fdesign.util.ConnectionUtil;

public class UserDaoSQL implements UserDao {
	
	//MAGIC STRINGS
	private static final String FIND_REGULAR_USERS = "SELECT user_id, username FROM q_users WHERE authority = 0";
	
	private static final String LOGIN_AUTHENTICATION = "SELECT * FROM q_users " + "WHERE username = ? AND password = ?";
	
	User extractUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("user_id");
		String rsUsername = rs.getString("username");
		String rsPassword = rs.getString("password");
		int rsAuthority = rs.getInt("authority");
		return new User(id, rsUsername, rsPassword, rsAuthority);
		
	}
	
	UserSecure extractUserSecure(ResultSet rs) throws SQLException {
		int usid = rs.getInt("user_id");
		String rsUsI = rs.getString("username");
		return new UserSecure(usid, rsUsI);
		
	}

	@Override
	public List<UserSecure> findRegularUsers() {
		try (Connection c = ConnectionUtil.getConnection()){ 
			
			PreparedStatement ps = c.prepareStatement(FIND_REGULAR_USERS);
			
			ResultSet rs = ps.executeQuery();
			List<UserSecure> us = new ArrayList<UserSecure>();
			while (rs.next()) {
				us.add(extractUserSecure(rs));
			}
			
			return us;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginAuthentication(String username, String password) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(LOGIN_AUTHENTICATION);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return extractUser(rs);
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

}
