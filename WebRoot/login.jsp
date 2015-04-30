<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<head>
	<title>Login One</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">	
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.min.js"></script>
	<script src="js/manageUser.js"></script>
	
	
</head>
<body class="templatemo-bg-gray">
</div>
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">Open API Manage</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" id="loginForm" method="post" action="manageUser_login.action">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label class="control-label fa-label"><span   style="font-size:24px; "class="glyphicon glyphicon-user " ></span></label>
		            	<input type="text" class="form-control" id="username" name="username" placeholder="Username">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><span   style="font-size:24px; "class="glyphicon glyphicon-lock " ></span></label>
		            	<input type="password" class="form-control" id="password" name="password" placeholder="Password">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label>
	                  		<input type="checkbox"> Remember me
                		</label>
	              	</div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="Log in" class="btn btn-info">
		          		<a href="#" class="text-right pull-right">Forgot password?</a>
		          	</div>
		          </div>
		        </div>
		        <hr>
		       
		      </form>
		     
		</div>
	</div>
</body>
</html>

