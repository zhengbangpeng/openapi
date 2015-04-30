<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<body style="width:50px">
<form class="form-horizontal" id="loginForm"  method="post" action="user_login.action">
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">用户名</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="username" id="username"
				  required>
		</div>
	</div>
	
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">密码</label>
		<div class="col-sm-6">
			<input type="password" class="form-control" name="password" id="password"
				  required>
		</div>
	</div>
	<div class="form-group"></div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="register">Login In</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form> 

</body>   

<script language="javascript">
$(function(){
	 $("#loginForm").submit(function(){
		var form=$(this);
		$.ajax({
			type:'POST',
			url:'user_login.action',
			data:form.serialize(),
			success: function(res){
				var data=eval("("+res+")");
				if(data.msg!=null){
					bootbox.alert(data.msg);
				}else{
					$("#modal").click();
					window.location=window.location;
				}
			},
			error: function(){$("#modal").click(); bootbox.alert("登录失败，请稍候重试！");}
		});
		return false;
	}); 
	
	/* $("#register").click(function(){
		 if($("#password1").val()!=$("#password2").val()){
		bootbox.alert("密码不一致");
		return false;
	}else{
		$("#registerForm").submit();
	} 
		
		return false;
	}); */
	
	
	$("#img").click(function(){
		$("#img").attr("src","verifyCode_getVerifyCode.action?t="+new Date());
	});
});

</script>

