package com.ccit.dbpool;

import com.ccit.dbcon.DBManager;

public class DBMImp {
	DBManager DBM=null;
	private int id=0;
	public DBMImp(){}
	public  boolean ConData(String sql)
	{
		DBM=new DBManager();
		
		int i=DBM.ModifyDB(sql);
		if(i>0)
			return true;
		else
			return false;	
	}

}
