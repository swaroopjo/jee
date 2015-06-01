<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<s:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css" />
<title>Struts2 Annotations and Tiles Integration Example - <tiles:insertAttribute
		name="title" ignore="true" />
		
</title>
		
</head>
<body>
<div id="mainPan">

	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="nav" />
	<tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
 
  </div>
  


</body>

</html>
