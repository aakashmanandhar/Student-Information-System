package com.aakash.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aakash.DTO.User;
import com.aakash.Util.DbUtil;

public class UserDAOImpl implements UserDAO{
	
	PreparedStatement ps = null;

	@Override
	public void saveUserInfo(User user) {
		String sql= "INSERT INTO user_tbl (email, user_name, password, image_url) VALUES (?,?,?,?)";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImageUrl());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUserInfo(User user) {
		String sql = "UPDATE user_tbl SET email=?, user_name=?, password=?, image_url=? WHERE id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImageUrl());
			ps.setInt(5, user.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUserInfo(int id) {
		String sql = "DELETE FROM user_tbl WHERE id=?";
		
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM user_tbl";
		
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setImageUrl(rs.getString("image_url"));
				userList.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserInfoById(int id) {
		User user = new User();
		String sql= "SELECT * FROM user_tbl WHERE id=?";
		
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setImageUrl(rs.getString("image_url"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String getImageUrlById(int id) {
		String sql = "SELECT image_url FROM user_tbl WHERE id=?";
		String imageUrl = "";
		
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				imageUrl = rs.getString("image_url");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageUrl;
	}

}
