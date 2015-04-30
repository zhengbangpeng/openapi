<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>API AddUI</title>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/search.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/manageApi.js"></script>
<script src="js/jquery-form.js"></script>
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
			<div class="col-lg-1 col-md-1 col-sm-1"></div>
			<div class="col-lg-2 col-md-2 col-sm-2">
				<h2 style="text-align:center">API修改</h2>

			</div>
		</div>
		<div class="row">
			<div class="col-lg-2 col-md-2 col-sm-2">
				<div class="list-group">
					<a href="manageType_list.action" class="list-group-item">类型管理</a> <a
						href="manageApi_list.action" class="list-group-item active">API管理</a>
						<a href="manageApi_uploadUI.action" class="list-group-item">API上传</a>
						<a href="manageNews_list.action" class="list-group-item">news管理</a>
				</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1"></div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="row">
					<hr style="border:1px dashed #ccc;width:700px;height:1px" />
				</div>
				<div class="row">
					<form class="form-horizontal" id="updateApiForm" enctype="multipart/form-data" method="post">
						<input type="hidden" name="id" value="${api.id}">
						<div class="form-group">
							<label for="file" class="col-sm-2 control-label" >图片</label>
							<div class="col-sm-2">
								<img  id="img" src="${pageContext.request.contextPath}${api.pictureUrl }">
								
							</div>
							<div class="col-sm-3">
								<input type="file"  name="image" style="padding-top: 60px;" id="file">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Api名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name" id="name" value="${api.name }"
									placeholder="请输入Api名称" required>
							</div>
						</div>
						<div class="form-group">
							<label for="des" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<textarea class="form-control" rows="3" name="des" id="des" >${api.des}</textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="typeId" class="col-sm-2 control-label">所属类型</label>
							<div class="col-sm-10">
								<select name="typeId" class="form-control">
									<s:iterator value="#typeList">
										<s:if test="%{id }==%{api.type.id }">
											<option value="${id }" selected="selected" >${name }</option>
										</s:if>
										<s:else>
											<option value="${id }">${name }</option>
										</s:else>
										
									</s:iterator>
									</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-primary" id="updateApi">Update</button>
								<button type="reset" class="btn btn-primary">Reset</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
