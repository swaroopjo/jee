package com.csams.intlops.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csams.intlops.beans.User;
import com.csams.intlops.beans.UserManagement;

public class UserDAOImpl extends AbstractDAO implements UserDAO{

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	
	public User findUserByClientId(Integer clientId)throws Exception{
		
		this.dbSetup();
		PreparedStatement pstmt = null;
		 User user = null;
		try{
			 String query = "SELECT USER_ID as userId," +
			 						"ACCOUNT_NAME AS userName," +
			 						"STREET1 AS street1," +
			 						"STREET2 AS street2," +
			 						"STATE AS state," +
			 						"CITY AS city," +
			 						"ZIPCODE AS zipCode," +
			 						"CLIENT_ID AS clientId FROM USER_INFO "  +
			 				"WHERE CLIENT_ID=?";
			 
			 logger.info(query);
			 pstmt = this.connection.prepareStatement(query);
			 pstmt.setInt(1,clientId);
			
			 ResultSet rs = pstmt.executeQuery();
			 
			 
			 if(rs.next()){
				 user = new User();
				 user.setUserId(rs.getInt("userId"));
				 user.setCity(rs.getString("city"));
				 user.setClientId(rs.getInt("clientId"));
				 user.setState(rs.getString("state"));
				 user.setStreet1(rs.getString("street1"));
				 user.setStreet2(rs.getString("street2"));
				 user.setUserName(rs.getString("userName"));
				 user.setZipcode(rs.getInt("zipCode"));
				 
			 }
			 rs.close();
			 pstmt.close();
		}
		catch(Exception e){
			logger.info(e.toString());
			throw new Exception("User could not be Updated");
		}
		finally{
			this.dbShutdown();
		}
		
		
		return user;
	}
	
public User findUserById(Integer clientId)throws Exception{
		
		this.dbSetup();
		PreparedStatement pstmt = null;
		 User user = null;
		try{
			 String query = "SELECT USER_ID as userId," +
			 						"ACCOUNT_NAME AS userName," +
			 						"STREET1 AS street1," +
			 						"STREET2 AS street2," +
			 						"STATE AS state," +
			 						"CITY AS city," +
			 						"ZIPCODE AS zipCode," +
			 						"CLIENT_ID AS clientId FROM USER_INFO "  +
			 				"WHERE USER_ID=?";
			 
			 logger.info(query);
			 pstmt = this.connection.prepareStatement(query);
			 pstmt.setInt(1,clientId);
			
			 ResultSet rs = pstmt.executeQuery();
			 
			 
			 if(rs.next()){
				 user = new User();
				 user.setUserId(rs.getInt("userId"));
				 user.setCity(rs.getString("city"));
				 user.setClientId(rs.getInt("clientId"));
				 user.setState(rs.getString("state"));
				 user.setStreet1(rs.getString("street1"));
				 user.setStreet2(rs.getString("street2"));
				 user.setUserName(rs.getString("userName"));
				 user.setZipcode(rs.getInt("zipCode"));
				 
			 }
			 rs.close();
			 pstmt.close();
		}
		catch(Exception e){
			logger.info(e.toString());
			throw new Exception("User could not be Updated");
		}
		finally{
			this.dbShutdown();
		}
		
		
		return user;
	}
	

	public int addUser(User user)throws Exception{
		
		this.dbSetup();
		PreparedStatement pstmt = null;
		int rowsUpdated = 0;
		try{
			 String query = "INSERT INTO USER_INFO VALUES(" +
			 		"?,?,?,?,?,?,?,?)";
					 pstmt = this.connection.prepareStatement(query);
					
					 pstmt.setString(1, null);
					 pstmt.setString(2, user.getUserName());
			 pstmt.setString(3, user.getStreet1());
			 pstmt.setString(4, user.getStreet2());
			 pstmt.setString(5, user.getState());
			 pstmt.setString(6,user.getCity());
			 pstmt.setInt(7, user.getZipcode());
			 pstmt.setInt(8, user.getClientId());
			 
			 logger.info(query);
			 
			 rowsUpdated = pstmt.executeUpdate();
			 
			 pstmt.clearBatch();
			 
			 connection.commit();
			 pstmt.close();
		}
		catch(Exception e){
			logger.error(e.toString());
			connection.rollback();
			throw new Exception("User could not be Updated");
		}
		finally{
			 
			this.dbShutdown();
		}
		
		return rowsUpdated;
	}
	
