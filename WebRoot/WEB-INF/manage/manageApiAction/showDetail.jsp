<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>ManageApi</title>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/page.js"></script>
<script src="js/switch.js"></script>
<script src="js/public.js"></script>
<script src="js/manageServiceError.js"></script>
<script src="js/manageParameter.js"></script>
<script src="js/manageReturnParameter.js"></script>
<script src="js/manageQuery.js"></script>
<script src="js/manageSystemError.js"></script>
<script src="js/logout.js"></script>
<body>
	<div class="container" >
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
		<div id="content" class="container-fluid">

		</div>
		<div class="row">
			<div class="col-lg-3">
				<div
					style="background:url(${pageContext.request.contextPath}${api.pictureUrl }) no-repeat scroll center center transparent;height:200px "
					;height:200px></div>
			</div>
			<div class="col-lg-4">
				<h1>${api.name }</h1>
				<br>
				<table class="table ">
					<tr>
						<td>接口状态：</td>
						<td>正常</td>
					</tr>
					<tr>
						<td>数据类型：</td>
						<td>${api.type.name }</td>
					</tr>
					<tr>
						<td>描述：</td>
						<td>${api.des }</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="docs_api_tab col-lg-7">
				<ul class="nav nav-tabs switch">
					<li role="presentation" class="active" id="firstli"><a
						href="#" id="first" class="conGroup ">API</a></li>
					<li role="presentation" id="secondli"><a href="#" id="second"
						class="conGroup ">错误码参</a></li>
					<li role="presentation" id="thirdli"><a href="#" id="third"
						class="conGroup ">其他相关</a></li>
				</ul>
				<div class="clear"></div>
			</div>
		</div>
		<br>
		<div class="row disGroup first">
			<div class="col-lg-1"></div>
			<div class="col-lg-3">
				<ul class="list-group">
					<s:iterator value="#queryList">
						<li class="list-group-item"><s:a
								action="manageApi_showByQueryId?queryId=%{id}">${name }</s:a><br><a class="btn btn-primary"
										href="manageQuery_updateUI.action?id=${id }" role="button" data-dialog="" title="修改查询方式">Update</a>
									<a class="btn btn-primary deleteQuery" role="button" 
										value="${id }">Delete</a></li>
					</s:iterator>
						<li class="list-group-item"><a class="btn btn-primary"
										href="manageQuery_addUI.action?apiId=${api.id }" role="button" data-dialog="" title="添加查询方式">Add</a></li>
				</ul>
			</div>
			<div class="col-lg-8">
				<div>
					<table class="table">
						<caption>${query.name }</caption>
						<thead>
						<tr>
							<th style="width:15%"></th>
							<th></th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>接口地址：</td>
							<td>${query.url }</td>
						</tr>
						<tr>
							<td>支持格式：</td>
							<td>${query.supportType }</td>
						</tr>
						<tr>
							<td>请求方式：</td>
							<td>${query.requestType }</td>
						</tr>
						<tr>
							<td>请求示例：</td>
							<td>${query.queryExample }</td>
						</tr>
						<tr>
							<td>关键字：</td>
							<td>${query.keywords}&nbsp;&nbsp;<a class="btn btn-primary"
										href="manageQuery_updateKeywordsUI.action?id=${query.id}" role="button" data-dialog="" title="修改关键字" style="padding: 0px 6px;">Update</a></td>
						</tr>
						<tr>
							<td>请求参数：</td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<table class="table">
									<tr>
										<th>名称</th>
										<th>类型</th>
										<th>必填</th>
										<th>说明</th>
										<th>操作</th>
									</tr>
									<s:iterator value="#parameterList">
										<tr>
											<td>${name }</td>
											<td>${type }</td>
											<td>${required }</td>
											<td>${des }</td>
											<td><a class="btn btn-primary"
										href="manageParameter_updateUI.action?id=${id}" role="button" data-dialog="" title="修改请求参数">Update</a>
									<a class="btn btn-primary deleteParameter" role="button" 
										value="${id }">Delete</a></td>
										</tr>
									</s:iterator>
									<s:if test="query!=null">
									<tr>
										<td><a class="btn btn-primary"
										href="manageParameter_addUI.action?queryId=${query.id}" role="button" data-dialog="" title="添加请求参数">Add</a></td>
									</tr>
									</s:if>
								</table>
							</td>
						</tr>
						<tr>
							<td>返回字段：</td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<table class="table">
									<tr>
										<th>名称</th>
										<th>类型</th>
										<th>说明</th>
										<th>操作</th>
									</tr>
									<s:iterator value="#returnParamterList">
										<tr>
											<td>${name }</td>
											<td>${type }</td>
											<td>${des }</td>
											<td><a class="btn btn-primary"
										href="manageReturnParameter_updateUI.action?id=${id }" role="button" data-dialog="" title="修改返回字段">Update</a>
									<a class="btn btn-primary deleteReturnParameter" role="button" 
										value="${id }">Delete</a></td>
										</tr>
									</s:iterator>
									<s:if test="query!=null">
									<tr>
										<td><a class="btn btn-primary"
										href="manageReturnParameter_addUI.action?queryId=${query.id }" role="button" data-dialog="" title="添加返回字段">Add</a></td>
									</tr>
									</s:if>
										
								</table>
							</td>
						</tr>
						<tr>
							<td>JSON示例：</td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td >
								<textarea rows="5" cols="100">${query.jsonExample }</textarea>
							</td>
						</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<div class="row disGroup second" style="display:none">
			<div class="col-lg-2"></div>
			<div class="col-lg-6">
				<table class="table">
					<thead>服务级错误码参照:
					</thead>

					<tr>
						<th>错误码</th>
						<th>说明</th>
						<th>操作</th>
					</tr>
					<s:iterator value="#serviceErrorList">
						<tr>
							<td>${name }</td>
							<td>${des }</td>
							<td>
								<div class="btn-group" role="group" aria-label="...">
									<a class="btn btn-primary"
										href="manageServiceError_updateUI.action?id=${id }" role="button" data-dialog="" title="修改服务级错误码">Update</a>
									<a class="btn btn-primary deleteSerivceError" role="button" 
										value="${id }">Delete</a>
								</div>
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td><a class="btn btn-primary"
										href="manageServiceError_addUI.action?apiId=${api.id }" role="button" data-dialog="" title="添加错误码">Add</a></td>
					</tr>
					
				</table>
				<table class="table">
					<thead>系统级错误码参照:
					</thead>

					<tr>
						<th>错误码</th>
						<th>说明</th>
						<th>操作</th>
					</tr>
					<s:iterator value="#systemErrorList">
						<tr>
							<td>${name }</td>
							<td>${des }</td>
							<td>
								<div class="btn-group" role="group" aria-label="...">
									<a class="btn btn-primary"
										href="manageSystemError_updateUI.action?id=${id }" role="button" data-dialog="" title="修改系统级错误码">Update</a>
									<a class="btn btn-primary deleteSystemError" role="button" 
										value="${id }">Delete</a>
								</div>
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td><a class="btn btn-primary"
										href="manageSystemError_addUI.action" role="button" data-dialog="" title="添加错误码">Add</a></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="row third disGroup" style="display:none">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">
				<h1>这里是其他相关选项</h1>
			</div>

		</div>


	</div>
</body>
</html>


