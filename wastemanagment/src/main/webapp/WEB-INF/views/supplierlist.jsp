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
<title>Supplier List</title>

 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script type="text/javascript" src="resources/js/angular.min.js"></script>
 <script src="<u:url value="resources/js/controller.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 
 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			//$scope.searchKeyword=location.search.substr(15);
			$scope.supplierdata= ${supplierlist};
			//alert($scope.productdata);
		 
		 });
	
</script>

</head>
<body ng-app="myApp" ng-controller="getData">
<div class="container" style="background-color:;">
	<h3>Supplier List</h3>
	<c:if test="${!empty supplierlist}">
		<div class="table-responsive">
         
			<table class="table">
				<tr>
					<th width="80">Supplier ID</th>
					<th width="120">Supplier Name</th>
					<th width="120">Supplier Address</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				
					<tr ng-repeat="group in supplierdata">
						<td>{{group.id}}</td>
						<td>{{group.name}}</td>
						<td>{{group.address}}</td>
						<td><a href="<c:url value='supplier/edit/{{group.id}}' />">Edit</a></td>
						<td><a href="<c:url value='supplier/remove/{{group.id}}' />">Delete</a></td>
					</tr>
				
			</table>
		</div>
	</c:if>
</div>
</body>
<footer>
 <%@ include file="/WEB-INF/views/footer.jsp"%>
 </footer>

</html>