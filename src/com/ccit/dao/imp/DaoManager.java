package com.ccit.dao.imp;


import com.ccit.dao.InforDao;
import com.ccit.dao.ResgisterDao;

import com.ccit.dao.UserDao;

/**
 *	Éú²údao
 * @author CCIT
 *
 */
public interface DaoManager
{
	public UserDao udi = new UserDaoImp();
	public InforDao idi = new InforDaoImp();
	public ResgisterDao rdi = new ResgisterDaoImp();
}
