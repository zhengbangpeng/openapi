<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>api</title>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/search.js"></script>
<script src="js/apiTest.js"></script>
<script src="js/public.js"></script>
<script src="js/logout.js"></script>
<body>
<div class="container" style="width:1280px" id="container">
		<div class="row">
				<h1 class="col-xs-2">Open API</h1>
				<div class="col-xs-7"
				style=" padding-top: 15px; padding-bottom: 15px;">
						<s:form action="api_search.action" id="searchform">
								<div class="input-group input-group-lg">
										<input type="text" name="item" class="form-control"
							placeholder="Search for...">
										<span
							class="input-group-btn">
										<button class="btn btn-default" type="button" id="search">Go!</button>
										</span> </div>
						</s:form>
				</div>
				<div class="col-xs-1"></div>
				<s:if test="#session.user==null">
				<div class="col-xs-2" style=" padding-top:40px;">
						<a href="user_loginUI.action" data-dialog="" title="登录">登录</a>&nbsp;&nbsp;
						<a href="user_registerUI.action" data-dialog="" title="注册会员">注册</a>
				</div>
				</s:if>
				<s:else>
					<div class="col-xs-2" style=" padding-top:40px;">
						你好，${user.nickname }&nbsp;&nbsp;
						<a href="user_logout.action" name="logout" id="logout">退出</a>
					</div>
				</s:else>
		</div>
		<div class="row" >
				<ul class="nav nav-pills nav-justified">
						<li role="presentation"><a href="index.jsp">首页</a></li>
						<li role="presentation"><a href="api_list.action">数据接口API</a></li>
						<li role="presentation"><a href="problem_list.action">常见问题</a></li>
						<li role="presentation"><a href="news_list.action">资讯&amp;动态</a></li>
				</ul>
		</div>
		<div class="row">
				<div class="col-xs-1"></div>
				<h3 class="col-xs-3" style="color:#0CF">API在线测试工具</h3>
		</div>
		<div class="row">
				<div class="progress">
						<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="60"
					aria-valuemin="0" aria-valuemax="100" style="width:100%;height:5px;color:#0FF"> <span class="sr-only">60% Complete</span> </div>
				</div>
		</div>
		<div class="row">
				<div class="col-xs-4">
						<form class="form-horizontal" id="apiTestForm"  method="post">
								<div class="form-group">
										<label for="typeId" class="col-sm-4 control-label">类型:</label>
										<div class="col-sm-8">
												<select name="typeId" class="form-control" id="typeId">
																
														<s:iterator value="#typeList">
																<option value="${id }">${name }</option>
														</s:iterator>
												</select>
										</div>
								</div>
								<div class="form-group">
										<label for="apiId" class="col-sm-4 control-label">API:</label>
										<div class="col-sm-8">
												<select name="apiId" id="apiId" class="form-control api" >
														<option>请选择</option>
												</select>
										</div>
								</div>
								<div class="form-group">
										<label for="queryId" class="col-sm-4 control-label">Query:</label>
										<div class="col-sm-8">
												<select name="queryId" id="queryId" class="form-control">
														<option>请选择</option>
												</select>
										</div>
								</div>
								<div class="form-group">
										<label for="requestType" class="col-sm-4 control-label">请求方式:</label>
										<div class="col-sm-8">
												<label class="radio-inline">
														<input type="radio" name="requestType"  value="GET">
														GET </label>
												<label class="radio-inline">
														<input type="radio" name="requestType"  value="POST">
														POST </label>
												
										</div>
								</div>
								<div class="form-group">
										<label for="returnType" class="col-sm-4 control-label">返回格式:</label>
										<div class="col-sm-8">
												<label class="radio-inline">
														<input type="radio" name="returnType"  value="xml">
														xml </label>
												<label class="radio-inline">
														<input type="radio" name="returnType"  value="json">
														json</label>
												
										</div>
								</div>
								
								<div class="form-group">
									<label  class="col-xs-4 control-label">API参数:</label>
								</div>
								<div class="form-group">
									<label  class="col-xs-2 control-label"></label>
									<div class="col-xs-10"> 
										<table class="table" id="parameters">
											<tr>
												<td>city:</td>
												<td><input type="text">&nbsp;*</td>
											</tr>
											<tr>
												<td>page:</td>
												<td><input type="text"></td>
											</tr>
											
										</table>
									</div>
								</div>
								<div class="form-group">
										<div class="col-xs-offset-4 col-xs-8">
												<button type="submit" class="btn btn-primary" id="apiTest">Request</button>
												<button type="reset" class="btn btn-primary">Reset</button>
										</div>
								</div>
						</form>
				</div>
				<div class="col-lg-8"> 
					<div class="row ">
						<h4 class="col-xs-offset-1">请求： </h4>
					</div>
					<div class="row">
						<textarea  rows="8" class="col-sm-10  col-xs-offset-1" disabled id="reqText"></textarea>
					</div>
					<div class="row">
						<h4 class="col-xs-offset-1">返回内容： </h4>
					</div>
					<div class="row">
						<textarea  rows="12" class="col-sm-10  col-xs-offset-1" disabled id="resText"></textarea>
					</div>
				</div>
		</div>
</div>
<!--页脚-->
<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>
</body>
</html>

