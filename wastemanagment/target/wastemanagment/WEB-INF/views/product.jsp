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
<title>PRODUCTS</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-theme.min.css" />
<script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>

 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 

 <script type="text/javascript">
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			//$scope.searchKeyword=location.search.substr(15);
			$scope.productdata= ${productList};
			//alert($scope.productdata);
		 
		 });
	
</script>
 
</head>
<body>
 <!-- <body ng-app="myApp" ng-controller="getData"> --> 
<!-- <div class="jumbotron"> -->
<div class="container">
	<h2>
		<center>Add Product</center>
		
	</h2>
	<center>
	
	
		<c:url var="addAction" value="/product/add"></c:url>

		<form:form class="form-horizontal" role="form" action="${addAction}"
			commandName="product"  enctype="multipart/form-data" >
			
			
			
			
			<table>
			
			<tr>
					<td><form:label class="control-label col-sm-12" path="name">
							<spring:message text="SubCategory Name" />
						</form:label></td>
					<td><form:select path="subcategory.name" items="${SubCategoryList}"
						itemValue="name" itemLabel="name" /></td>
				</tr>
				<tr>
					<td><form:label class="control-label col-sm-12" path="name">
							<spring:message text="Supplier Name" />
						</form:label></td>
					<td><form:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" /></td>
				</tr>
				
			
				<tr>
				<div class="form-group">
				<td><form:label class="control-label col-sm-12" path="id">
				<spring:message text="Product Id" />
				</form:label></td>

				<div class="col-sm-12">
					<c:choose>
						<c:when test="${!empty product.id}">
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
						<td><form:label class="control-label col-sm-12" path="name">
								<spring:message text="Product Name" />
							</form:label></td>
						<td><form:input class="form-control" path="name"
								required="true" /></td>
					</div>
				</tr>
				<td><form:label class="control-label col-sm-12" path="image" >
							Select Image
						</form:label></td>
					<td><form:input  path="image" type="file"/></td>
				</tr>
				
				<tr>
					<td><form:label class="control-label col-sm-12" path="desc">
							<spring:message text="Product Description" />
						</form:label></td>
					<td><form:input class="form-control" path="desc"
							required="true" /></td>
				</tr>
				<tr>
					<td><form:label class="control-label col-sm-12" path="qty">
							<spring:message text="Quantity" />
						</form:label></td>
					<td><form:input class="form-control" path="qty"
							required="true" /></td>
				</tr>
				<tr>
					<td><form:label class="control-label col-sm-12" path="price">
							<spring:message text="price" />
						</form:label></td>
					<td><form:input class="form-control" path="price"
							required="true" /></td>
				</tr>
				
					
				
				<tr >
					<td colspan="2"><c:if test="${!empty product.name}">
							<input class="btn btn-primary" type="submit" value="<spring:message text="Edit Product"/>" />
						</c:if> <c:if test="${empty product.name}">
							<input class="btn btn-success" type="submit"
								value="<spring:message text="Add Product"/>" />
						</c:if></td>
				</tr>
			</table>
</div>
</form:form>
</center>
</div>
</body>


</html>
