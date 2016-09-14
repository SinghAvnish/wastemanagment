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
<title>PRODUCT LIST</title>
 
 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script src="<u:url value="resources/js/controller.js" />" ></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 
 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			//$scope.searchKeyword=location.search.substr(15);
			$scope.cartItemdata= ${cartItemlist};
			//alert($scope.productdata);
		 
		 });
	
</script>
  
</head>

  <body ng-app="myApp" ng-controller="getData">  
<!-- <div class="jumbotron"> -->
<div class="container" >
	<h2>
		<center>Add Product</center>
		
	</h2>

 <h3>Product List</h3>
 <br>
 
<div class="container" style="background-color: lightgreen;">
	<c:if test="${!empty cartItemlist}">
		<div class="table-responsive" style="border-left 2px solid red;">

			<table class="table table-hover">
				<tr>
				    <th width="80">CartItemId</th>
					<th width="80">CartID</th>
					<th width="80">ProductID</th>
					<th width="120">Product Name</th>
					<th width="120">Price/th>
					<th width="120">Quantity</th>
				</tr>
			
					 <tr  ng-repeat="group in cartItemdata ">
					    <td>{{group.cartitemid}}</td>
					    <td>{{group.cartid}}</td>
					    <td>{{group.prodid}}</td>
						<td>{{group.prodname}}</td>
						<td>{{group.price}}</td>
						<td>{{group.quantity}}</td>
			        </tr> 
			</table>
		</c:if>
	</div>
	</div>
 

</body>
</html>  
