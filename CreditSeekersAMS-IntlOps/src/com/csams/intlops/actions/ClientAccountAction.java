package com.csams.intlops.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csams.intlops.beans.User;
import com.csams.intlops.business.UserAccountBusinessFacade;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClientAccountAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ClientAccountAction.class);

	private User user;
	
	private String serverTime;
	private static int totalVisits;

	@Action(value = "/searchClient", results = { 
			@Result(name = "success", location = "viewAccountInfo", type = "tiles"),
			@Result(name = "failure", location = "searchClient", type = "tiles")})
	public String searchClient() {
		
		if(user.getClientId() == null || user.getClientId() == 0){
			addActionError("Client Id cannot be Empty or zero");
			return "failure";
		}
		User usr = new UserAccountBusinessFacade().findClientById(user.getClientId());
		if(usr == null){
			addActionError("User not found");
			return "failure";
			
		}
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("clientUserId", usr.getUserId());
		ActionContext.getContext().setSession(session);
		
		this.user = usr;
		return "success";
	}	
	
	@Action(value = "/editAccountInfo", results = {
			@Result(name = "success", location = "editAccountInfo", type = "tiles")})
	public String editClientAccount() {
	
		
		
		return "success";
	}	
	
	@Action(value = "/confirmEdit", results = {
			@Result(name = "success", location = "viewAccountInfo", type = "tiles"),
			@Result(name = "loginPage", location = "login", type = "tiles")})
	public String confirmEdit() {
		logger.info("Client details Edited");
		
		if(ActionContext.getContext().getSession() == null || isNullOrEmpty(ActionContext.getContext().getSession().get("clientUserId").toString())){
			addActionError("Session Invalid");
			return "loginPage";
		}
		user.setUserId(Integer.parseInt(ActionContext.getContext().getSession().get("clientUserId").toString()));
		
		new UserAccountBusinessFacade().updateAccount(user);
		
		return "success";
	}	
	
	@Action(value = "/confirmDelete", results = {
			@Result(name = "success", location = "searchClient", type = "tiles"),
			@Result(name = "loginPage", location = "login", type = "tiles")})
	public String confirmDelete() {
		
		if(ActionContext.getContext().getSession() == null){
			addActionError("Session Invalid");
			return "loginPage";
		}
		user.setUserId(Integer.parseInt(ActionContext.getContext().getSession().get("clientUserId").toString()));
		new UserAccountBusinessFacade().deleteAccount(user);
		logger.info("Client details Deleted");
		
		return "success";
	}	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

private boolean isNullOrEmpty(String strObj) {
		
		if(strObj != null && !strObj.equals("") && !strObj.equalsIgnoreCase("") ){
			return false;
		}
		return true;
	}

	
	

}