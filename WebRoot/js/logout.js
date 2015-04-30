$(function() {
	$("#manageLogout").click(function(e){
		/*e.preventDefault();
		var res=bootbox.confirm("您确定要退出吗?",function(result){
			if(result==true) return true;
			else return false;
		});*/
		//bootbox.confirm 异步 未解决
		return true;
	});
	
	
	$("#logout").click(function() {
		var res = bootbox.confirm("您确定要退出吗？", function(result) {
			if (result) {
				$.ajax({
					type : 'POST',
					async : false,
					url : 'user_logout.action',
					success : function() {$("#modal").click();window.location=window.location;},
					error : function() {$("#modal").click();bootbox.alert("退出失败，请稍候重试！");}
				});
			}});
		return false;
	});
	
	
	
});
