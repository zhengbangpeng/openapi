$(function(){
	
	//管理员登录
	$("#loginForm").submit(function(){
		var form=$(this);
		$.ajax({
			url:'manageUser_login.action',
			type:'POST',
			async :false,
			data:form.serialize(),
			success: function(res){
				var data=eval("("+res+")");
				if(data.msg!=null){
					bootbox.alert(data.msg);
				}else{
					window.location="manageUser_index.action";
				}
			},
			error: function(){bootbox.alert("登录失败，请稍候重试！");}
		});
		
		return false;
	});
	
});