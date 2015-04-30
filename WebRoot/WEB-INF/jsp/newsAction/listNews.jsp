<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>api</title>
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/search.js"></script>
<script src="js/page.js"></script>
<script src="js/public.js"></script>
<script src="js/logout.js"></script>

<style type="text/css">
.news-main{ margin-bottom:30px; }
.juheapi_rightbox{
	padding:20px; border:1px solid #eee; background: #f8f8f8; margin-bottom: 10px; font-size: 12px; overflow: hidden;
}
.juheapi_rightbox h2{height: 16px; font:16px/16px "microsoft yahei"; margin-bottom: 20px; border-left: 4px solid #00B7EE; color: #555; padding-left: 4px;}
.juheapi_rightbox ul li{ margin-bottom:5px; height:25px; overflow:hidden; line-height:25px;border-bottom:1px dotted #f2f2f2; font-family:Microsoft Yahei; color:#666;letter-spacing:1px; font-size:12px;}
.juheapi_rightbox ul li img{ border-radius:2px; border:0;}
.juheapi_rightbox ul li a{ color:#666}


.juheapi_other{ padding:10px; border:1px solid #eee; background: #FFF; margin-bottom: 10px; font-size: 12px;}
.juheapi_other h2{ font: 16px/16px "microsoft yahei"; margin-bottom: 10px; border-left: 4px solid #00B7EE; color: #555; padding-left: 4px;}
.juheapi_other .p{ padding:5px 0px 5px 15px;line-height: 20px; font-size:14px; letter-spacing:1px; border-bottom:1px dotted #D1D1D1; margin-top:10px; background:url(/themes/images/2015/lni.png) left 10px no-repeat;}
.juheapi_other .p a{color: #555; width:100%;display:inline-block;  text-overflow:ellipsis; }
.juheapi_other .more{color:#00B7EE;}
.juheapi_other .m{ line-height:30px; height:30px}
pre {
white-space: pre-wrap;
word-wrap: break-word;
}
</style>
</head>

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
					你好，${user.nickname }&nbsp;&nbsp; <a href="user_logout.action"
						name="logout" id="logout">退出</a>
				</div>
			</s:else>
		</div>
		<div class="row">
			<ul class="nav nav-pills nav-justified">
				<li role="presentation"><a href="index.jsp">首页</a></li>
				<li role="presentation" ><a href="api_list.action">数据接口API</a></li>
				<li role="presentation"><a href="problem_list.action">常见问题</a></li>
				<li role="presentation" class="active"><a href="news_list.action">资讯&amp;动态</a></li>
			</ul>
		</div>
		<div class="row">
		<div class="col-xs-8 col-xs-offset-2">
			<div class="newboxmain-l" style=" margin-left:10px;border-radius:2px;margin-top:30px; float:left; width:700px; background:#ffffff; overflow:hidden">
            <div class="news-fullsimpleline" style="margin-top:10px;"><strong>${news.title }</strong>&nbsp;</div>
                
            <div class="news-main">
                    <div class="addtime">发布者：${news.author.nickname}&nbsp;&nbsp;&nbsp;&nbsp;发布：${news.postTime }</div>
                    <div class="new-tags">
                                                <div class="clear"></div>
                    </div>
                    <div class="content">
                        <p><span style="font-family:宋体"><pre >${news.content }</pre></span></p>
                        <div class="clear"></div>
                    </div> 
                    
                    
                   <div class="comment">
                  
                   </div> 
               
            </div>
           </div>
        </div>
        </div>
    </div>
    <!--页脚-->
	<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>
</body>
</html>