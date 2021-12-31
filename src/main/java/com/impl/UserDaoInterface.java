package com.impl;

import com.stockproject.model.User;

public interface UserDaoInterface {
	public  void insert(User users);
	public   int validateUser(User us);
	public void updated(User userupdate);
	public void delete(User userdelete);
	
	
}
