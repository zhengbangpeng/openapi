$(function() {
	//用户添加回复
	$("#replyForm").submit(function(){
		var form=$(this);
		$.ajax({
			url:'reply_add.action',
			type:'POST',
			async :false,
			data:form.serialize(),
			success: function(res){
				var data=eval("("+res+")");
				bootbox.alert(data.msg);
			},
			error: function(){bootbox.alert("回复失败，请稍候重试！");}
		});
		return false;
	});
	
});
