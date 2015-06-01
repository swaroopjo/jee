package com.csams.intlops.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csams.intlops.beans.User;
import com.csams.intlops.dao.UserDAO;
import com.csams.intlops.dao.UserDAOImpl;

public class UserAccountBusinessFacade {

	UserDAO userDAOImpl = new UserDAOImpl();
	private static final Logger logger = LoggerFactory.getLogger(UserAccountBusinessFacade.class);
	
	public int updateAccount(User user){
		try {
			userDAOImpl.updateUser(user);
		} catch (Exception e) {
			logger.error("Business Error : "+e);
			e.printStackTrace();
		}
		return 0;
	}
	public User viewAccount(Integer userId){
		
		return null;
	}
	
	public int deleteAccount(User user){
		try {
			userDAOImpl.deleteUser(user);
		}
		catch(Exception e){
			logger.error("Business Error : "+e);
			e.printStackTrace();
		}
		return 0;
	}
	
	public User findClientById(Integer clientId){
		User user = null;
		try {
			user = userDAOImpl.findUserByClientId(clientId);
		} catch (Exception e) {
			logger.error("Business Error : "+e);
			e.printStackTrace();
		}
		return user;
	}
	
	
}
