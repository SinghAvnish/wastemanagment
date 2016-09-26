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
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-rc.0/angular.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-rc.0/angular-animate.min.js"></script>
		<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
 
		<!-- angular-payments library - you probably want to install it through either bower or npm -->
		<script src="http://cdn.rawgit.com/laurihy/angular-payments/2472bc9befa256780d106a8e53a9dea12b7341ed/lib/angular-payments.js"></script>
 
		<!-- other angular.js modules -->
		<script src="http://pineconellc.github.io/angular-foundation/mm-foundation-tpls-0.3.1.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/spin.js/2.0.1/spin.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/angular-spinner/0.5.1/angular-spinner.js"></script>
 
		<!-- our code -->
		<script src="scripts.js"></script>
 
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
  
</head>
<body>
<sec:authorize access="hasRole('ROLE_USER')">
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
      <a class="navbar-brand" href="/wastemanagment/">Ntiques</a>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
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
      </ul>
      </div>
     
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
 <div class="col-sm-6">
    <ul class="product-list small-block-grid-3">
			<li ng-repeat="product in products">
				<figure>
					<img ng-src="{{product.image}}" alt="{{product.title}}">
					<figcaption>
						<h3>{{product.name}}, {{product.price}}$</h3>
						<button ng-click="addToCart(product);">Add to cart</button>
					</figcaption>
				</figure>
			</li>
		</ul>
      
  </div>
  <div class="col-sm-6">
   <div class="thumbnail" align="justify">
      <img src="resources/images/table5.jpg" alt="table5">
       
      </div>
   </div>
   
    <div class="row">
 <div class="col-sm-4">
    <a href="#" class="thumbnail">
      <img src="resources/images/table4.jpg" alt="table4">
    </a>
  </div>
  
   <div class="col-sm-4">
    <a href="#" class="thumbnail">
      <img src="resources/images/table4.jpg" alt="table4">
    </a>
  </div>
  
   <div class="col-sm-4">
    <a href="#" class="thumbnail">
      <img src="resources/images/table4.jpg" alt="table4">
    </a>
  </div>
  </div>
  <div><h3><center>-----What Our Customers Say ---</center></h3></div>
  <div>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

   
    <div class="carousel-inner" role="listbox">
      <div class="item active">
      <h4><center>"This company is the best. I am so happy with the result!"<br><span style="font-style:normal;">Michael Roe, Vice President, Comment Box</span></center></h4>
        </div>

      <div class="item">
       <h4><center>"One word... WOW!!"<br><span style="font-style:normal;">John Doe, Salesman, Rep Inc</span></center></h4>
       
       </div>
       
       <div class="item">
       <h4><center>"Could I... BE any more happy with this company?"<br><span style="font-style:normal;">Chandler Bing, Actor, FriendsAlot</span></center></h4>
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
 </div>
 </div>
  <footer>
    <%@ include file="/WEB-INF/views/footer.jsp"%>           
</footer>

  
</body>
</html>