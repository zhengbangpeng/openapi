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
<script src="js/switch.js"></script>
<script src="js/search.js"></script>
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
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button" id="search">Go!</button>
						</span>
					</div>
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
		<div class="row">
			<ul class="nav nav-pills nav-justified">
				<li role="presentation"><a href="index.jsp">首页</a></li>
				<li role="presentation" class="active"><a href="api_list.action">数据接口API</a></li>
				<li role="presentation"><a href="problem_list.action">常见问题</a></li>
				<li role="presentation"><a href="news_list.action">资讯&amp;动态</a></li>
			</ul>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<div
					style="background:url(${pageContext.request.contextPath}${api.pictureUrl }) no-repeat scroll center center transparent;height:200px "
					;height:200px></div>
			</div>
			<div class="col-xs-4">
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
			<div class="col-xs-1"></div>
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
			<div class="col-xs-1"></div>
			<div class="col-xs-3">
				<ul class="list-group">
					<s:iterator value="#queryList">
						<li class="list-group-item"><s:a
								action="query_listById?queryId=%{id}">${name }</s:a></li>
					</s:iterator>

				</ul>
			</div>
			<div class="col-xs-8">
				<div>
					<table class="table">
						<thead>${query.name }</thead>
						<tr>
							<th width="12%"></th>
							<th width="88%"></th>
						</tr>
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
									</tr>
									<s:iterator value="#parameterList">
										<tr>
											<td>${name }</td>
											<td>${type }</td>
											<td>${required }</td>
											<td>${des }</td>
										</tr>
									</s:iterator>

								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">调用样例及调试工具：</td>
						</tr>
						<tr>
							<td><a href="apiTest_list.action">API在线测试</a></td>
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
									</tr>
									<s:iterator value="#returnParamterList">
										<tr>
											<td>${name }</td>
											<td>${type }</td>
											<td>${des }</td>
										</tr>
									</s:iterator>

								</table>
							</td>
						</tr>
						<tr>
							<td>JSON示例：</td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td>${query.jsonExample }</td>
						</tr>
					</table>
				</div>

			</div>
		</div>
		<div class="row disGroup second" style="display:none">
			<div class="col-lg-1"></div>
			<div class="col-lg-4">
				<table class="table">
					<thead>服务级错误码参照:
					</thead>

					<tr>
						<th>错误码</th>
						<th>说明</th>
					</tr>
					<s:iterator value="#serviceErrorList">
						<tr>
							<td>${name }</td>
							<td>${des }</td>
						</tr>
					</s:iterator>
				</table>
				<table class="table">
					<thead>系统级错误码参照:
					</thead>

					<tr>
						<th>错误码</th>
						<th>说明</th>
					</tr>
					<s:iterator value="#systemErrorList">
						<tr>
							<td>${name }</td>
							<td>${des }</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<div class="row third disGroup" style="display:none">
			<div class="col-xs-1"></div>
			<div class="col-xs-5">
				<h1>这里是其他相关选项</h1>
			</div>

		</div>
	</div>
	<!--页脚-->
	<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>
</body>
</html>
