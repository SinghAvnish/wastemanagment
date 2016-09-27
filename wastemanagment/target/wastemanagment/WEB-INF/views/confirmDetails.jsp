
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/header.jsp"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Details</title>
</head>
<body>
<div align="center" style="background-color: transparent;">

<table border="0">		
		<legend>Confirm Details</legend>
				<a href="${flowExecutionUrl}&_eventId_Home&_eventId_Home">Home</a><br /><br />
				<sf:form commandName="user">
				
				<tr>
					<sf:label path="username">User Name:</sf:label>${user.username}
				</tr>
				<br>
				
				<tr>
					<sf:label path="enabled">Enabled:</sf:label>${user.enabled}
				</tr>
				</td><br>
				
				
				<tr>
					<sf:label path="role">Role:</sf:label>${user.role}
				</tr>
				<br>
				
				
				<tr>
				<sf:label path="password">Password:</sf:label>${user.password}
				</tr>
				<br>
					
				
				<tr>
					<sf:label path="email">Email:</sf:label>${user.email}
				</tr>
				<br>
				
				
				<tr>
					<sf:label path="gender">Gender:</sf:label>${user.gender}
				</tr>
				<br>
					
				
				<tr>
					<sf:label path="buildingName">Building Name:</sf:label>${user.buildingName}
				</tr>
				<br>	
				
				
				<tr>
					<sf:label path="street">Street:</sf:label>${user.street}

				</tr>
				<br>
					
				
				<tr>
				<sf:label path="flatNo">Flat NO:</sf:label>${user.flatNo}
				</tr>
				<br>
				
				
				<tr>
				<sf:label path="city">City:</sf:label>${user.city}
				</tr>
				<br>
						
				
				<tr>
				<sf:label path="state">State:</sf:label>${user.state}
				</tr>
				<br>
					
				
				<tr>
				<sf:label path="country">Country:</sf:label>${user.country}
				</tr>
				<br>					
					<input name="_eventId_edit" type="submit" value="Edit" /> 
					<input name="_eventId_submit" type="submit" value="Confirm Details" /><br />
					</sf:form>
					</table>
					</div>
				
	
</body>
</html>