	public int updateUser(User user)throws Exception{
		
		this.dbSetup();
		PreparedStatement pstmt = null;
		int rowsUpdated = 0;
		try{
			 String query = "UPDATE USER_INFO SET ACCOUNT_NAME=?,STREET1=?,STREET2=?,STATE=?,CITY=?,ZIPCODE=? WHERE USER_ID = ?";
			 pstmt = this.connection.prepareStatement(query);
			 pstmt.setString(1, user.getUserName());
			 pstmt.setString(2, user.getStreet1());
			 pstmt.setString(3, user.getStreet2());
			 pstmt.setString(4, user.getState());
			 pstmt.setString(5,user.getCity());
			 pstmt.setInt(6, user.getZipcode());
			 pstmt.setInt(7, user.getUserId());
			 
			 logger.info(query);
			 rowsUpdated = pstmt.executeUpdate();
			 connection.commit();
			 pstmt.close();
		}
		catch(Exception e){
			logger.error(e.toString());
			connection.rollback();
			throw new Exception("User could not be Updated");
		}
		finally{
			 
			this.dbShutdown();
		}
		
		return rowsUpdated;
	}
	
	public int deleteUser(User user)throws Exception{
		
		this.dbSetup();
		PreparedStatement pstmt = null;
		int rowsUpdated = 0;
		try{
			 String query ="DELETE FROM USER_INFO WHERE USER_ID=?";
			 pstmt = this.connection.prepareStatement(query);
			 pstmt.setInt(1, user.getUserId());
			 
			 logger.info(query);
			 rowsUpdated = pstmt.executeUpdate();
			 connection.commit();
			 pstmt.close();
		}
		catch(Exception e){
			connection.rollback();
			logger.error(e.toString());
			throw new Exception("User could not be Updated");
		}
		finally{
			this.dbShutdown();
		}
		
		return rowsUpdated;
	}


@Override
public User authenticateUser(User user) throws Exception {
	this.dbSetup();
	PreparedStatement pstmt = null;
	 User authUser = null;
	try{
		String userQuery = "SELECT u.USER_ID AS userId,up.ROLE AS role" +
								  " FROM USER_INFO u, USERMANAGEMENT um, USER_PROFILE up" +
								  " WHERE u.USER_ID = um.USER_ID" +
								  " AND um.PROFILE_ID = up.PROFILE_ID" +
									" AND um.USERNAME = ?" +
									" AND um.PASSWORD = ?";
									
		logger.info(userQuery);
		 pstmt = this.connection.prepareStatement(userQuery);
		 pstmt.setString(1,user.getUserManagement().getUserName());
		 pstmt.setString(2, user.getUserManagement().getPassword());
		
		 ResultSet rs = pstmt.executeQuery();
		 authUser = new User();
		 UserManagement userM = new UserManagement(); 
		 List<String> privileges = new ArrayList<String>();
		 boolean exists = false;
		 
		 while(rs.next()){
			 exists = true;
			 authUser.setUserId(rs.getInt("userId"));
			 privileges.add(rs.getString("role"));
			 
		 }
		 rs.close();
		 pstmt.close();
		 
		 if(exists){
			 userM.setPrivileges(privileges);
			 authUser.setUserManagement(userM);
		 }
//		 else{
//			 logger.error("User does not exists");
//			 throw new Exception("User does not exists");
//			 
//		 }
		
	}
	catch(Exception e){
		throw new Exception("Database error",e);
	}
	finally{
		this.dbShutdown();
	}
	
	
	return authUser;
}


	
}
