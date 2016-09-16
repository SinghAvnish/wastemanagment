<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier List</title>
</head>
<body>
<div class="container" style="background-color: lightgrey;">
	<h3>Supplier List</h3>
	<c:if test="${!empty supplierList}">
		<div class="table-responsive" style="border-left: 6px solid red;">
         
			<table class="table table-hover">
				<tr>
					<th width="80">Supplier ID</th>
					<th width="120">Supplier Name</th>
					<th width="120">Supplier Address</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				
					<tr ng-repeat="group in supplierdata | filter:searchKeyword">
						<td>{{group.id}}</td>
						<td>{{group.name}}</td>
						<td>{{group.address}}</td>
						<td><a href="<c:url value='supplier/edit/{{group.id}}' />">Edit</a></td>
						<td><a
							href="<c:url value='supplier/remove/{{group.id}}' />">Delete</a></td>
					</tr>
				
			</table>
		</div>
	</c:if>
</div>
</body>
</html>