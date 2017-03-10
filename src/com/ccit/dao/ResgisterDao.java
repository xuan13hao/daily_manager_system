package com.ccit.dao;

import com.ccit.bean.Register;


public interface ResgisterDao{
	
    public boolean addRegister(Register register);
	
	public String getCoder(String username);
	
	public boolean changeStates(String username);

}
