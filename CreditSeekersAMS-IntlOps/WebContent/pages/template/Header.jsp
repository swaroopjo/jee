<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="header" style="width:100%;height:70px;">
		<div id="topPan" >
		
		<h3 style="margin-top:10px;">Credit Seeker IntlOps</h3> 
		
		<ul>
			
			<s:url id="loginUrl" value="login" />
			<s:url id="regUrl" value="registration" />
			
			<s:a href="%{loginUrl}" theme="simple">Login</s:a>
			<s:a href="%{regUrl}" theme="simple">Register</s:a>

		</ul>
		<p></p>
	</div>
</div>