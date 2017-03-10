package com.ccit.dao.imp;

import java.util.ResourceBundle;

public class DaoFactory
{
	public static Object getDao(String daoName)
	{
		ResourceBundle res = ResourceBundle.getBundle("dao");
		String daoImp = res.getString(daoName);
		Object obj = null;
		try
		{
			obj = Class.forName(daoImp);
		} catch (ClassNotFoundException e)
		{
			System.out.println("通过反射获取daoName出现异常");
			e.printStackTrace();
		}
		return obj;
	}
}
