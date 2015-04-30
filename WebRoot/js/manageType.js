$(function(){
	//点击Add按钮 转到addUI页面
	$("#addUI").click(function(){
		location.href="manageType_addUI.action";
	});
	
	//删除type
	$(".deleteType").click(function(){
	var id=$(this).attr("value");
	var res=bootbox.confirm("您确定要删除该类型吗？",function(result){
		if(result){
		var data={};
		data["id"]=id;
		$.ajax({
				type:'POST',
				async:false,
				url:'manageType_delete.action',
				data:data,
				success: function(data){
					bootbox.alert(data);
					location.href="manageType_list.action";
					},
				error:function(){bootbox.alert("删除失败，请稍候重试！");}
			});
	}});
		return false;
	});
	
	//提交item搜索type
	$("#search").click(function(){
			$("#searchform").submit();
			return false;
		});
	
});