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
    width: 80%;
    height:60%;
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
      width: 70%; /* Set width to 100% */
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
      <a class="navbar-brand" href="#">Ntique</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/wastemanagment/">Home</a></li>
      <sec:authorize access="hasRole('ROLE_USER')">
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
    </div>
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
      <ul class="nav navbar navbar-right" >
      <sec:authorize access="isAnonymous()">
       <li><a href="login" style="margin:50;"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
      </sec:authorize>
      <c:if test="${pageContext.request.userPrincipal.name!= null}">
		<h2>
			Welcome  ${pageContext.request.userPrincipal.name}
		</h2>
       </c:if>
        <sec:authorize access="isAuthenticated()">
        <li><a href="<c:url value="/logout" />">Logout</a></li>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
		<li><a href="users"><span class="glyphicon glyphicon-user"></span>Signup</a></li>
		<li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
		</sec:authorize>
      </ul>
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
        <img src="resources/images/Jellyfish.jpg" alt="Image">
        <div class="carousel-caption">
          <h3>Sell $</h3>
          <p>Money Money.</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/images/bed1.jpg" alt="Image">
        <div class="carousel-caption">
          <h3></h3>
          <p>Lorem ipsum...</p>
        </div>
      </div>
       <div class="item">
        <img src="resources/images/4.jpg" alt="Image">
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
 
 
 <footer class="container-fluid text-center">
  	<div class ="row">
        <div class="col-sm-3" align="justify"  style="background-color:light-grey;">
      
      <h3>Our Company</h3>
        <ul>
          <li><a href="about-us">About Us</a></li>
          <li><a href="careers">Careers</a></li>
          <li><a href="blog">Blog</a></li>
          <li><a href="media">Media</a></li>
          <li><a href="custom-furniture">Custom Furniture</a></li>
          <li><a href="coupon-partners">Coupon Partners</a></li>
          <li><a href="customer-reviews">Customer Reviews</a></li>
          <li><a href="get-in-touch">Get in Touch</a></li>
        </ul>
    </div>
     
       <div class="col-sm-3"  align="justify" style="background-color:light-grey;">
        <h4>Customer Services</h4>
          <ul>Our Stores</ul>
          <ol><a href="deliveries">Deliveries</a></ol>
          <ol><a href="return-and-refunds">Return &amp; Refunds</a></ol>
          <ol><a href="terms-and-conditions">Terms &amp; Conditions </a></ol>
          <ol><a href="security-and-privacy">Security &amp; Privacy</a></ol>
          <ol><a href="track-orders">Track Order</a></ol>
          <ol><a href="buying-guide">Buying Guide</a></ol>
          <ol><a href="compare-woods">Type Of Wood</a></ol>
        </ul>
      </div> 
      <div class="col-sm-3"   align="justify" style="background-color:light-grey;">
      
        <div>Categories</div>
        <ul>
          <li><a href="bookshelves">Bookshelf</a></li>
          <li><a href="shoe-racks">Shoe Rack</a></li>
          <li><a href="study-tables">Study Table</a></li>
          <li><a href="coffee-tables">Coffee Table</a></li>
          <li><a href="dining-table-sets">Dining Table Sets</a></li>
          <li><a href="corner-sofas">Corner Sofa</a></li>
          <li><a href="dressing-tables">Dressing Table</a></li>
          <li><a href="dining-tables">Dining Tables</a></li>
        </ul>
     
          </div>    
          <div class="col-sm-3"   align="justify"style="background-color:light-grey;">
        
        <div >Top Categories</div>
        <ul>
          <li><a href="interior-designers">Interior Designers</a></li>
          <li><a href="living-room-furniture">Living Room Furniture</a></li>
          <li><a href="dining-furniture">Dining Furniture</a></li>
          <li><a href="bedroom-furniture">Bedroom Furniture</a></li>
          <li><a href="storage-furniture">Storage Furniture</a></li>
          <li><a href="outdoor-furniture">Outdoor Furniture</a></li>
          <li><a href="kids-furniture">Kids Furniture</a></li>
          <!--<li><a href="home-decors">Home Decor</a></li>-->
        </ul>
      </div>
      
        <article class="social">
        <div class="footer_two_title">Follow <span>Ntiques</span></div>
        <table>
        <div    align="justify"style="background-color:light-grey;">
          <ul>
          <th> <a target="_blank" rel="nofollow" href="https://www.facebook.com/Woodenstreet" title="Facebook" class="facebook"><img src="images/LOGO.jpg" alt="Facebook" /></a></li></ul></th>
           <th><a  rel="nofollow" href="https://twitter.com/Woodenstreet1" target="_blank" title="Twitter" class="twitter"><img src="images/twitter.svg" alt="Twitter" /></a></li><
            <th><a href="https://plus.google.com/+WoodenstreetOfficial/" title="Google+" target="_blank" class="google-plus"><img src="images/google.svg" alt="Google Plus" /></a><td>
        </ul>
        
        </div>
        </table>
      </article>
      <div>
       <article class="top-categroy clearfix"> 
        <!--Start Top Searches-->
                <p>Top Furniture Searches:</p> 
                <a href="bar-furniture">Bar Furniture</a>
                <a href="bar-stools">Bar Stools</a>
                <a href="beds">Beds</a>
                <a href="bookshelves">Book shelf</a>
                <a href="chairs">Chairs</a>
                <a href="computer-tables">Computer Table</a>
                <a href="dining-tables">Dining Table</a>
                <a href="dining-table-sets">Dining Table Set</a>
                <a href="double-beds">Double Bed</a>
                <a href="extendable-dining-table-sets">Extendable dining table</a>
                <a href="fabric-sofas">Fabric Sofas</a>
                <a href="kitchen-cabinets">Kitchen Cabinets</a>
                <a href="kitchen-trolley">Kitchen Trolley</a>
                <a href="corner-sofas">L Shaped Corner Sofa</a>
                <a href="single-beds">Single Bed</a>
                <a href="sofa-cum-beds">Sofa Cum Bed</a>
                <a href="sofa-sets">Sofa Set</a>
                <a href="study-tables">Study Table</a>
                <a href="tables">Table</a>
                <a href="tv-units">TV Units</a>
                <a href="wine-racks">Wine Rack</a>
                <a href="wooden-sofa">Wooden Sofa</a>
                <!--End Top Searches--> 
      </article>
      </div>             
      
        
              
  
</footer>

  
</body>
</html>