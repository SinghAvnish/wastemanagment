<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ include file="/WEB-INF/views/header.jsp"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
 
</head>
<body>


<div class="container"  style="margin-top:30px" >
    <div class="row-md-4 row-md-vertical-offset-40">
        <div class="col-md-4 col-md-offset-4" align="center">
    		       <!-- <div class="panel panel-info"> -->
			  	 <div class="panel-heading"> 
			    	<h4 class="panel-title"><strong>Sign in</strong></h4>
			 	</div>
			  	      <div class="panel-body"> 
			    	<form accept-charset="UTF-8" role="form" action="perform_login" method="POST" >
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Username" name="username" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Password" name="password" type="password" value="">
			    		</div>
			    			<input class="btn btn-lg btn-success btn-block" type="submit" value="Login"><br>
			    			<a href="users"> Create Your Account Here</a>
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</div>



</body>
</html>
