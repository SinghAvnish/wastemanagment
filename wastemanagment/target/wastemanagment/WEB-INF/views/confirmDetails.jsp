
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
<div class="content" align="justify" style="background-color: light-grey;">
<fieldset>
				<legend>Confirm Details</legend>
				<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /><br />
				<sf:form commandName="user">
					<sf:label path="username">User Name:</sf:label>${user.username}
					<br /><br />
					<sf:label path="enabled">Enabled:</sf:label>${user.enabled}
					<br /><br />
					<sf:label path="role">Role:</sf:label>${user.role}
					<br /><br />
					
															
					<sf:label path="password">Password:</sf:label>${user.password}
										<br /><br />
										
					<sf:label path="email">Email:</sf:label>${user.email}
										<br /><br />
					
					<sf:label path="buildingName">Building Name:</sf:label>${user.buildingName}
										<br /><br />
					
					<sf:label path="street">Street:</sf:label>${user.street}
										<br /><br />
					
					<sf:label path="gender">Gender:</sf:label>${user.gender}
					<br /><br />
					
					<sf:label path="flatNo">Flat NO:</sf:label>${user.flatNo}
					<br /><br />
					
					<sf:label path="city">City:</sf:label>${user.city}
					<br /><br />
					
					<sf:label path="state">State:</sf:label>${user.state}
					<br /><br />
					
					<sf:label path="country">Country:</sf:label>${user.country}
					<br /><br />
					
					<input name="_eventId_edit" type="submit" value="Edit" /> 
					<input name="_eventId_submit" type="submit" value="Confirm Details" /><br />
					</sf:form>
					</fieldset>
					</div>
				
	
</body>
</html>