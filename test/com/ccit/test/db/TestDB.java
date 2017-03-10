package com.ccit.test.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.ccit.dbcon.DBManager;

public class TestDB {

	@Test
	public void test() throws SQLException {
		DBManager dbm=new DBManager();
		//System.out.println("******");
		//String sql="insert into user(username,password,rights) values('admin','123',1)";
		//dbm.ModifyDB(sql);"select count(id) from user"
	
		int t=dbm.getUserNum("select count(*) from user");
		
		System.out.println(t);
		//Connection con=DBManager.getConnection();
		//System.out.println("connection:\t" + con);
		/*
		while(dbm.ReadDB("select * from user").next())
		{
			
			//System.out.println(dbm.ReadDB("select * from user").getString("username"));
			System.out.println("******");
			//dbm.ReadDB("select * from user").getString(2);
		};
		*/
	
	}

}
