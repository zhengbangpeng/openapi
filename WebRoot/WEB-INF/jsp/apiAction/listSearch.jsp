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
<script src="js/page.js"></script>
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
							placeholder="Search for..." value="${item }"> <span
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
				<dl>
					<dt>功能分类</dt>
					<dd class="active">
						<s:a action="api_list">所有数据<span>(${totalNum})</span>
						</s:a>
					</dd>
					<s:iterator value="#typeList">
						<dd>
							<s:a action="api_listByType?typeId=%{id}">${name }<span>(${ num})</span>
							</s:a>
						</dd>
					</s:iterator>

				</dl>
				<dl>
			</div>
			<div id="juheapi_main" class="col-xs-7">
				<div id="juheapi_main_title">
					<div class="juheapi_main_title">
						<h1>
							相关Api为:<span></span>
						</h1>
					</div>
				</div>
				<!--api start-->
				<ul id="juheapis_ul">
					<!--聚合SDK-->
					<!--End 聚合SDK-->
					<s:iterator value="recordList">
						<div class="juheapis_desc clear">
							<a class="juheapi_imga"
								href="${pageContext.request.contextPath}${pictureUrl }"><img
								src="${pageContext.request.contextPath}${pictureUrl }"
								width="80" height="80" /></a>
							<div class="juheapis_desc_fl">
								<h1>
									<s:a action="query_list?apiId=%{id}">${name }</s:a>
								</h1>
								<p class="juhe_desc_p1">${des }</p>
								<hr style="border:1px dashed #ccc;width:700px;height:1px" />
							</div>
						</div>
					</s:iterator>

				</ul>
				<!--api end-->
				<!--paging start-->

				<!--分页信息-->
				<%@ include file="/WEB-INF/jsp/public/page.jspf" %>
				 <s:form action="api_search" id="pageForm">
				 <s:hidden name="item" id="item"></s:hidden>
				</s:form> 
				<!--paging end-->
			</div>
		</div>
	</div>
	<!--页脚-->
	<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>
</body>
</html>
