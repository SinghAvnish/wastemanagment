<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUPPLIERS</title>



<script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			 //$scope.searchKeyword=location.search.substr(15); 
			$scope.supplierdata = ${supplierList};
			//alert($scope.productdata);
		 
		 });
	
</script>
 
 
 
</head>
<body ng-app="myApp" ng-controller="getData">

<!-- <div class="jumbotron"> -->
<div class="container" >
	<h2>
		<center>Add Supplier</center>
	</h2>
	<center>
		<c:url var="addAction" value="/supplier/add"></c:url>

		<form:form class="form-horizontal" role="form" action="${addAction}"
			commandName="supplier">
			<table>
				<tr>
					<div class="form-group">
						<td><form:label class="control-label col-sm-2" path="id">
								<spring:message text="ID" />
							</form:label></td>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${!empty supplier.id}">
									<td><form:input class="form-control" path="id"
											disabled="true" readonly="true" /></td>
								</c:when>

								<c:otherwise>
									<td><form:input class="form-control" path="id"
											pattern=".{4,7}" required="true"
											title="id should contains 4 to 7 characters" /></td>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<form:input path="id" hidden="true" />
						<td><form:label class="control-label col-sm-2" path="name">
								<spring:message text="Name" />
							</form:label></td>
						<td><form:input class="form-control" path="name"
								required="true" /></td>
					</div>
				</tr>
				<tr>
					<td><form:label class="control-label col-sm-2" path="address">
							<spring:message text="Address" />
						</form:label></td>
					<td><form:input class="form-control" path="address"
							required="true" /></td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${!empty supplier.name}">
							<input class="btn btn-primary" type="submit"
								value="<spring:message text="Edit Supplier"/>" />
						</c:if> <c:if test="${empty supplier.name}">
							<input class="btn btn-success" type="submit"
								value="<spring:message text="Add Supplier"/>" />
						</c:if></td>
				</tr>
			</table>
</div>
</form:form>
</center>
</div>
</body>
<footer>
 <%@ include file="/WEB-INF/views/footer.jsp"%>
 </footer>

</html>
