package com.ccit.dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBManager {
	private static Connection con=null;
	private static Statement stat=null;
	private ResultSet rs=null;
	private int i=0;
	
	public DBManager()
	{
		try {
			con=new ComboPooledDataSource().getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection()
	{
	try {
		con=new ComboPooledDataSource().getConnection();
	} catch (SQLException e) {
		System.out.println("Connection false");
		e.printStackTrace();
	}
	return con;
	}
	
	
	
	
	public ResultSet ReadDB(String sql)
	{
		try {
			stat=DBManager.getConnection().createStatement();
			rs=stat.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("false getting database");
			e.printStackTrace();
		}
		return rs;
	}
	
	public int ModifyDB(String sql)
	{
		
		try {
			stat=DBManager.getConnection().createStatement();
		    i=stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("update database false");
			e.printStackTrace();
		}
		return i;	
	}
	
	public int getUserNum(String sql)
	{
		
		try {
			stat=DBManager.getConnection().createStatement();
			System.out.println(stat);
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				 i=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("get allusernum false");
			e.printStackTrace();
		}
		return i;		
	}

}



