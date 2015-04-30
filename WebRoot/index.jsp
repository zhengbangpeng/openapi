<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/public.js"></script>
<script src="js/search.js"></script>
<script src="js/logout.js"></script>
<script src="js/SlideTrans.js"></script>
</head>
<body>
<style type="text/css"> 
.mycontainer, .mycontainer img{width:800px; height:500px;}
.mycontainer img{border:0;vertical-align:top;}
</style>
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
			<ul class="nav nav-pills nav-justified ">
				<li role="presentation" class="active"><a href="index.jsp">首页</a></li>
				<li role="presentation"><a href="api_list.action">数据接口API</a></li>
				<li role="presentation"><a href="problem_list.action">常见问题</a></li>
				<li role="presentation"><a href="news_list.action">资讯&amp;动态</a></li>
			</ul>
		</div>
		<div class="row">
			<div class="mycontainer" id="idContainer2">
	<ul id="idSlider2">
		<li><a href=""> <img src="img/index2.jpg" alt="图片上传预览" /> </a></li>
		<li><a href=""> <img src="img/index1.jpg" alt="图片上传预览" /> </a></li>
		<li><a href=""> <img src="img/parkbanner.jpg" alt="图片上传预览" /> </a></li>
		<li><a href=""> <img src="img/spring.png" alt="图片上传预览" /> </a></li>
		<li><a href=""> <img src="img/voicebanner.png" alt="图片上传预览" /> </a></li>
	</ul>
	<ul class="num" id="idNum">
	</ul>
</div>
		</div>
		<script>

var nums = [], timer, n = $$("idSlider2").getElementsByTagName("li").length,
	st = new SlideTrans("idContainer2", "idSlider2", n, {
		onStart: function(){//设置按钮样式
			forEach(nums, function(o, i){ o.className = st.Index == i ? "on" : ""; 
			});
		},
	});
for(var i = 1; i <= n; AddNum(i++)){};
function AddNum(i){
	var num = $$("idNum").appendChild(document.createElement("li"));
	num.innerHTML = i--;
	num.onmouseover = function(){
		timer = setTimeout(function(){ num.className = "on"; st.Auto = false; st.Run(i); }, 200);
	}
	num.onmouseout = function(){ clearTimeout(timer); num.className = ""; st.Auto = true; st.Run(); }
	nums[i] = num;
}
st.Run();
$$("idNext").onclick = function(){ st.Next(); }
$$("idPre").onclick = function(){ st.Previous(); }
$$("idTween").onchange = function(){
	switch (parseInt(this.value)){
		case 2 :
			st.Tween = Tween.Bounce.easeOut; break;
		case 1 :
			st.Tween = Tween.Back.easeOut; break;
		default :
			st.Tween = Tween.Quart.easeOut;
	}
}

</script>
		
<style type="text/css">
.mycontainer ul, .mycontainer li{list-style:none;margin:0;padding:0;}

.num{ position:absolute; right:5px; bottom:5px; font:12px/1.5 tahoma, arial; height:18px;}
.num li{
	float: left;
	color: #d94b01;
	text-align: center;
	line-height: 16px;
	width: 16px;
	height: 16px;
	font-family: Arial;
	font-size: 11px;
	cursor: pointer;
	margin-left: 3px;
	border: 1px solid #f47500;
	background-color: #fcf2cf;
}
.num li.on{
	line-height: 18px;
	width: 18px;
	height: 18px;
	font-size: 14px;
	margin-top:-2px;
	background-color: #ff9415;
	font-weight: bold;
	color:#FFF;
}
</style>
	</div>
	
	
	<!--页脚-->
	<%@ include file="/WEB-INF/jsp/public/footer.jspf" %>
	
</body>
</html>

