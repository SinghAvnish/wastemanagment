 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>PRODUCT LIST</title>

 
 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 
 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			
			$scope.productdata= ${Product};
			
		 
		 });
	
</script>
  
</head>

  <body ng-app="myApp" ng-controller="getData">  
<div class="container">
		<h1 class="title">Product Details</h1>
		<hr>

		<div class="row">
			
			<div class="col-lg-6">
				<img style="width:40px; height:40px;" src="{{productdata.image}}" />
			</div>
			 <div class="col-lg-2"> 
			
  				<h3><span class="h3 text-uppercase">name: {{productdata.name}}</span></h3>
             	<p><span class="h4 text-info">Quantity: {{productdata.qty}}</span></p>
				<p><span class="h4 text-danger">Price: Rs {{productdata.price}}</span>	</p>
				
</div>
</div>
</div>
 

</body>
</html>  
