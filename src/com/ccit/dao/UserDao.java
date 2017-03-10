package com.ccit.dao;

import com.ccit.bean.User;

public interface UserDao
{
	public boolean addUser(User user);
	public boolean deleteUser(int id);
	public boolean deleteUser(String username);
	public boolean updateUser(User user);
	public int getCount();
}
