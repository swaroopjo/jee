package com.csams.intlops.dao;

import com.csams.intlops.beans.User;

public interface UserDAO {

	public User findUserByClientId(Integer id)throws Exception;
	public int addUser(User user)throws Exception;
	public int updateUser(User user)throws Exception;
	public int deleteUser(User user)throws Exception;
	public User authenticateUser(User user)throws Exception;
	
	
}
