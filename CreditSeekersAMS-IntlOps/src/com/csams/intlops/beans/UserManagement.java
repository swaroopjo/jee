package com.csams.intlops.beans;

import java.util.List;

public class UserManagement {

	private String userName;
	private String password;
	private List<String> Privileges;
	private Integer profileId;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getPrivileges() {
		return Privileges;
	}
	public void setPrivileges(List<String> privileges) {
		Privileges = privileges;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	
	
}
