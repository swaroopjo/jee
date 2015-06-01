<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

		<div id="rightPan">
		<div style="margin:15px;">
		
			<div style="font-color:red;">
				<s:actionerror />
			 </div>
			 <br/>
			    <s:hidden name="user.userId"></s:hidden>
				<s:text name="User Name :"/> &nbsp; <s:property value="user.userName"/><br/><br/>
				<s:text name="Street Line 1 :"/> &nbsp; <s:property value="user.street1"/><br/><br/>
				<s:text name="Street Line 2 :"/> &nbsp; <s:property value="user.street2"/><br/><br/>
				<s:text name="City :"/> &nbsp; <s:property value="user.city"/><br/><br/>
				<s:text name="State :"/> &nbsp; <s:property value="user.state"/><br/><br/>
				<s:text name="ZIPCode :"/> &nbsp; <s:property value="user.zipcode"/><br/><br/>
		
			<s:form action="editAccountInfo" method="post">
				<s:submit key="label.edit"></s:submit>
				<s:param name="id" value="user.userId" />
			</s:form>
			<br/>
			<s:if test="#session.privileges != null">    
    			<s:iterator value="#session.privileges" status="stat" var="priv">
    				 <s:if test="#priv =='EMPLOYEE'">
      		   		 	<s:form action="confirmDelete" method="post">
							<s:submit key="label.delete"></s:submit>
						</s:form>
      		   		 </s:if>
      		   	</s:iterator>
			</s:if> 


		
			</div>
		</div>
	