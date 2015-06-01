<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

		<div class="logincontainer" style="margin-left:100px;margin-top:20px;margin-bottom:20px;" >
			<s:actionerror />
			<s:form action="authenticate" method="post">
				
				<s:textfield name="user.userManagement.userName" key="label.req.username"></s:textfield>
				<s:password name="user.userManagement.password" key="label.req.password"></s:password>
				<s:submit value="login"></s:submit>
				
			</s:form>
			
			<br/>
			
			<s:url id="fPass" value="forgotPassword" />
			<s:url id="regUrl" value="registration" />
			
			<div style="margin-left:10px;">
			<s:a href="%{fPass}" theme="simple">Forgot Password</s:a>
			&nbsp;&nbsp;
			<s:a href="%{fPass}" theme="simple">Help</s:a>
			
			<br/>
			<br/>
			
			<s:a href="%{regUrl}" theme="simple">Need to Register</s:a>
			&nbsp;&nbsp;
			<s:a href="%{regUrl}" theme="simple">Register</s:a>
			</div>
		</div>
	