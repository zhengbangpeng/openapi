<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<form class="form-horizontal" id="registerForm"  method="post" action="user_register.action">
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">用户名</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="username" id="username"
				  required>
		</div>
	</div>
	<div class="form-group">
		<label for="nickname" class="col-sm-2 control-label">昵称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="nickname" id="nickname"
				  required>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">邮箱</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" name="email" id="email"
				  required >
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">密码</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" name="password" id="password"
				  required>
		</div>
	</div>
	<div class="form-group">
		<label for="password2" class="col-sm-2 control-label">重复密码</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" name="password2" id="password2"
				  required>
		</div>
	</div>
	<div>
		<label class="col-sm-2 control-label" for="jCaptchaResponse" style="padding-right: 25px;">验证码</label>
		<div class="col-sm-10 ">
			<div class="row">
			<div class="col-sm-4" style="padding-left: 5px;">
				<input type="text" name="userCode" class="form-control" placeholder="请输入验证码" required id="userCode"  >
			</div>
			<div class="col-sm-6">
				<img  src="verifyCode_getVerifyCode.action"  id="img"/>
			</div>
			</div>	
		</div>
	</div>
	<div class="form-group"></div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="register">Register</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			<button class="btn btn-danger"  data-dismiss="modal" id="modal"><i class="fa fa-close"></i> 关闭</button>
		</div>
	</div>
</form> 

   

<script language="javascript">
$(function(){
	 $("#registerForm").submit(function(){
	  if($("#password").val()!=$("#password2").val()){
		bootbox.alert("两次密码不一致");
		return false;
		}
		var form=$(this);
		$.ajax({
			type:'GET',
			url:'user_register.action',
			data:form.serialize(),
			success: function(data){
			bootbox.alert(data);
			},
			error: function(){/* $("#modal").click(); */bootbox.alert("注册失败，请稍候重试！");}
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

