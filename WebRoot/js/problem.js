$(function() {
	
	//若已登录 则跳转  否则提示先登录
	$("#askUI").click(function(e){
		var flag=$("#isLogin").val();
		if(flag==1){
			bootbox.alert("请先登录");
			return false;
		}
		return true;
	});
	
	$("#listMy").click(function(e){
		var flag=$("#isLogin").val();
		if(flag==1){
			bootbox.alert("请先登录");
			return false;
		}
		return true;
	});
	
	
	//若已登录 则跳转  否则提示先登录
	$("#askBtn").click(function(){
		var flag=$("#isLogin").val();
		if(flag==1){
			bootbox.alert("请先登录");
			return false;
		}
		var form=$("#askForm");
		$.ajax({
			url:'problem_ask.action',
			type:'POST',
			async :false,
			data:form.serialize(),
			success: function(res){
				var data=eval("("+res+")");
				bootbox.alert(data.msg);
			},
			error: function(){bootbox.alert("提问失败，请稍候重试！");}
		});
		return false;
	});
	
});
