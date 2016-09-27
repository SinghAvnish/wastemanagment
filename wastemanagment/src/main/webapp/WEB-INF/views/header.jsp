<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  <style>
  .carousel-inner > .item > img, .carousel-inner > .item > a > img
   {
    width: 100%;
    height:50%;
	}

.navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      height:40%;
  }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 300px) {
    .carousel-caption {
      display: none;
    }
  }
  </style>
  <style>
  .carousel-control.right, .carousel-control.left 
  {
    background-image: none;
    color: #f4511e;
}

.carousel-indicators li {
    border-color: #f4511e;
}

.carousel-indicators li.active {
    background-color: #f4511e;
}

.item h4 {
    font-size: 19px;
    line-height: 1.375em;
    font-weight: 400;
    font-style: italic;
    margin: 70px 0;
}

.item span {
    font-style: normal;
}
 </style>
  <style>
  .carousel-control.right, .carousel-control.left 
  {
    background-image: none;
    color: #f4511e;
}

.carousel-indicators li {
    border-color: #f4511e;
}

.carousel-indicators li.active {
    background-color: #f4511e;
}

.item h4 {
    font-size: 19px;
    line-height: 1.375em;
    font-weight: 400;
    font-style: italic;
    margin: 70px 0;
}

.item span {
    font-style: normal;
}
 </style>
  
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand" href="/wastemanagment/">Ntique</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/wastemanagment/">Home</a></li>
       <li><a href="categories">Category</a></li>
      <li><a href="suppliers">Supplier</a></li>
      <li><a href="subcategories">SubCategory</a></li>
      <li><a href="products">Product</a></li>
      <li><a href="productlist">ProductList</a></li>
     <li><a href="subcategorylist">SubCategoryList</a></li>
     <li><a href="supplierlist">SupplierList</a></li>
      <li><a href="cartitemlist">CartItemList</a></li>
     
     </ul>
   </div>
    
</nav>
</sec:authorize>
   
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
      <a class="navbar-brand" href="#">Ntiques</a>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      <c:forEach items="${categoryList}" var="category">
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="false" aria-expanded="true">${category.name}</a> <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <c:forEach items="${category.subcategory}" var="subcategory">
            <li><a href="#">${subcategory.name}</a></li>          
            </c:forEach>
          </ul>
        </li>
        </c:forEach>
      </ul>
      </div>
      </ul>
      </div>
    <ul class="nav navbar-nav navbar-right">
       <sec:authorize access="isAnonymous()">
       <li><a href="login" style="margin:50;"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
      </sec:authorize>
      <c:if test="${pageContext.request.userPrincipal.name!= null}">
		<h2>
			Welcome ${pageContext.request.userPrincipal.name}
		</h2>
       </c:if>
        <sec:authorize access="isAuthenticated()">
        <li><a href="<c:url value="/logout" />">Logout</a></li>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
		<li><a href="users"><span class="glyphicon glyphicon-user"></span>Signup</a></li>
		
		</sec:authorize>
		<li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
		 </ul>
      </div>
 </nav> 

</body>
</html>