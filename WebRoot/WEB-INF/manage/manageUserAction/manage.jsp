<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/search.js"></script>
<script src="js/logout.js"></script>
<body>
<div class="container" style="width:1280px">
		<div class="row">
				<h1 class="col-xs-4">Open API Manage</h1>
				<div class="col-xs-6"></div>
				<div class="col-xs-2" style=" padding-top:40px;">
						你好，${user.nickname }&nbsp;&nbsp;
						<a href="manageUser_logout.action" name="manageLogout" id="manageLogout">退出</a>
				</div>
		</div>
		<div class="row">
				<div class="progress">
						<div class="progress-bar" role="progressbar" aria-valuenow="60"
					aria-valuemin="0" aria-valuemax="100" style="width: 100%;"> <span class="sr-only">60% Complete</span> </div>
				</div>
		</div>
		<div class="row">
				<div class="col-xs-2">
						<h2 style="text-align:center">功能列表</h2>
				</div>
		</div>
		<div class="row">
				<div class="col-xs-2" >
						<div class="list-group" >
							<a href="manageType_list.action" class="list-group-item">类型管理</a>
  <a href="manageApi_list.action" class="list-group-item">API管理</a>
  <a href="manageApi_uploadUI.action" class="list-group-item">API上传</a>
  <a href="manageNews_list.action" class="list-group-item">news管理</a>
						</div>
				</div>
				<div class="col-xs-1"> </div>
				<div  class="col-xs-6">
						<h1>这里是Open API后台管理</h1>
				</div>
		</div>
</div>
</body>
</html>
