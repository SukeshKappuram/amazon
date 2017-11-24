package com.devops.amazon.dao;

import java.util.List;

import com.devops.amazon.model.User;

public interface UserDAO {
	public int create(User u);
	public User read(User u);
	public int update(User u);
	public int delete(User u);
	public List<User> getAllUsers();
}
