package com.csams.intlops.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.csams.intlops.beans.User;
import com.csams.intlops.business.UserAccountBusinessFacade;
import com.csams.intlops.dao.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

	private User user;
	private Integer id;
	Map<String,Object> sessMap;

	private String serverTime;
	private static int totalVisits;

	@Action(value = "/login", results = {
			@Result(name = "loginPage", location = "login", type = "tiles")})
	public String login() {
		
		return "loginPage";
	}	

	@Action(value = "/registration", results = {
			@Result(name = "registrationPage", location = "registration", type = "tiles")
			 })
	public String registration() {
		System.out.println("totalVisits = " + ++totalVisits);
		return "registrationPage";
	}
	
	@Action(value = "/register", results = {
			@Result(name = "success", location = "register.success", type = "tiles"),
			@Result(name = "failure", location = "registration", type = "tiles")
			 })
	public String register() {
		
		return "succcess";
	}

	@Action(value = "/logout", results = { @Result(name = "success", location = "logout.success", type = "tiles") })
	public String logout() {
		System.out.println("totalVisits = " + ++totalVisits);
		return "success";
	}
	
	@Action(value = "/home", results = { @Result(name = "success", location = "searchClient", type = "tiles") })
	public String home() {
		
		return "success";
	}
	
	@Action(value = "/editMyAccountInfo", results = {
			@Result(name = "success", location = "editMyAccountInfo", type = "tiles")})
	public String editMyAccount() {
		
		
		
		return "success";
	}	
	
	@Action(value = "/confirmMyAccountEdit", results = {
			@Result(name = "success", location = "viewMyAccountInfo", type = "tiles")})
	public String confirmEdit() {

		logger.info("Client details Edited");
		
		user.setUserId(Integer.parseInt(ActionContext.getContext().getSession().get("userId").toString()));
		
		new UserAccountBusinessFacade().updateAccount(user);
		
		return "success";
	}	
	
	
	
	
	@Action(value = "/mngAccount", results = {
			@Result(name = "success", location = "viewMyAccountInfo", type = "tiles"),
			@Result(name = "failure", location = "search",type = "tiles") })
	public String manageAccount() {
		
		if(ActionContext.getContext().getSession().get("userId") == null){
			logger.error("You are not a valid user");
			addActionError("Cannot Modify Account");
			return "failure";
		}
		User authUser = null;
		logger.info("Getting your Information");
		try {
			
			authUser = new UserDAOImpl().findUserById(Integer.parseInt(ActionContext.getContext().getSession().get("userId").toString()));
			this.user=authUser;
			
		} catch (Exception e) {
			addActionError("User Does not exist"+e);
			logger.error("critical", e);
			return "failure";
		}
		
		return "success";
	}
	
	@Action(value = "/authenticate", results = {
			@Result(name = "success", location = "searchClient", type = "tiles"),
			@Result(name = "failure", location = "login",type = "tiles") })
	public String authenticate() {
		
		if(user == null || user.getUserManagement() == null 
				|| (isNullOrEmpty(user.getUserManagement().getUserName()) || isNullOrEmpty(user.getUserManagement().getPassword()))){
			logger.info("User Name and Password cannot be empty");
			addActionError("User Name and Password cannot be empty");
			return "failure";
		}
		
		logger.info("Authenticating User");
		User authUser = null;
		try {
			
			authUser = new UserDAOImpl().authenticateUser(user);
			if(authUser != null){
				this.id=authUser.getUserId();
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("userId", authUser.getUserId());
				session.put("privileges", authUser.getUserManagement().getPrivileges());
				session.put("isUserValid",true);
				ActionContext.getContext().setSession(session);
			}
			else{
				logger.info("User does not exists");
				addActionError("User Does not exist");
				return "failure";
			}
			
		} catch (Exception e) {
			addActionError("User Does not exist");
			logger.error("critical", e);
			return "failure";
		}
		
		return "success";
	}

	private boolean isNullOrEmpty(String strObj) {
		
		if(strObj != null && !strObj.equals("") && !strObj.equalsIgnoreCase("") ){
			return false;
		}
		return true;
	}

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}

	public int getTotalVisits() {
		return totalVisits;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
