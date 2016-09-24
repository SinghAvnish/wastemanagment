 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
<title>PRODUCT VIEW</title>

 
 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 
 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			
			$scope.productdata= ${productdetails};
			
		 
		 });
	
</script>
  
</head>

  <body ng-app="myApp" ng-controller="getData">  
<div class="container">
		<h1 class="title">Product Details</h1>
		<hr>
<c:url var="addAction" value="/user/add"></c:url>
		<div class="row">
		<div class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
     		 <img style="width:30%; height:30%;" src="{{productdata.image}}" />
     		 </div>
   		<div class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
   		<h3 ><span class="h3 text-uppercase">Name: {{productdata.name}}</span></h3>
             	<p><span>Quantity: {{productdata.qty}}</span></p>
				<p><span>Price: {{productdata.price}} Rs</span>	</p>
				<a href="CartItemadd?id={{productdata.id}}"><input type="button" value ="Add To Cart"> </a>
		</div>
		</div>
 

</body>

</html>  
