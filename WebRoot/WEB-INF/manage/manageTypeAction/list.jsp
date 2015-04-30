<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>首页</title>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/manageType.js"></script>
<script src="js/logout.js"></script>
<body>
	<div class="container" style="min-width:1280px">
		<div class="row">
			<h1 class="col-lg-4 col-md-4 col-sm-4">Open API Manage</h1>
			<div class="col-xs-6"></div>
				<div class="col-xs-2" style=" padding-top:40px;">
						你好，${user.nickname }&nbsp;&nbsp;
						<a href="manageUser_logout.action" name="manageLogout" id="manageLogout">退出</a>
				</div>
		</div>
		<div class="row">
			<div class="progress">
				<div class="progress-bar" role="progressbar" aria-valuenow="60"
					aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
					<span class="sr-only">60% Complete</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-2 col-md-2 col-sm-2">
				<h2 style="text-align:center">功能列表</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-2 col-md-2 col-sm-2">
				<div class="list-group">
					<a href="manageType_list.action" class="list-group-item active">类型管理</a>
					<a href="manageApi_list.action" class="list-group-item">API管理</a>
					<a href="manageApi_uploadUI.action" class="list-group-item">API上传</a>
					<a href="manageNews_list.action" class="list-group-item">news管理</a>
				</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1"></div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="row">
					<div class="col-lg-1 col-md-1 col-sm-1">
						<button type="button" class="btn btn-primary" id="addUI">Add</button>
					</div>
					<div class="col-lg-8 col-md-8 col-sm-8">
						<%-- <div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..." name="item"> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button">Go!</button>
							</span>
						</div> --%>
						<s:form action="manageType_search" id="searchform">
							<div class="input-group ">
								<input type="text" name="item" class="form-control"
									placeholder="Search for..." value="${item }"> <span
									class="input-group-btn" >
									<button class="btn btn-default" type="button" id="search">Go!</button>
								</span>
							</div>
						</s:form> 

					</div>
				</div>
				<div class="row">
					<hr style="border:1px dashed #ccc;width:700px;height:1px" />
				</div>
				<div class="row" style="">
					<div class="col-lg-1 col-md-1 col-sm-1"></div>
					<table class="table table-bordered col-lg-8 col-md-8 col-sm-8"
						align="center">
						<tr>
							<th>名称</th>
							<th>Api数量</th>
							<th>描述</th>
							<th>操作</th>
						</tr>
						<s:iterator value="#typeList">
							<tr>
								<td>${name }</td>
								<td>${num }</td>
								<td>${des }</td>
								<td>
									<div class="btn-group" role="group" aria-label="...">
										<a class="btn btn-primary"
											href="manageType_updateUI.action?id=${id }" role="button" a>Update</a>
										<a class="btn btn-primary deleteType" role="button"
											value="${id }">Delete</a>
									</div>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

