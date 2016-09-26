	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/header.jsp"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-theme.min.css" />
<script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>


<body>
 <div align="center" style="background-color: transparent;">
	
		<%-- <c:url var="addAction" value="/user/add"></c:url> --%>
		<a href="${flowExecutionUrl}&_eventId_Home&_eventId_Home">Home</a>
		<form:form class="form-vertical" role="form" action="${addAction}"
			commandName="user">
			
              
                <table border="0">
				<tr>
				<td colspan="2" align="center"><h2> Register Here </h2></td>
				</tr>
				<tr><td>User Name:</td>
				<td><form:input path="username" /></td>
				</tr>
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('username')}" var="err">
				<span>${err.text}</span>
				</c:forEach>
				<tr><td>Enabled:</td>
				<td><form:input path="enabled" /></td>
				</tr>
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('enabled')}" var="err">
				<span>${err.text}</span>
				</c:forEach>
				<tr><td>Role:</td>
				<td><form:input path="role" /></td>
				</tr>
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('role')}" var="err">
				<span>${err.text}</span>
				</c:forEach>
				<tr><td>Password:</td>
				<td><form:input path="password" /></td>
				</tr>
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
				<span>${err.text}</span>
				</c:forEach>
				<tr><td>Gender:</td>
				<td><form:input path="gender" /></td>
				</tr>   
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('gender')}" var="err">
				<span>${err.text}</span>
				</c:forEach>
				 <tr><td>Email:</td>
				<td><form:input path="email" /></td>
				</tr>
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email')}" var="err">
			    <span>${err.text}</span>
				</c:forEach>
                <tr><td>Building Name</td>
				<td><form:input path="buildingName" /></td>
				</tr>
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('buildingName')}" var="err">
				<span>${err.text}</span>
				</c:forEach>
            	 <tr>
                  <tr><td>Flat No</td>
				<td><form:input path="flatNo" /></td>
				</tr>   
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('flatNo')}" var="err">
				<span>${err.text}</span>
				</c:forEach>
				<tr><td>Street:</td>
				<td><form:input path="street" /></td>
				</tr>  
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('street')}" var="err">
				<span>${err.text}</span>
				</c:forEach>        
                 <tr>
                  <tr><td>City Name:</td>
				<td><form:input path="city" /></td>
				</tr>  
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('city')}" var="err">
				<span>${err.text}</span>
				</c:forEach>           
                <tr>
                  <tr><td>State Name:</td>
				<td><form:input path="state" /></td>
				</tr>   
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('state')}" var="err">
				<span>${err.text}</span>
				</c:forEach>        
                 <tr><td>Country Name:</td>
				<td><form:input path="country" /></td>
				</tr> 
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('country')}" var="err">
				<span>${err.text}</span>
				</c:forEach>               
              <tr>
                    <td colspan="2" align="center"><input name="_eventId_submit" type="submit" value="Register" /></td>
                </tr>
</table>
</form:form>
</center>
</body>

</html>
