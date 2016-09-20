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
  .carousel-inner > .item > img, .carousel-inner > .item > a > img {
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
  
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
          <sec:authorize access="hasRole('ROLE_USER')">
    
      <a class="navbar-brand" href="/wastemanagment/">Ntique</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/wastemanagment/">Home</a></li>
       <li><a href="categories">Category</a></li>
      <li><a href="suppliers">Supplier</a></li>
      <li><a href="subcategories">SubCategory</a></li>
      <li><a href="products">Product</a></li>
      </sec:authorize>
    </ul>
    
  </div>
</nav>
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
		<li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
		</sec:authorize> </ul>
      </div>
 </nav> 
     
 
<br>
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

   
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/c.jpg" alt="Image">
        <div class="carousel-caption">
         
        </div>
      </div>

      <div class="item">
        <img src="resources/images/bed1.jpg" alt="Image">
        <div class="carousel-caption">
          <h3></h3>
        
        </div>
      </div>
       <div class="item">
        <img src="resources/images/table4.jpg" alt="Image">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>
      </div>
      
    </div>

  <!--   Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
 </div>
 <div><h3 align="center">-------- Best Sellers --------</h3></div>
 <div class="row">
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="resources/images/table4.jpg" alt="table4">
    </a>
  </div>
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="resources/images/table5.jpg" alt="table5">
    </a>
  </div>
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="resources/images/table6.jpg" alt="table6">
    </a>
  </div>
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="resources/images/table7.jpg" alt="table7">
    </a>
  </div>
  
</div>
 
 
 <footer>
  <div id="copyrights">
        <h5><center>Copyright © 2012 Bombay Furniture Company. All Rights Reserved.&nbsp;&nbsp;Website by <a style="color:#000;" href="http://designconcentrate.in/" target="_blank">Design Concentrate</a></center></h5>
    </div>
    
       
          
        
        
            
</footer>

  
</body>
</html>