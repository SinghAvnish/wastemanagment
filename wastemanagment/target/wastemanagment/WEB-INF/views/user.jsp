<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-theme.min.css" />
<script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
</head>
<body>

<div class="container" style="background-color: lavenderblush;">
	<h2>
		<center>Registration Form</center>
		
	</h2>
	<center>
		<c:url var="addAction" value="/user/add"></c:url>

		<form:form class="form-horizontal" role="form" action="${addAction}"
			commandName="user">
<table>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="username">
				<spring:message text="USER NAME" />
				</form:label></td>
		<td><form:input class="form-control" path="username" /></td>
				</div>
				</tr>						
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="password">
				<spring:message text="PASSWORD" />
				</form:label></td>
		<td><form:input class="form-control" path="password" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="enabled">
				<spring:message text="ENABLED" />
				</form:label></td>
		<td><form:input class="form-control" path="enabled" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="role">
				<spring:message text="ROLE" />
				</form:label></td>
		<td><form:input class="form-control" path="role" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="email">
				<spring:message text="EMAIL" />
				</form:label></td>
		<td><form:input class="form-control" path="email" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="gender">
				<spring:message text="GENDER" />
				</form:label></td>
		<td><form:input class="form-control" path="gender" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="flatNo">
				<spring:message text="FLATNO" />
				</form:label></td>
		<td><form:input class="form-control" path="flatNo" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="buildingName">
				<spring:message text="BUILDING NAME" />
				</form:label></td>
		<td><form:input class="form-control" path="buildingName" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="street">
				<spring:message text="STREET" />
				</form:label></td>
		<td><form:input class="form-control" path="street" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="city">
				<spring:message text="CITY" />
				</form:label></td>
		<td><form:input class="form-control" path="city" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="state">
				<spring:message text="STATE" />
				</form:label></td>
		<td><form:input class="form-control" path="state" /></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-2" path="country">
				<spring:message text="COUNTRY" />
				</form:label></td>
		<td><form:input class="form-control" path="country" /></td>
				</div>
				</tr>
				<tr>
				<td>
				<input class="btn btn-success" type="submit"
								value="<spring:message text="REGISTER"/>" />
								</td>
								</tr>
					</table>
					</form:form>
					</center>
					
</body>
</html>