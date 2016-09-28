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
<title>CARTITEMLIST</title>
 
 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script src="<u:url value="resources/js/controller.js" />" ></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 
 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			//$scope.searchKeyword=location.search.substr(15);
			$scope.cartItemdata= ${cartItemList};
			//alert($scope.productdata);
		 
		 });
	
</script>
  
</head>

  <body ng-app="myApp" ng-controller="getData">  
<!-- <div class="jumbotron"> -->
<div class="container" >


 <h3><canter>Cart Item List</canter></h3>
 <br>
 
<div class="container" style="background-color:;">
	
	<form:form class="form-horizontal" role="form" action="${addAction}"  commandName="cartitem">
			
	<c:if test="${!empty cartItemList}">
		<div class="table-responsive">

			<table class="table">
				<tr>
				    <th width="80">CartItemId</th>
					<th width="80">CartID</th>
					<th width="80">ProductID</th>
					<th width="120">Product Name</th>
					<th width="120">Price</th>
					<th width="120">Quantity</th>
				</tr>
			
					 <tr ng-repeat="group in cartItemdata ">
					    <td>{{group.cartitemid}}</td>
					    <td>{{group.cartid}}</td>
					    <td>{{group.prodid}}</td>
						<td>{{group.prodname}}</td>
						<td>{{group.price}}</td>
						<td>{{group.quantity}}</td>
			        </tr>
			        <td><a href="cart"><input type="button" value ="Checkout"> </a></td>
			        
			</table>
		</c:if>
	</form:form>
	</div>
	</div>
 
</body>

</html>  
