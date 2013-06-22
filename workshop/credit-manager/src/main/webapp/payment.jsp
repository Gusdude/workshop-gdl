<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay previous loans</title>
</head>
<body>

	<div style="border: 2px solid rgb(45, 204, 83); width:600px;">
	<center>
	<h1 style="font-size:50px;">Bank Services</h1>
	
	<s:form action="choose">
		<s:textfield name="ID" label="Please write the ID of your loan"/><br>
		<s:textfield name="quantity" label="Please write how much you would like to pay"/><br>
		<br><s:submit value="Submit"/>
	</s:form>
	</center>
	</div>

</body>
</html>