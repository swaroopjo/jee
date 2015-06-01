<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

		<div id="rightPan">
		<div style="margin:15px;">
			
			<div style="font-color:red;">
				<s:actionerror />
			 </div>
			<br/>
			
			<s:if test="#session.privileges != null">    
    			<s:iterator value="#session.privileges" status="stat" var="priv">
    				 <s:if test="#priv =='EMPLOYEE'">
      		   		 	<s:form action="searchClient" method="post">
				
				<s:textfield  name="user.clientId" key="label.clientId"></s:textfield>
				<s:submit key="label.search"></s:submit>
				
			</s:form>
      		   		 </s:if>
      		   	</s:iterator>
			</s:if> 
			
			
			
			</div>
		</div>
	