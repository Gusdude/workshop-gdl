<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Close a Credit</title>
</head>
<body>

	<div style="border: 2px solid rgb(45, 204, 83); width:600px;">
	<center>
	<h4 style="font-size:50px;">Close a Credit</h4>
	</center>
	<s:form action="close">
		<s:textfield name="id" label="Write the ID of the loan you want to close"/><br><br>
		
		<s:submit value="Submit"/>
		
		
	</s:form>
	
	</div>
</body>
</html>