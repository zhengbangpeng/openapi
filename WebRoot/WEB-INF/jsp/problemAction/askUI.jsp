<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Question</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/qastyle.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/public.js"></script>
<script src="js/logout.js"></script>
<script src="js/problem.js"></script>
</head>
<body>

	<div class="container" style="width:100%" id="container">
		<div class="row">
			<div class="top">
				<div class="line1">
					<div class="logo">
						<p style="font-size:36px">Open API</p>
					</div>
					<div class="userinfo">
						<s:if test="#session.user==null">
							<div class="user">
								<a title="用户登录" data-dialog="" href="user_loginUI.action">登录</a>
								<a href="user_registerUI.action" title="注册会员" data-dialog="">注册</a>
								<input type="hidden" id="isLogin" value="1">
							</div>
						</s:if>
						<s:else>
							<div class="user">
								你好，${user.nickname }&nbsp;&nbsp; <a href="user_logout.action"
									name="logout" id="logout">退出</a> <input type="hidden"
									id="isLogin" value="0">
							</div>
						</s:else>

						<div class="search">
							<form method="post" action="problem_search.action">
								<input type="text" value="" placeholder="请输入问题关键字"
									class="keyword" name="item"><input type="submit"
									class="btn" value="搜索" id="sBtn">
							</form>
						</div>

					</div>
					<div class="clear"></div>
				</div>
				<div class="line2">
					<a href="problem_list.action">所有问题</a> <a
						href="problem_listMy.action?userId=${user.id }" id="listMy">我的问题</a>
					<a href="index.jsp">首页</a> <a href="problem_askUI.action"
						class="sel" style="float:right; margin-right:0;">找不到答案？这里提问</a>
					<div class="clear"></div>
				</div>
			</div>
			<div class="row">
				<div class="main">
					<div class="left">
						<div class="info">提一个问题</div>

						<div class="ask-tips-box">
							<ul>
								<li>· 为快速获得答案，我们推荐您先在本站内搜索相似问题的解答，或参考 开发文档</li>
								<li>· 如有API调用相关问题，您或许可以先参考 <a href="api_list.action"
									target="_blank">API文档</a></li>
								<li>· 如果以上都没有帮助，您可以继续您的提问</li>
							</ul>
						</div>


						<form id="askForm" method="post">
							<input type="hidden" id="userId" name="userId"
								value="${user.id }">
							<div class="ask-title">用一句简单明了的标题概括下你的问题:</div>
							<div class="ask-title-input">
								<input type="text" value="" name="title" id="qaTitle">&nbsp;<span
									id="qa-title-t"></span>
							</div>
							<div class="ask-title">问题:</div>
							<div class="qa-ubb">

								<textarea name="content" id="elm1" name="elm1" rows="12"
									cols="80" style="width: 520px"></textarea>
								<br />
								<br />


							</div>
							<div class="qa-ubb">
								<input type="button" name="save" value="提交问题" id="askBtn"
									class="qa-form-btn" /> <input type="reset" name="reset"
									value="重置" class="qa-form-btn" />
								<div class="clear"></div>
							</div>
						</form>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!--页脚-->
		<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>
</body>
</html>
