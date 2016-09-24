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
<title>SUBCATEGORY LIST</title>

 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 
 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			//$scope.searchKeyword=location.search.substr(15);
			$scope.subcategorydata= ${subcategoryList};
			//alert($scope.productdata);
		 
		 });
	
</script>
<style>
{
    background-color: #cc0000;
    color: white;
    
}
</style>  
</head>

  <body ng-app="myApp" ng-controller="getData">  

<div class="container" style="background-color:;">
	<h2><center>SubCategory List</center></h2>
	<c:if test="${!empty subcategoryList}">
		<div class="table-responsive" >

			<table class="table">
				<tr>
					<th width="80">Sub Category ID</th>
					<th width="80">Category ID</th>
					<th width="120">SubCategory Name</th>
					<th width="120">Sub Category Description</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
			
					<tr  ng-repeat="group in subcategorydata">
						<td>{{group.id}}</td>
						<td>{{group.cat_id}}</td>
						<td>{{group.name}}</td>
						<td>{{group.desc}}</td>
						<td><a href="<c:url value='subcategory/edit/{{group.id}}' />">Edit</a></td>
						<td><a href="<c:url value='subcategory/remove/{{group.id}}' />">Delete</a></td>
					</tr>
			
			</table>
		</div>
	</c:if>
</div>
 
</body>

</html>