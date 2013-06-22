<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a New Loan</title>
</head>
<body>
<div style="border: 2px solid rgb(45, 204, 83); width:600px;">
	<center>
	<h1 style="font-size:50px;">New Loan</h1>
	</center>
	
	<s:form action="addAction">
		<s:textfield name="name" label="Name" />
		<s:textfield name="lastname" label="Last Name" />
		<s:textfield name="loan" label="For how much do you want the loan? "/>
		<s:submit value="Submit"/>	
	</s:form>
	
	</div>
</body>
</html>