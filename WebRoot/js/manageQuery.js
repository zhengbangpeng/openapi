$(function(){

	$(".deleteQuery").click(function(){
		var id=$(this).attr("value");
		var res=bootbox.confirm("您确定要删除该查询方式吗？",function(result){
			if(result){
			var data={};
			data["id"]=id;
			$.ajax({
					type:'POST',
					async:false,
					url:'manageQuery_delete.action',
					data:data,
					success: function(data){
						bootbox.alert(data);
						},
					error:function(){bootbox.alert("删除失败，请稍候重试！");}
				});
		}});
		return false;
	});
	
});