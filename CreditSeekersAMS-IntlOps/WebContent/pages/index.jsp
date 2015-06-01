<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Credit Seeker</title>
<link href="<s:url value="/resources/css/style.css"/>" rel="stylesheet"
	type="text/css" />
</head>

<body>

	<div id="mainPan">

		<s:include value="/pages/template/Header.jsp"></s:include>

		<div id="rightPan">

			<div id="bodyPan" style="width:100%;margin:100px;text-align:center;">
				
			<s:a href="%{loginUrl}" theme="simple" key="label.login"></s:a>
				&nbsp;
			<s:a href="%{regUrl}" theme="simple" key="label.register"></s:a>
					
			</div>

		</div>

		<s:include value="/pages/template/Footer.jsp"></s:include>

	</div>



</body>
</html>