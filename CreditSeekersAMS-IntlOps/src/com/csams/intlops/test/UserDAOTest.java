package com.csams.intlops.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csams.intlops.actions.LoginAction;
import com.csams.intlops.beans.User;
import com.csams.intlops.beans.UserManagement;
import com.csams.intlops.dao.UserDAO;
import com.csams.intlops.dao.UserDAOImpl;

public class UserDAOTest {

	 private  UserDAO userDAOImpl = null;
	 private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

//	public static void main(String[] args) throws InterruptedException{
//		
////		logger.info("");
////		testFindUserByClientId();
////		Thread.sleep(1000);
////		System.out.println("\n");
////		//testUpdateUser();
////		Thread.sleep(1000);
////		System.out.println("\n");
////		testAuthenticateUser();
////		System.out.println("\n");
//		
//	}
	
	private User newUser = null;
	
	@Before
	public void setUp(){
		 this.userDAOImpl = new UserDAOImpl();
		 
		 User user = new User();
			UserManagement userMg = new UserManagement();
			int clientId =200;
			user.setCity("FairFax");
			user.setClientId(clientId);
			user.setState("Virginia");
			user.setStreet1("9146 barrick st");
			user.setStreet2("APT 203");
			user.setUserName("Jyothiswaroop");
			user.setZipcode(20130);
			userMg.setPassword("swaroop123");
			userMg.setUserName("swaroop");
			userMg.setProfileId(3);
			user.setUserManagement(userMg);
			
			this.newUser = user;
			
	}
	
	@Test
	public  void testFindUserByClientId() throws Exception{
		
			assertNotNull(userDAOImpl.findUserByClientId(100));
		
	}
	@Test
	public  void testAddUser() throws Exception{
		
	
			assertEquals(1,userDAOImpl.addUser(newUser));
		
	}

	@Test
public  void testUpdateUser()throws Exception{
	
		User before = userDAOImpl.findUserByClientId(100);
		if(before.getUserName().equalsIgnoreCase("swaroop")){
			before.setUserName("Jyothiswaroop");
		}
		else{
			before.setUserName("swaroop");
			}
		userDAOImpl.updateUser(before);
		
		User after = userDAOImpl.findUserByClientId(100);
		
		
		assertNotSame(before,after);
		
		
		
	
}
	@Test
public  void testAuthenticateUser()throws Exception{
	
	
		assertNotNull(userDAOImpl.authenticateUser(newUser));
	
}



}
