<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

		<div id="rightPan">
			<div style="margin:15px;">
			
			<div style="font-color:red;">
				<s:actionerror />
			 </div>
			 
			<s:form action="confirmEdit"  method="post">
				
				<s:textfield name="user.userName" key="label.req.username"/>
				<s:textfield name="user.street1"  key="label.req.address"/>
				<s:textfield name="user.street2" key="label.req.street2"/>
				<s:textfield name="user.city"  key="label.req.city"/>
				<s:textfield name="user.state"  key="label.req.state"/>
				<s:textfield name="user.zipcode"  key="label.req.zipcode"/>
				
				
				<s:submit  key="label.confirmEdit">
				</s:submit>
				
			</s:form>
			</div>
			</div>
			
		