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
						href="problem_listMy.action?userId=${user.id }" id="listMy"
						class="sel">我的问题</a> <a href="index.jsp">首页</a> <a
						href="problem_askUI.action" style="float:right; margin-right:0;">找不到答案？这里提问</a>
					<div class="clear"></div>
				</div>
			</div>
			<div class="row">
				<div class="main">
					<div class="left">
						<div class="info">我提交的问题</div>
						<s:iterator value="#problemList">
							<div class="qabox">
								<div class="qaleft">
									<div class="recount">${replyCount }</div>
								</div>
								<div class="qaright">
									<div class="qa_title">
										<a href="problem_listById.action?id=${id }">${title }</a>
									</div>
									<div class="qa_base">
										<a class="iviews"></a> <a>${views }次浏览</a> <a class="itime"></a>
										<a>${postTime }</a>
									</div>
								</div>
								<div class="clear"></div>
							</div>

						</s:iterator>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!--页脚-->
	<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>
</body>
</html>
