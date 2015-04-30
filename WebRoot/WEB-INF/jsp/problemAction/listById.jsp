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
<script src="js/page.js"></script>
<script src="js/reply.js"></script>
</head>
<body>
	<div class="top">
		<div class="line1">
			<div class="logo">
				<p style="font-size:36px">Open API</p>
			</div>
			<div class="userinfo">

				<s:if test="#session.user==null">
					<div class="user">
						<a title="用户登录" data-dialog="" href="user_loginUI.action">登录</a> <a
							href="user_registerUI.action" title="注册会员" data-dialog="">注册</a>
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
						<input type="text" value="" placeholder="请输入问题关键字" class="keyword"
							name="item"><input type="submit" class="btn" value="搜索"
							id="sBtn">
					</form>
				</div>

			</div>
			<div class="clear"></div>
		</div>
		<div class="line2">
			<a href="problem_list.action">所有问题</a> <a
				href="problem_listMy.action?userId=${user.id }" id="listMy">我的问题</a>
			<a href="index.jsp">首页</a> <a href="problem_askUI.action"
				style="float:right; margin-right:0;" id="askUI">找不到答案？这里提问</a>
			<div class="clear"></div>
		</div>
	</div>
	<div class="main">
		<div class="left">
			<div class="info">${problem.title }</div>
			<div class="qades">
				<p>${problem.content }</p>
			</div>
			<div class="qabases">
				<a class="iviews"></a> <a>${problem.views }次浏览</a> <a class="itime"></a>
				<a>${problem.postTime }</a> <a class="iauthor"></a> <a>${problem.author.nickname }</a>
			</div>
			<div class="qabase" style="text-align:right;">
				<a href="#qaubb">我来回答</a>
			</div>

			<div class="info">${problem.replyCount }个回答</div>

			<s:iterator value="#replyList">
				<div class="answerbox" style="background:#f9f9f9">
					<div class="answerhtml">${content }</div>
					<!--<div class="aubaseinfo">1楼：已回答&nbsp;11-12&nbsp;&nbsp;&nbsp;&nbsp;作者：di****</div>-->
					<div class="aubaseinfo">
						<a class="itime"></a> <a>${postTime }</a> <a class="iauthor"></a>
						<a>${author.nickname }</a>
					</div>
				</div>
			</s:iterator>
			<s:if test="#session.user==null">
				<div class="info">你的回答</div>
				<div class="qaubb" id="qaubb">
					<div class="tinfo">如果您可以回答这问题，请在下方输入您的解答哦！</div>
					<div class="unlogin">
						请<a title="用户登录" data-dialog="" href="user_loginUI.action">登录</a>后回答此问题。
					</div>
				</div>
			</s:if>
			<s:else>
				<div class="info">你的回答</div>
				<div class="qaubb" id="qaubb">
					<div class="tinfo">如果您可以回答这问题，请在下方输入您的解答哦！</div>
					<form id="replyForm" method="post" action="reply_add.action">
						<input type="hidden" name="userId" value="${user.id }"> <input
							type="hidden" name="problemId" value="${problem.id }">
						<textarea id="elm1" name="content" rows="8" cols="80"
							style="width:520px; border:1"></textarea>
						<br /> <input type="submit" name="save" value="提交回答"
							id="answerBtn" class="qa-form-btn" />
						<div class="clear"></div>
					</form>
				</div>
			</s:else>
			<div class="clear"></div>
		</div>

	</div>
	<div class="clear"></div>

	<!--页脚-->
	<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>

</body>
</html>
