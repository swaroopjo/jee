<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

		<div class="regContainer"  style="margin-left:100px;margin-top:20px;margin-bottom:20px;">
			<s:form action="register" method="post">
				<s:textfield name="name" label="Name"></s:textfield>
				<s:password name="password" label="Password"></s:password>
				<s:submit value="login"></s:submit>
			</s:form>
		</div>
	