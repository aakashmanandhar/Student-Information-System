package com.aakash.DAO;

import java.util.List;

import com.aakash.DTO.User;

public interface UserDAO {

	public void saveUserInfo(User user);

	public void updateUserInfo(User user);

	public void deleteUserInfo(int id);

	public List<User> getAllUserInfo();

	public User getUserInfoById(int id);

	public String getImageUrlById(int id);
	
}
