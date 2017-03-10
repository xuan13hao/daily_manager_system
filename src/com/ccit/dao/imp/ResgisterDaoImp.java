package com.ccit.dao.imp;

import java.sql.SQLException;

import com.ccit.bean.Register;
import com.ccit.dao.ResgisterDao;
import com.ccit.dbcon.DBManager;
import com.ccit.dbpool.DBMImp;

public class ResgisterDaoImp implements ResgisterDao{
	DBManager DBM=null;
	
public boolean addRegister(Register register) {
	String sql="insert into register(username,coder,isRegister) values('"+register.getUsername()+"','"+register.getCoder()+"',"+register.getIsRegister()+")";
	DBMImp di=new DBMImp();
	return di.ConData(sql);
}
	
	public String getCoder(String username) {
		String coder=null;
		String sql="select * from user where="+username;
		DBM=new DBManager();
		try {
			if(!DBM.ReadDB(sql).next());
			coder="Welcome to register";
		} catch (SQLException e) {
			System.out.println("获取验证码出错");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean changeStates(String username) {
		
		return false;
	}


}
