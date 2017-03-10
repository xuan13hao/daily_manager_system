package com.ccit.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ccit.bean.User;
import com.ccit.dao.UserDao;
import com.ccit.dbcon.DBManager;
import com.ccit.dbpool.DBMImp;

public class UserDaoImp implements UserDao{
	private DBManager DBM=null;
	private int i=0;
	
	public boolean addUser(User user) {
		String sql="insert into user(username,password,rights) values('"+user.getUsername()+"','"+user.getPassword()+"',"+user.getRights()+")";
		DBMImp di=new DBMImp();
		return di.ConData(sql);

	}
	public boolean deleteUser(int id) {
		
		String sql="delete from user where id="+id;
		DBMImp di=new DBMImp();
		return di.ConData(sql);
	}
	public boolean deleteUser(String username) {
		String sql="delete from user where username="+username;
		DBMImp di=new DBMImp();
		return di.ConData(sql);
	}
	public boolean updateUser(User user) {
		String sql="update user set password = '"+user.getPassword()+"', rights = "+user.getRights()+" where username = '"+user.getUsername()+"'";
		DBMImp di=new DBMImp();
		return di.ConData(sql);
	}
	public int getCount() {
		String sql="selec count(*) from user";
		DBM=new DBManager();
		i=DBM.getUserNum(sql);
		return i;
		
	}
	public int loginUser(User user)
	{
		int states = 0;
		DBM=new DBManager();
		User u=new User();
		String sql = "select * from user where username = '" + user.getUsername() + "' and rights = " + user.getRights();
		ResultSet rs=DBM.ReadDB(sql);
		if(u!=null)
		{
			if(u.getPassword().equals(user.getPassword()))
				states = 1;
			else
				states = 2;
		}
		return states;
	}
}
